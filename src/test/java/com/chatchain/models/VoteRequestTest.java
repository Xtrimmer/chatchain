package com.chatchain.models;

import com.chatchain.services.StoryManagementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static com.chatchain.models.VoteType.UPVOTE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VoteRequestTest
{
    private static final String EXPECTED_PHRASE = "test phrase";
    private static final String EXPECTED_DESCRIPTION = "Vote for phrase: " + EXPECTED_PHRASE;
    private static final String EXPECTED_REDIRECT_URL = "http://www.testredirecturl.com";
    private static final UUID EXPECTED_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static final int EXPECTED_PRICE = 1;
    private static final long EXPECTED_EXPIRATION = 1000;
    private static StoryManagementService mockStoryManagementService;
    private VoteRequest voteRequest;

    @BeforeAll
    static void beforeAll()
    {
        Story mockStory = mock(Story.class);
        when(mockStory.getUpdateTime()).thenReturn(Instant.ofEpochMilli(2000));
        mockStoryManagementService = mock(StoryManagementService.class);
        when(mockStoryManagementService.getStoryById(any(UUID.class))).thenReturn(mockStory);
    }

    @BeforeEach
    void setUp()
    {
        voteRequest = new VoteRequest();
        voteRequest.setPhrase(EXPECTED_PHRASE);
        voteRequest.setVoteType(UPVOTE);
        voteRequest.setWeight(EXPECTED_PRICE);
        voteRequest.setRedirectUrl(EXPECTED_REDIRECT_URL);
        voteRequest.setStoryId(EXPECTED_UUID);
    }

    @Test
    void getInvoice()
    {
        Invoice actualInvoice = voteRequest.getInvoice(mockStoryManagementService);

        assertEquals(EXPECTED_DESCRIPTION, actualInvoice.getItemDesc());
        assertEquals(EXPECTED_REDIRECT_URL, actualInvoice.getRedirectURL());
        assertEquals(EXPECTED_PRICE / 100000000.0, actualInvoice.getPrice());
        assertEquals(EXPECTED_EXPIRATION, actualInvoice.getExpirationTime());
    }

    @Test
    void processPaidRequest()
    {
        voteRequest.processPaidRequest(mockStoryManagementService);
        verify(mockStoryManagementService, times(1)).vote(EXPECTED_UUID, voteRequest);
    }
}