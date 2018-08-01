package com.chatchain.models;

public class NewStoryRequest
{
    private String title;
    private String citation;
    private int period;

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
