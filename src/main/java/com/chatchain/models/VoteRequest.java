package com.chatchain.models;

import com.chatchain.services.StoryManagementService;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.UUID;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

public class VoteRequest implements PaidRequest
{
    private String phrase;
    private VoteType voteType;
    private int weight;
    private String redirectUrl;
    private UUID storyId;

    @Override
    public Invoice getInvoice(StoryManagementService storyManagementService)
    {
        Invoice invoice = new Invoice();
        invoice.setPrice(weight / SATOSHI_PER_BITCOIN);
        invoice.setItemDesc("Vote for phrase: " + phrase);
        invoice.setRedirectURL(redirectUrl);
        long expirationTime = storyManagementService.getStoryById(storyId).getUpdateTime().minus(1, SECONDS).toEpochMilli();
        invoice.setExpirationTime(expirationTime);
        return invoice;
    }

    @Override
    public void processPaidRequest(StoryManagementService storyManagementService)
    {
        storyManagementService.vote(storyId, this);
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
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
        this.phrase = phrase;
    }

    public VoteType getVoteType()
    {
        return voteType;
    }

    public void setVoteType(VoteType voteType)
    {
        this.voteType = voteType;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }
}
