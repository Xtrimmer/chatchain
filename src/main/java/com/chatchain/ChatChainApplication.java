package com.chatchain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChatChainApplication
{
    public static void main(String[] args)
    {
        System.out.println("Starting.");
        SpringApplication.run(ChatChainApplication.class, args);
    }
}
