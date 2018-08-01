package com.chatchain.services;

import com.chatchain.models.NewStoryRequest;
import com.chatchain.models.Story;
import com.chatchain.models.Vote;
import com.chatchain.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

@Service
public class StoryManagementService
{
    private final Map<UUID, Story> storyMap = new HashMap<>();
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

        addStory(storyRepository.getStoryById(UUID.fromString("a8246f9d-7f52-4423-885c-df196cdb7d06")));
        addStory(storyRepository.getStoryById(UUID.fromString("b8246f9d-7f52-4423-885c-df196cdb7d06")));
        addStory(storyRepository.getStoryById(UUID.fromString("c8246f9d-7f52-4423-885c-df196cdb7d06")));
    }

    public void addStory(Story story)
    {
        storyMap.put(story.getId(), story);
        eventCoordinationService.scheduleUpdate(story, update(story));
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

    public void addCandidate(UUID storyId, String phrase)
    {
        Story story = storyMap.get(storyId);
        story.addCandidate(phrase.trim());
        webSocketPublisherService.publish(story);
    }

    public void vote(UUID storyId, Vote vote)
    {
        Story story = storyMap.get(storyId);
        story.vote(vote.getPhrase().trim(), vote.getWeight(), vote.getWeightPolarity());
        webSocketPublisherService.publish(story);
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

    public void addStory(NewStoryRequest request)
    {
        Story story = new Story(UUID.randomUUID(), request.getTitle(), request.getPeriod(), ChronoUnit.MINUTES);
        story.setCitation(request.getCitation());
        addStory(story);
    }
}
