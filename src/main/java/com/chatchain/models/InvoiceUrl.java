package com.chatchain.models;

public class InvoiceUrl
{
    private String url;
    private PaymentMethod defaultPaymentMethod;

    public InvoiceUrl(String url, PaymentMethod defaultPaymentMethod)
    {
        this.url = url;
        this.defaultPaymentMethod = defaultPaymentMethod;
    }

    public enum PaymentMethod
    {
        ON_CHAIN("BTC"),
        LIGHTNING("BTC_LightningLike");

        private final String value;

        PaymentMethod(String value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return this.value;
        }
    }

    public String getUrl()
    {
        return url + "&paymentMethodId=" + defaultPaymentMethod;
    }
}