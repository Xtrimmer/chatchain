package com.chatchain.models;

import com.chatchain.services.StoryManagementService;

public class AddStoryRequest implements PaidRequest
{
    private static final double COST_IN_BTC = 0.0001;
    private String title;
    private String citation;
    private int period;
    private String redirectUrl;

    @Override
    public Invoice getInvoice(StoryManagementService storyManagementService)
    {
        Invoice invoice = new Invoice();
        invoice.setPrice(COST_IN_BTC);
        invoice.setItemDesc("Create new Story: " + title);
        invoice.setRedirectURL(redirectUrl);
        return invoice;
    }

    @Override
    public void processPaidRequest(StoryManagementService storyManagementService)
    {
        storyManagementService.addStory(this);
    }

    public String getRedirectUrl()
    {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl)
    {
        this.redirectUrl = redirectUrl;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title.length() > 50 ? title.substring(0, 50) : title;
    }

    public String getCitation()
    {
        return citation;
    }

    public void setCitation(String citation)
    {
        this.citation = citation.length() > 50 ? citation.substring(0, 50) : citation;
    }

    public int getPeriod()
    {
        return period;
    }

    public void setPeriod(int period)
    {
        this.period = period;
    }
}
