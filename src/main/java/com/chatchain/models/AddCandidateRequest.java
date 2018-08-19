package com.chatchain.models;

import com.chatchain.services.StoryManagementService;

import java.util.UUID;

import static java.time.temporal.ChronoUnit.SECONDS;

public class AddCandidateRequest implements PaidRequest
{
    private String phrase;
    private String redirectUrl;
    private UUID storyId;

    @Override
    public Invoice getInvoice(StoryManagementService storyManagementService)
    {
        Invoice invoice = new Invoice();
        invoice.setPrice(CandidatePhrase.calculateCost(phrase) / SATOSHI_PER_BITCOIN);
        invoice.setRedirectURL(redirectUrl);
        invoice.setItemDesc("Add candidate phrase: " + phrase);
        long expirationTime = storyManagementService.getStoryById(storyId).getUpdateTime().minus(1, SECONDS).toEpochMilli();
        invoice.setExpirationTime(expirationTime);
        return invoice;
    }

    @Override
    public void processPaidRequest(StoryManagementService storyManagementService)
    {
        storyManagementService.addCandidate(storyId, phrase);
    }

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }

    public UUID getStoryId()
    {
        return storyId;
    }

    public void setStoryId(UUID storyId)
    {
        this.storyId = storyId;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase.trim();
    }
}
