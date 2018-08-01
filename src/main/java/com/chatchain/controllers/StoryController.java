package com.chatchain.controllers;

import com.chatchain.models.NewStoryRequest;
import com.chatchain.models.Story;
import com.chatchain.models.Vote;
import com.chatchain.services.StoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StoryController
{
    private final StoryManagementService storyManagementService;

    @Autowired
    public StoryController(StoryManagementService storyManagementService)
    {
        this.storyManagementService = storyManagementService;
    }

    @GetMapping("/story/{id}")
    public Story getStory(@PathVariable UUID id)
    {
        return storyManagementService.getStoryById(id);
    }

    @GetMapping("/stories")
    public List<Story> getStories()
    {
        return storyManagementService.getAllStories();
    }

    @PostMapping("/add/candidate/{id}")
    public void addCantidate(@PathVariable UUID id, @RequestBody String phrase)
    {
        storyManagementService.addCandidate(id, phrase);
    }

    @PostMapping("/add/story")
    public void addStory(@RequestBody NewStoryRequest newStoryRequest)
    {
        storyManagementService.addStory(newStoryRequest);
    }

    @PostMapping("/vote/{id}")
    public void vote(@PathVariable UUID id, @RequestBody Vote vote)
    {
        storyManagementService.vote(id, vote);
    }
}