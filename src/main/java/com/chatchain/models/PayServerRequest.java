package com.chatchain.models;

import com.chatchain.services.StoryManagementService;

public class PayServerRequest implements PaidRequest
{
    private PaidRequest paidRequest;
    private String currency;
    private String notificationUrl;

    public PayServerRequest(PaidRequest paidRequest)
    {
        this.paidRequest = paidRequest;
    }

    @Override
    public Invoice getInvoice(StoryManagementService storyManagementService)
    {
        Invoice invoice = paidRequest.getInvoice(storyManagementService);
        invoice.setCurrency(currency);
        invoice.setNotificationURL(notificationUrl);
        return invoice;
    }

    @Override
    public void processPaidRequest(StoryManagementService storyManagementService)
    {
        paidRequest.processPaidRequest(storyManagementService);
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public void setNotificationUrl(String notificationUrl)
    {
        this.notificationUrl = notificationUrl;
    }
}
