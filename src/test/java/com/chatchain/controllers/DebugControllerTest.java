package com.chatchain.controllers;

import com.chatchain.models.PaidRequest;
import com.chatchain.models.PayServerRequest;
import com.chatchain.models.VoteRequest;
import com.chatchain.services.PaymentRequestService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DebugControllerTest
{
    private static PaymentRequestService mockPaymentRequestService;
    private DebugController debugController;

    @BeforeAll
    static void beforeAll()
    {
        mockPaymentRequestService = mock(PaymentRequestService.class);
        Map<String, PaidRequest> map = Map.of("String", new PayServerRequest(new VoteRequest()));
        when(mockPaymentRequestService.getPaidRequestMap()).thenReturn(map);
    }

    @BeforeEach
    void setUp()
    {
        debugController = new DebugController(mockPaymentRequestService);
    }

    @Test
    void getMemoryInfo()
    {
        Map<String, Long> map = debugController.getMemoryInfo();
        assertThat(map.size(), is(2));
    }

    @Test
    void getPaidRequests()
    {
        Map<String, PaidRequest> map = debugController.getPaidRequests();
        assertNotNull(map);
    }

    @Test
    void getPaidRequestsCount()
    {
        Map<String, Integer> map = debugController.getPaidRequestsCount();
        assertThat(map.size(), is(1));
    }
}