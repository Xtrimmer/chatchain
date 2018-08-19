package com.chatchain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddStoryRequestTest
{
    private AddStoryRequest testRequest;

    @BeforeEach
    void setUp()
    {
        testRequest = new AddStoryRequest();
    }

    @Test
    void getTitle()
    {
        String expectedTitle = "Test Title";
        testRequest.setTitle(expectedTitle);
        assertEquals(expectedTitle, testRequest.getTitle());
    }

    @Test
    void setTitle()
    {
        String expectedTitle = "Another Test Title";
        testRequest.setTitle(expectedTitle);
        assertEquals(expectedTitle, testRequest.getTitle());

        expectedTitle = "Test title that has a length of 50 characters long";
        testRequest.setTitle("Test title that has a length of 50 characters long plus extra characters");
        assertEquals(expectedTitle, testRequest.getTitle());
    }

    @Test
    void getCitation()
    {
        String expectedCitation = "Test citation";
        testRequest.setCitation(expectedCitation);
        assertEquals(expectedCitation, testRequest.getCitation());
    }

    @Test
    void setCitation()
    {
        String expectedCitation = "Another Test citation";
        testRequest.setCitation(expectedCitation);
        assertEquals(expectedCitation, testRequest.getCitation());

        expectedCitation = "A test citation that has a length of 50 characters";
        testRequest.setCitation("A test citation that has a length of 50 characters plus extra characters");
        assertEquals(expectedCitation, testRequest.getCitation());
    }

    @Test
    void getPeriod()
    {
        int expectedPeriod = 10;
        testRequest.setPeriod(expectedPeriod);
        assertEquals(expectedPeriod, testRequest.getPeriod());
    }

    @Test
    void setPeriod()
    {
        int expectedPeriod = 20;
        testRequest.setPeriod(expectedPeriod);
        assertEquals(expectedPeriod, testRequest.getPeriod());
    }
}