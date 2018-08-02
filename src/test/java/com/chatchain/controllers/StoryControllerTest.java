package com.chatchain.controllers;

import com.chatchain.models.CandidatePhrase;
import com.chatchain.models.NewStoryRequest;
import com.chatchain.models.Story;
import com.chatchain.models.Vote;
import com.chatchain.services.StoryManagementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.chatchain.models.Story.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StoryControllerTest
{

    private static final String TEST_PHRASE = "Test phrase";
    private static StoryManagementService storyManagementService = mock(StoryManagementService.class);
    private static UUID testUuid1 = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static UUID testUuid2 = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static Story testStory1 = new Story(testUuid1, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private static Story testStory2 = new Story(testUuid2, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private static Vote testVote = new Vote();
    private StoryController testStoryController = new StoryController(storyManagementService);

    @BeforeAll
    static void setUp()
    {
        when(storyManagementService.getStoryById(testUuid1)).thenReturn(testStory1);
        when(storyManagementService.getAllStories()).thenReturn(List.of(testStory1, testStory2));
        when(storyManagementService.addCandidate(testUuid1, TEST_PHRASE)).thenReturn(new CandidatePhrase(TEST_PHRASE));
        when(storyManagementService.addStory(any(NewStoryRequest.class))).thenReturn(testStory1);
        when(storyManagementService.vote(testUuid1, testVote)).thenReturn(testStory1);
    }

    @Test
    void getStory()
    {
        Story actualStory = testStoryController.getStory(testUuid1);
        assertEquals(testStory1, actualStory);
    }

    @Test
    void getStories()
    {
        List<Story> actualStories = testStoryController.getStories();
        assertEquals(List.of(testStory1, testStory2), actualStories);
    }

    @Test
    void addCantidate()
    {
        CandidatePhrase expectedCandidatePhrase = new CandidatePhrase(TEST_PHRASE);
        CandidatePhrase actualCandidatePhrase = testStoryController.addCantidate(testUuid1, TEST_PHRASE);
        assertEquals(expectedCandidatePhrase, actualCandidatePhrase);
    }

    @Test
    void addStory()
    {
        NewStoryRequest testNewStoryRequest = new NewStoryRequest();
        Story expectedStory = testStory1;
        Story actualStory = testStoryController.addStory(testNewStoryRequest);
        assertEquals(expectedStory, actualStory);
    }

    @Test
    void vote()
    {
        Story expectedStory = testStory1;
        Story actualStory = testStoryController.vote(testUuid1, testVote);
        assertEquals(expectedStory, actualStory);
    }
}