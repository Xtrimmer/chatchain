package com.chatchain.controllers;

import com.chatchain.models.*;
import com.chatchain.services.PaymentRequestService;
import com.chatchain.services.StoryManagementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static com.chatchain.models.InvoiceUrl.PaymentMethod.LIGHTNING;
import static com.chatchain.models.Story.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StoryControllerTest
{
    private static StoryManagementService storyManagementService = mock(StoryManagementService.class);
    private static PaymentRequestService paymentRequestService = mock(PaymentRequestService.class);
    private static UUID testUuid1 = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private static UUID testUuid2 = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private static Story testStory1 = new Story(testUuid1, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private static Story testStory2 = new Story(testUuid2, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private static InvoiceUrl testInvoiceUrl = new InvoiceUrl("http://www.invoiceurl.com", LIGHTNING);
    private StoryController testStoryController = new StoryController(storyManagementService, paymentRequestService);

    @BeforeAll
    static void setUp()
    {
        when(storyManagementService.getStoryById(testUuid1)).thenReturn(testStory1);
        when(storyManagementService.getAllStories()).thenReturn(List.of(testStory1, testStory2));

        when(paymentRequestService.addRequest(any(PaidRequest.class))).thenReturn(testInvoiceUrl);
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
        AddCandidateRequest testAddCandidateRequest = new AddCandidateRequest();
        InvoiceUrl actualInvoiceUrl = testStoryController.addCandidate(testAddCandidateRequest);
        assertEquals(testInvoiceUrl, actualInvoiceUrl);
    }

    @Test
    void addStory()
    {
        AddStoryRequest addStoryRequest = new AddStoryRequest();
        InvoiceUrl actualInvoiceUrl = testStoryController.addStory(addStoryRequest);
        assertEquals(testInvoiceUrl, actualInvoiceUrl);
    }

    @Test
    void vote()
    {
        VoteRequest voteRequest = new VoteRequest();
        InvoiceUrl actualInvoiceUrl = testStoryController.vote(voteRequest);
        assertEquals(testInvoiceUrl, actualInvoiceUrl);
    }

    @Test
    void processStatusChange()
    {
        Invoice invoice = new Invoice();
        testStoryController.processStatusChange(invoice);
        verify(paymentRequestService, times(1)).processStatusChange(invoice);
    }
}