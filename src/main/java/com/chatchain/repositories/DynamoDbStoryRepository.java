package com.chatchain.repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.chatchain.models.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.chatchain.models.Story.*;
import static java.util.Objects.isNull;
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
                "Title", new AttributeValue().withS(story.getTitle()),
                "Phrases", new AttributeValue().withL(phrases),
                "Citation", new AttributeValue().withS(story.getCitation()),
                "Period", new AttributeValue().withN(Integer.toString(story.getPeriod())),
                "ChronoUnit", new AttributeValue().withS(story.getChronoUnit().name())
        );

        PutItemRequest request = new PutItemRequest()
                .withTableName(tableName)
                .withItem(itemValues);

        try
        {
            dynamoDB.putItem(request);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

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
            GetItemResult getItemResult = dynamoDB.getItem(request);
            Map<String, AttributeValue> returnedItem = getItemResult.getItem();

            if (returnedItem != null && returnedItem.containsKey("Id"))
            {
                Story story = mapStory(returnedItem);
                return story;
            } else
            {
                System.out.format("No item found with the key %s!\n", id);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private Story mapStory(Map<String, AttributeValue> returnedItem)
    {
        String title = returnedItem.containsKey("Title") ? returnedItem.get("Title").getS() : DEFAULT_TITLE;
        int period = returnedItem.containsKey("Period") ? Integer.valueOf(returnedItem.get("Period").getN()) : DEFAULT_PERIOD;
        ChronoUnit chronoUnit = returnedItem.containsKey("ChronoUnit") ? ChronoUnit.valueOf(returnedItem.get("ChronoUnit").getS()) : DEFAULT_CHRONO_UNIT;
        UUID id = UUID.fromString(returnedItem.get("Id").getS());
        Story story = new Story(id, title, period, chronoUnit);
        story.setTotalValue(Long.valueOf(returnedItem.get("TotalValue").getN()));
        if (returnedItem.containsKey("Phrases"))
        {
            story.setPhrases(
                    returnedItem.get("Phrases").getL().stream()
                            .map(AttributeValue::getS)
                            .filter(Objects::nonNull)
                            .collect(toList())
            );
        }
        if (returnedItem.containsKey("Citation"))
        {
            story.setCitation(returnedItem.get("Citation").getS());
        }
        return story;
    }

    @Override
    public List<Story> getAllStories()
    {
        ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName);

        List<Story> stories = null;

        try
        {
            stories = dynamoDB.scan(scanRequest).getItems().stream()
                    .map(this::mapStory)
                    .collect(toList());
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return isNull(stories) ? new ArrayList<>() : stories;
    }
}
