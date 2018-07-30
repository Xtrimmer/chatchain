package com.chatchain.configurations;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfiguration
{
    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDynamoDBEndpoint;

    @Value("${amazon.aws.accesskey}")
    private String amazonAWSAccessKey;

    @Value("${amazon.aws.secretkey}")
    private String amazonAWSSecretKey;

    @Value("${amazon.dynamodb.region}")
    private String amazonAWSRegion;

    @Bean
    public AmazonDynamoDB amazonDynamoDB(AWSStaticCredentialsProvider awsCredentials,
                                         AwsClientBuilder.EndpointConfiguration AwsDynamoDbEndpoint)
    {
        return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(awsCredentials)
                .withEndpointConfiguration(AwsDynamoDbEndpoint)
                .build();
    }

    @Bean
    public AwsClientBuilder.EndpointConfiguration AwsDynamoDbEndpoint()
    {
        return new AwsClientBuilder.EndpointConfiguration(amazonDynamoDBEndpoint, amazonAWSRegion);
    }

    @Bean
    public AWSStaticCredentialsProvider amazonAWSCredentials()
    {
        return new AWSStaticCredentialsProvider(new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey));
    }
}
