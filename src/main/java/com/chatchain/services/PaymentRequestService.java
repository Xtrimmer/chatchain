package com.chatchain.services;

import com.chatchain.models.*;
import feign.Headers;
import feign.RequestLine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentRequestService.class);

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

    public Map<String, PaidRequest> getPaidRequestMap()
    {
        return paidRequestMap;
    }

    public void processStatusChange(Invoice invoice)
    {
        String invoiceId = invoice.getId();
        switch (invoice.getStatus())
        {
            case "new":
                LOGGER.info("New invoice created: " + invoiceId);
                break;
            case "paid":
                LOGGER.info("Invoice paid: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "confirmed":
                LOGGER.info("Invoice confirmed: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "complete":
                LOGGER.info("Invoice complete: " + invoiceId);
                processPaidRequest(invoiceId);
                break;
            case "expired":
                LOGGER.info("Invoice expired: " + invoiceId);
                paidRequestMap.remove(invoiceId);
                break;
            case "invalid":
                LOGGER.info("Invoice invalid: " + invoiceId);
                break;
            case "false":
                LOGGER.info("Invoice false: " + invoiceId);
                break;
            case "paidPartial":
                LOGGER.info("Invoice paidPartial: " + invoiceId);
                break;
            case "paidOver":
                LOGGER.info("Invoice paidOver: " + invoiceId);
                break;
        }
    }

    private void processPaidRequest(String id)
    {
        PaidRequest paidRequest = paidRequestMap.remove(id);
        if (nonNull(paidRequest))
        {
            paidRequest.processPaidRequest(storyManagementService);
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
