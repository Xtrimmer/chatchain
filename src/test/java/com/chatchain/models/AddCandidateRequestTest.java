package com.chatchain.models;

import com.chatchain.services.StoryManagementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AddCandidateRequestTest
{
    private static final String EXPECTED_PHRASE = "test phrase";
    private static final String EXPECTED_DESCRIPTION = "Add candidate phrase: " + EXPECTED_PHRASE;
    private static final String EXPECTED_REDIRECT_URL = "http://www.testredirecturl.com";
    private static final UUID EXPECTED_UUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static final double EXPECTED_PRICE = CandidatePhrase.calculateCost(EXPECTED_PHRASE);
    private static final long EXPECTED_EXPIRATION = 1000;
    private static StoryManagementService mockStoryManagementService;
    private AddCandidateRequest addCandidateRequest;

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
        addCandidateRequest = new AddCandidateRequest();
        addCandidateRequest.setPhrase(EXPECTED_PHRASE);
        addCandidateRequest.setRedirectUrl(EXPECTED_REDIRECT_URL);
        addCandidateRequest.setStoryId(EXPECTED_UUID);
    }

    @Test
    void getInvoice()
    {
        Invoice actualInvoice = addCandidateRequest.getInvoice(mockStoryManagementService);
        assertEquals(EXPECTED_DESCRIPTION, actualInvoice.getItemDesc());
        assertEquals(EXPECTED_REDIRECT_URL, actualInvoice.getRedirectURL());
        assertEquals(EXPECTED_PRICE / 100000000, actualInvoice.getPrice());
        assertEquals(EXPECTED_EXPIRATION, actualInvoice.getExpirationTime());
    }

    @Test
    void processPaidRequest()
    {
        addCandidateRequest.processPaidRequest(mockStoryManagementService);
        verify(mockStoryManagementService, times(1)).addCandidate(EXPECTED_UUID, EXPECTED_PHRASE);
    }
}