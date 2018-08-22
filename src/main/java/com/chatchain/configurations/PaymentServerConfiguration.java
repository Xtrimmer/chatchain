package com.chatchain.configurations;

import com.chatchain.services.PaymentRequestService;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentServerConfiguration
{
    @Value("${payment.server.rootUrl}")
    private String payServerRootUrl;

    @Value("${payment.server.authentication}")
    private String authHeader;

    @Bean
    public PaymentRequestService.BtcPayServer getPaymentServer()
    {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .requestInterceptor(request -> request.header("Authorization", authHeader))
                .target(PaymentRequestService.BtcPayServer.class, payServerRootUrl);
    }
}
