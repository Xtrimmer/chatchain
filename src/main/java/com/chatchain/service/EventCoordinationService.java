package com.chatchain.service;

import com.chatchain.model.Story;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class EventCoordinationService
{
    private ScheduledExecutorService scheduledExecutorService;
    private Map<Story, ScheduledFuture<?>> scheduledTasks;

    public EventCoordinationService()
    {
        this.scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
        this.scheduledTasks = new HashMap<>();
    }

    public void scheduleUpdate(Story story)
    {
        cancelUpdate(story);
        scheduledTasks.put(story, scheduledExecutorService.scheduleAtFixedRate(story::update, story.getPeriod(), story.getPeriod(), TimeUnit.MINUTES));
    }

    public void cancelUpdate(Story story)
    {
        if (scheduledTasks.containsKey(story))
        {
            scheduledTasks.remove(story).cancel(false);
        }
    }
}