package com.chatchain.repositories;

import com.chatchain.models.Story;

import java.util.List;
import java.util.UUID;

public interface StoryRepository
{
    boolean putStory(Story story);

    Story getStoryById(UUID id);

    List<Story> getAllStories();

    void createStoryTable();
}
