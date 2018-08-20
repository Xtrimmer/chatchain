package com.chatchain.models;

import java.util.Map;

public class CreateInvoiceResponse
{
    private String facade;
    private Map<String, Object> data;

    public String getFacade()
    {
        return facade;
    }

    public void setFacade(String facade)
    {
        this.facade = facade;
    }

    public Map<String, Object> getData()
    {
        return data;
    }

    public void setData(Map<String, Object> data)
    {
        this.data = data;
    }
}
