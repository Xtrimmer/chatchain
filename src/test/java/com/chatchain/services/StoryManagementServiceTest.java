package com.chatchain.services;

import com.chatchain.models.*;
import com.chatchain.repositories.StoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.chatchain.models.Story.*;
import static com.chatchain.models.VoteType.UPVOTE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StoryManagementServiceTest
{
    private static final UUID TEST_UUID_1 = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static final UUID TEST_UUID_2 = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static final String TEST_PHRASE = "Test phrase";
    private Story testStory1;
    private Story testStory2;

    private WebSocketPublisherService webSocketPublisherService = mock(WebSocketPublisherService.class);
    private EventCoordinationService eventCoordinationService = mock(EventCoordinationService.class);
    private StoryManagementService storyManagementService;

    @BeforeEach
    void setUp()
    {
        testStory1 = new Story(TEST_UUID_1, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
        testStory2 = new Story(TEST_UUID_2, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
        StoryRepository storyRepository = mock(StoryRepository.class);
        when(storyRepository.getAllStories()).thenReturn(List.of(testStory1, testStory2));
        storyManagementService = new StoryManagementService(webSocketPublisherService,
                eventCoordinationService, storyRepository);
        storyManagementService.addStories(storyRepository.getAllStories());
    }

    @Test
    void addCandidate()
    {
        CandidatePhrase expectedPhrase = new CandidatePhrase(TEST_PHRASE);
        CandidatePhrase actualCandidatePhrase = storyManagementService.addCandidate(TEST_UUID_1, TEST_PHRASE);
        assertEquals(expectedPhrase, actualCandidatePhrase);
        Story story = storyManagementService.getStoryById(TEST_UUID_1);
        assertThat(story.getCandidates(), contains(actualCandidatePhrase));
        verify(webSocketPublisherService, times(1)).publish(story);
    }

    @Test
    void vote()
    {
        storyManagementService.getStoryById(TEST_UUID_1).addCandidate(TEST_PHRASE);
        Vote vote = new Vote();
        vote.setPhrase(TEST_PHRASE);
        vote.setVoteType(UPVOTE);
        vote.setWeight(100);
        Story story = storyManagementService.vote(TEST_UUID_1, vote);
        Optional<CandidatePhrase> candidatePhrase = story.getCandidates().stream().filter(c -> c.getPhrase().equals(TEST_PHRASE)).findFirst();
        assertTrue(candidatePhrase.isPresent());
        assertEquals(101, candidatePhrase.get().getWeight());
        verify(webSocketPublisherService, times(1)).publish(story);
    }

    @Test
    void clear()
    {
        List<Phrase> phraseList = List.of(
                new Phrase("This", Instant.now(), 12345l),
                new Phrase("is", Instant.now(), 12345l),
                new Phrase("a", Instant.now(), 12345l),
                new Phrase("phrase", Instant.now(), 12345l),
                new Phrase("list!", Instant.now(), 12345l)
        );

        Story story = storyManagementService.getStoryById(TEST_UUID_1);
        story.addCandidate(TEST_PHRASE);
        story.setPhrases(phraseList);
        storyManagementService.clear(TEST_UUID_1);
        assertTrue(story.getCandidates().isEmpty());
        assertTrue(story.getPhrases().isEmpty());
        verify(webSocketPublisherService, times(1)).publish(story);
    }

    @Test
    void getStoryById()
    {
        Story expectedStory = testStory1;
        Story actualStory = storyManagementService.getStoryById(TEST_UUID_1);
        assertSame(expectedStory, actualStory);
    }

    @Test
    void getAllStories()
    {
        var expectedStories = List.of(testStory1, testStory2);
        var actualStories = storyManagementService.getAllStories();
        assertEquals(expectedStories, actualStories);
    }

    @Test
    void addStory()
    {
        String expectedTitle = "Title";
        String expectedCitation = "Citation";
        int expectedPeriod = 100;
        NewStoryRequest newStoryRequest = new NewStoryRequest();
        newStoryRequest.setTitle(expectedTitle);
        newStoryRequest.setCitation(expectedCitation);
        newStoryRequest.setPeriod(expectedPeriod);
        Story story = storyManagementService.addStory(newStoryRequest);

        assertNotNull(story);
        assertNotNull(story.getId());
        assertEquals(expectedPeriod, story.getPeriod());
        assertEquals(expectedCitation, story.getCitation());
        assertEquals(expectedTitle, story.getTitle());
    }
}