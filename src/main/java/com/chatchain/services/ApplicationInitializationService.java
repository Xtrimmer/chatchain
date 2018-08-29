package com.chatchain.services;

import com.chatchain.repositories.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationInitializationService implements CommandLineRunner
{
    private StoryRepository storyRepository;
    private StoryManagementService storyManagementService;

    @Autowired
    public ApplicationInitializationService(StoryRepository storyRepository, StoryManagementService storyManagementService)
    {
        this.storyRepository = storyRepository;
        this.storyManagementService = storyManagementService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        storyRepository.createStoryTable();
        storyManagementService.addStories(storyRepository.getAllStories());
    }
}
