package com.chatchain.repositories;

import com.chatchain.models.Story;

import java.util.UUID;

public interface StoryRepository
{
    boolean putStory(Story story);

    Story getStoryById(UUID id);
}
