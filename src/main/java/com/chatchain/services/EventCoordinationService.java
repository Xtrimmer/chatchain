package com.chatchain.services;

import com.chatchain.models.Story;
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
    private final ScheduledExecutorService scheduledExecutorService;
    private final Map<Story, ScheduledFuture<?>> scheduledTasks;

    public EventCoordinationService()
    {
        this.scheduledExecutorService = new ScheduledThreadPoolExecutor(2);
        this.scheduledTasks = new HashMap<>();
    }

    public void scheduleUpdate(Story story, Runnable runnable)
    {
        cancelUpdate(story);
        ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, story.getPeriod(), story.getPeriod(), TimeUnit.of(story.getChronoUnit()));
        scheduledTasks.put(story, scheduledFuture);
    }

    private void cancelUpdate(Story story)
    {
        if (scheduledTasks.containsKey(story))
        {
            scheduledTasks.remove(story).cancel(false);
        }
    }
}
