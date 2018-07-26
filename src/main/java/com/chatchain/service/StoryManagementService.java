package com.chatchain.service;

import com.chatchain.model.Story;
import com.chatchain.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class StoryManagementService
{
    private final Map<UUID, Story> storyMap = new HashMap<>();
    private final WebSocketPublisherService webSocketPublisherService;
    private final EventCoordinationService eventCoordinationService;

    @Autowired
    public StoryManagementService(WebSocketPublisherService webSocketPublisherService,
                                  EventCoordinationService eventCoordinationService)
    {
        this.webSocketPublisherService = webSocketPublisherService;
        this.eventCoordinationService = eventCoordinationService;
    }

    @Autowired
    public void addStory(Story story)
    {
        storyMap.put(story.getId(), story);
        eventCoordinationService.scheduleUpdate(story, update(story));
    }

    private Runnable update(Story story)
    {
        return () ->
        {
            story.update();
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
        story.vote(vote.getPhrase().trim(), vote.getWeight() * vote.getWeightPolarity());
        webSocketPublisherService.publish(story);
    }

    public void clear(UUID storyId)
    {
        Story story = storyMap.get(storyId);
        story.clear();
        eventCoordinationService.scheduleUpdate(story, update(story));
        webSocketPublisherService.publish(story);
    }

    public Story getFirstStory()
    {
        Optional<Map.Entry<UUID, Story>> story = storyMap.entrySet().stream().findFirst();
        return story.map(Map.Entry::getValue).orElse(null);
    }
}
