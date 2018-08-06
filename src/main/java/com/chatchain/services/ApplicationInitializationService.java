package com.chatchain.services;

import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
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
        startEmbeddedDynamoDbServer();
        storyRepository.createStoryTable();
        storyManagementService.addStories(storyRepository.getAllStories());
    }

    private void startEmbeddedDynamoDbServer()
    {
        try
        {
            System.setProperty("sqlite4java.library.path", "native-libs");
            DynamoDBProxyServer server = ServerRunner.createServerFromCommandLineArgs(
                    new String[]{"-sharedDb"});
            server.start();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
