package com.chatchain.controllers;

import com.chatchain.models.Story;
import com.chatchain.models.Vote;
import com.chatchain.services.StoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NotificationController
{
    private final StoryManagementService storyManagementService;

    @Autowired
    public NotificationController(StoryManagementService storyManagementService)
    {
        this.storyManagementService = storyManagementService;
    }

    @GetMapping("/story")
    public Story getNotification()
    {
        return storyManagementService.getFirstStory();
    }

    @PostMapping("/add/{id}")
    public void addPhrase(@PathVariable UUID id, @RequestBody String phrase)
    {
        storyManagementService.addCandidate(id, phrase);
    }

    @PostMapping("/vote/{id}")
    public void vote(@PathVariable UUID id, @RequestBody Vote vote)
    {
        storyManagementService.vote(id, vote);
    }
}