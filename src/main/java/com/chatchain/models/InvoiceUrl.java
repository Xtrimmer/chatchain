package com.chatchain.models;

public class InvoiceUrl
{
    private String invoiceUrl;
    private PaymentMethod defaultPaymentMethod;

    public InvoiceUrl(String invoiceUrl, PaymentMethod defaultPaymentMethod)
    {
        this.invoiceUrl = invoiceUrl;
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

    public String getInvoiceUrl()
    {
        return invoiceUrl + "&paymentMethodId=" + defaultPaymentMethod;
    }
}