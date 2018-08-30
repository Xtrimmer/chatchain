package com.chatchain.models;

import com.chatchain.services.StoryManagementService;
import org.apache.commons.lang3.builder.ToStringBuilder;

import static org.apache.commons.lang3.builder.ToStringStyle.SHORT_PREFIX_STYLE;

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

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, SHORT_PREFIX_STYLE);
    }

    public PaidRequest getPaidRequest()
    {
        return paidRequest;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getNotificationUrl()
    {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl)
    {
        this.notificationUrl = notificationUrl;
    }
}
