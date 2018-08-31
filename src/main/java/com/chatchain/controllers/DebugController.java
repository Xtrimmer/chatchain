package com.chatchain.controllers;

import com.chatchain.models.PaidRequest;
import com.chatchain.services.PaymentRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/debug")
@CrossOrigin
public class DebugController
{
    private final PaymentRequestService paymentRequestService;

    @Autowired
    public DebugController(PaymentRequestService paymentRequestService)
    {
        this.paymentRequestService = paymentRequestService;
    }

    @GetMapping("/memory")
    public Map<String, Long> getMemoryInfo()
    {
        return Map.of("Total Memory", Runtime.getRuntime().totalMemory(), "Free Memory", Runtime.getRuntime().freeMemory());
    }

    @GetMapping("/paidrequests")
    public Map<String, PaidRequest> getPaidRequests()
    {
        return paymentRequestService.getPaidRequestMap();
    }

    @GetMapping("/paidrequests/size")
    public Map<String, Integer> getPaidRequestsCount()
    {
        return Map.of("Payment Request Size", paymentRequestService.getPaidRequestMap().size());
    }
}
