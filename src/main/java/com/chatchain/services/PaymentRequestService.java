package com.chatchain.services;

import com.chatchain.models.CreateInvoiceResponse;
import com.chatchain.models.Invoice;
import com.chatchain.models.InvoiceUrl;
import com.chatchain.models.PaidRequest;
import feign.Feign;
import feign.Headers;
import feign.RequestLine;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentRequestService
{
    private Map<String, PaidRequest> paidRequestMap = new HashMap<>();
    private StoryManagementService storyManagementService;

    @Autowired
    public PaymentRequestService(StoryManagementService storyManagementService)
    {
        this.storyManagementService = storyManagementService;
    }

    interface BtcPayServer
    {
        BtcPayServer api = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(BtcPayServer.class, "http://127.0.0.1:50008");

        @RequestLine("POST /invoices")
        @Headers({"Content-Type: application/json", "Authorization: Basic ZEg3SGtNVVFsMW9JUU9ycmwwUmhrN1liN1prbG9WYlpRUXlacFdoVjdkVQ=="})
        CreateInvoiceResponse createInvoice(Invoice invoice);
    }

    public InvoiceUrl addRequest(PaidRequest paidRequest)
    {
        Invoice invoice = paidRequest.getInvoice(storyManagementService);
        CreateInvoiceResponse response = BtcPayServer.api.createInvoice(invoice);
        String invoiceId = (String) response.getData().get("id");
        paidRequestMap.put(invoiceId, paidRequest);
        return new InvoiceUrl((String) response.getData().get("url"));
    }

    public void processStatusChange(Invoice invoice)
    {
        switch (invoice.getStatus())
        {
            case "new":
                System.out.println("New invoice created: " + invoice.getId());
                break;
            case "paid":
                System.out.println("Invoice paid: " + invoice.getId());
                processPaidRequest(invoice.getId());
                break;
            case "confirmed":
                System.out.println("Invoice confirmed: " + invoice.getId());
                break;
            case "complete":
                System.out.println("Invoice complete: " + invoice.getId());
                break;
            case "expired":
                System.out.println("Invoice expired: " + invoice.getId());
                paidRequestMap.remove(invoice.getId());
                break;
            case "invalid":
                System.out.println("Invoice invalid: " + invoice.getId());
                break;
            case "false":
                System.out.println("Invoice false: " + invoice.getId());
                break;
            case "paidPartial":
                System.out.println("Invoice paidPartial: " + invoice.getId());
                break;
            case "paidOver":
                System.out.println("Invoice paidOver: " + invoice.getId());
                break;
        }
    }

    private void processPaidRequest(String id)
    {
        PaidRequest paidRequest = paidRequestMap.get(id);
        paidRequest.processPaidRequest(storyManagementService);
    }
}