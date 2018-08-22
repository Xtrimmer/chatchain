package com.chatchain.configurations;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration
{
    @Value("${amazon.dynamodb.region}")
    private String amazonAWSRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB()
    {
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_WEST_2)
                .build();
    }
}
