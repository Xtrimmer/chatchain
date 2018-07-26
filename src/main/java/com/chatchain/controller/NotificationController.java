package com.chatchain.controller;

import com.chatchain.model.Story;
import com.chatchain.model.Vote;
import com.chatchain.service.StoryManagementService;
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