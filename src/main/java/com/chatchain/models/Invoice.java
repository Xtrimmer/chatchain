package com.chatchain.models;

public class Invoice
{

    private String currency = "BTC";
    private String notificationURL = "http://127.0.0.1:8080/api/notification";
    private String fullNotifications = "true";
    private String id;
    private String status;
    private double price;
    private String itemDesc;
    private String redirectURL;
    private String url;
    private long expirationTime;

    public String getFullNotifications()
    {
        return fullNotifications;
    }

    public void setFullNotifications(String fullNotifications)
    {
        this.fullNotifications = fullNotifications;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public String getNotificationURL()
    {
        return notificationURL;
    }

    public void setNotificationURL(String notificationURL)
    {
        this.notificationURL = notificationURL;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getItemDesc()
    {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc)
    {
        this.itemDesc = itemDesc;
    }

    public String getRedirectURL()
    {
        return redirectURL;
    }

    public void setRedirectURL(String redirectURL)
    {
        this.redirectURL = redirectURL;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public long getExpirationTime()
    {
        return expirationTime;
    }

    public void setExpirationTime(long expirationTime)
    {
        this.expirationTime = expirationTime;
    }
}
