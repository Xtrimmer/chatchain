package com.chatchain.models;

import com.chatchain.services.StoryManagementService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PayServerRequestTest
{
    private static final String EXPECTED_CURRENCY = "BTC";
    private static final String EXPECTED_NOTIFICATION_URL = "http://www.notificationurl.com";

    private static PaidRequest mockPaidRequest;
    private static StoryManagementService mockStoryManagementService;
    private PayServerRequest payServerRequest;

    @BeforeAll
    static void beforeAll()
    {
        mockPaidRequest = mock(PaidRequest.class);
        mockStoryManagementService = mock(StoryManagementService.class);
        when(mockPaidRequest.getInvoice(mockStoryManagementService)).thenReturn(new Invoice());
    }

    @BeforeEach
    void setUp()
    {
        payServerRequest = new PayServerRequest(mockPaidRequest);
        payServerRequest.setNotificationUrl(EXPECTED_NOTIFICATION_URL);
        payServerRequest.setCurrency(EXPECTED_CURRENCY);
    }

    @Test
    void getInvoice()
    {
        Invoice actualInvoice = payServerRequest.getInvoice(mockStoryManagementService);
        assertEquals(EXPECTED_CURRENCY, actualInvoice.getCurrency());
        assertEquals(EXPECTED_NOTIFICATION_URL, actualInvoice.getNotificationURL());
    }

    @Test
    void processPaidRequest()
    {
        payServerRequest.processPaidRequest(mockStoryManagementService);
        verify(mockPaidRequest, times(1)).processPaidRequest(mockStoryManagementService);
    }
}