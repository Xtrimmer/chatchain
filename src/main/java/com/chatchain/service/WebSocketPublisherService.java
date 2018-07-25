package com.chatchain.service;

import com.chatchain.model.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketPublisherService
{
    private static final String destinationPrefix = "/topic/story/";
    private final SimpMessagingTemplate template;

    @Autowired
    public WebSocketPublisherService(SimpMessagingTemplate template)
    {
        this.template = template;
    }

    public void publish(Story story)
    {
        String destination = destinationPrefix + story.getId();
        template.convertAndSend(destination, story);
    }
}
