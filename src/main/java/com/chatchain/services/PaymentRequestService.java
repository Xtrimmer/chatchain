package com.chatchain.services;

import com.chatchain.models.*;
import feign.Headers;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.chatchain.models.InvoiceUrl.PaymentMethod.LIGHTNING;
import static java.util.Objects.nonNull;

@Service
public class PaymentRequestService
{
    private Map<String, PaidRequest> paidRequestMap = new HashMap<>();
    private StoryManagementService storyManagementService;
    private BtcPayServer btcPayServer;

    @Value("${payment.server.currency}")
    private String currency;
    @Value("${payment.server.notificationUrl}")
    private String notificationUrl;

    @Autowired
    public PaymentRequestService(StoryManagementService storyManagementService,
                                 BtcPayServer btcPayServer)
    {
        this.storyManagementService = storyManagementService;
        this.btcPayServer = btcPayServer;
    }

    public interface BtcPayServer
    {
        @RequestLine("POST /invoices")
        @Headers("Content-Type: application/json")
        CreateInvoiceResponse createInvoice(Invoice invoice);
    }

    private void processPaidRequest(String id)
    {
        PaidRequest paidRequest = paidRequestMap.remove(id);
        if (nonNull(paidRequest))
        {
            paidRequest.processPaidRequest(storyManagementService);
        }
    }

    public void processStatusChange(Invoice invoice)
    {
        String invoiceId = invoice.getId();
        switch (invoice.getStatus())
        {
            case "new":
                System.out.println("New invoice created: " + invoiceId);
                break;
            case "paid":
                System.out.println("Invoice paid: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "confirmed":
                System.out.println("Invoice confirmed: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "complete":
                System.out.println("Invoice complete: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "expired":
                System.out.println("Invoice expired: " + invoiceId);
                paidRequestMap.remove(invoiceId);
                break;
            case "invalid":
                System.out.println("Invoice invalid: " + invoiceId);
                break;
            case "false":
                System.out.println("Invoice false: " + invoiceId);
                break;
            case "paidPartial":
                System.out.println("Invoice paidPartial: " + invoiceId);
                break;
            case "paidOver":
                System.out.println("Invoice paidOver: " + invoiceId);
                break;
        }
    }

    public InvoiceUrl addRequest(PaidRequest paidRequest)
    {
        PayServerRequest payServerRequest = new PayServerRequest(paidRequest);
        payServerRequest.setCurrency(currency);
        payServerRequest.setNotificationUrl(notificationUrl);
        Invoice invoice = payServerRequest.getInvoice(storyManagementService);
        CreateInvoiceResponse response = btcPayServer.createInvoice(invoice);
        String invoiceId = (String) response.getData().get("id");
        paidRequestMap.put(invoiceId, payServerRequest);
        return new InvoiceUrl((String) response.getData().get("url"), LIGHTNING);
    }
}
