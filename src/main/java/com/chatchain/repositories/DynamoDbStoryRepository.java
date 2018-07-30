package com.chatchain.repositories;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.chatchain.models.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Repository
public class DynamoDbStoryRepository implements StoryRepository
{

    private final AmazonDynamoDB dynamoDB;

    @Value("${amazon.dynamodb.tableName}")
    private String tableName;

    @Autowired
    public DynamoDbStoryRepository(AmazonDynamoDB dynamoDB)
    {
        this.dynamoDB = dynamoDB;
    }

    @Override
    public boolean putStory(Story story)
    {
        List<AttributeValue> phrases = story.getPhrases().stream()
                .map(AttributeValue::new)
                .collect(toList());
        Map<String, AttributeValue> itemValues = Map.of(
                "Id", new AttributeValue().withS(story.getId().toString()),
                "TotalValue", new AttributeValue().withN(Long.toString(story.getTotalValue())),
                "Phrases", new AttributeValue().withL(phrases),
                "Period", new AttributeValue().withN(Integer.toString(story.getPeriod())),
                "ChronoUnit", new AttributeValue().withS(story.getChronoUnit().name())
        );

        PutItemRequest request = new PutItemRequest()
                .withTableName(tableName)
                .withItem(itemValues);

        dynamoDB.putItem(request);

        return true;
    }

    @Override
    public Story getStoryById(UUID id)
    {
        Map<String, AttributeValue> key = Map.of(
                "Id", new AttributeValue().withS(id.toString())
        );
        GetItemRequest request = new GetItemRequest()
                .withKey(key)
                .withTableName(tableName);
        try
        {
            Map<String, AttributeValue> returnedItem = dynamoDB.getItem(request).getItem();

            if (returnedItem != null)
            {
                Story story = new Story(
                        UUID.fromString(returnedItem.get("Id").getS()),
                        Integer.valueOf(returnedItem.get("Period").getN()),
                        getChronoUnitByName(returnedItem.get("ChronoUnit").getS())
                );
                story.setTotalValue(Long.valueOf(returnedItem.get("TotalValue").getN()));
                List<String> phrases = returnedItem.get("Phrases").getL().stream()
                        .map(AttributeValue::getS)
                        .filter(Objects::nonNull)
                        .collect(toList());
                story.setPhrases(phrases);
                return story;
            } else
            {
                System.out.format("No item found with the key %s!\n", id);
            }
        } catch (AmazonServiceException e)
        {
            System.err.println(e.getErrorMessage());
        }
        return null;
    }
}
