package com.chatchain.services;

import com.chatchain.models.CandidatePhrase;
import com.chatchain.models.NewStoryRequest;
import com.chatchain.models.Story;
import com.chatchain.models.Vote;
import com.chatchain.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

@Service
public class StoryManagementService
{
    private final Map<UUID, Story> storyMap = new ConcurrentHashMap<>();
    private final WebSocketPublisherService webSocketPublisherService;
    private final EventCoordinationService eventCoordinationService;
    private final StoryRepository storyRepository;

    @Autowired
    public StoryManagementService(WebSocketPublisherService webSocketPublisherService,
                                  EventCoordinationService eventCoordinationService,
                                  StoryRepository storyRepository)
    {
        this.webSocketPublisherService = webSocketPublisherService;
        this.eventCoordinationService = eventCoordinationService;
        this.storyRepository = storyRepository;

        addStories(storyRepository.getAllStories());
    }

    private void addStory(Story story)
    {
        storyMap.put(story.getId(), story);
        eventCoordinationService.scheduleUpdate(story, update(story));
    }

    private void addStories(Collection<Story> stories)
    {
        storyMap.putAll(
                stories.stream()
                        .peek(story -> eventCoordinationService.scheduleUpdate(story, update(story)))
                        .collect(toMap(Story::getId, identity()))
        );
    }

    private Runnable update(Story story)
    {
        return () ->
        {
            if (story.update())
            {
                storyRepository.putStory(story);
            }
            webSocketPublisherService.publish(story);
        };
    }

    public CandidatePhrase addCandidate(UUID storyId, String phrase)
    {
        Story story = storyMap.get(storyId);
        CandidatePhrase candidatePhrase = story.addCandidate(phrase.trim());
        webSocketPublisherService.publish(story);
        return candidatePhrase;
    }

    public Story vote(UUID storyId, Vote vote)
    {
        Story story = storyMap.get(storyId);
        story.vote(vote.getPhrase().trim(), vote.getWeight(), vote.getVoteType());
        webSocketPublisherService.publish(story);
        return story;
    }

    public void clear(UUID storyId)
    {
        Story story = storyMap.get(storyId);
        story.clear();
        eventCoordinationService.scheduleUpdate(story, update(story));
        webSocketPublisherService.publish(story);
    }

    public Story getStoryById(UUID id)
    {
        return storyMap.get(id);
    }

    public List<Story> getAllStories()
    {
        return storyMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted(comparing(Story::getTotalValue).reversed())
                .collect(Collectors.toList());
    }

    public Story addStory(NewStoryRequest request)
    {
        Story story = new Story(UUID.randomUUID(), request.getTitle(), request.getPeriod(), ChronoUnit.MINUTES);
        story.setCitation(request.getCitation());
        addStory(story);
        return story;
    }
}
