package com.chatchain.repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.amazonaws.services.dynamodbv2.model.*;
import com.chatchain.models.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.chatchain.models.Story.*;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Repository
public class LocalDynamoDbStoryRepository implements StoryRepository
{
    private static final String ID = "Id";
    private static final String TOTAL_VALUE = "TotalValue";
    private static final String TITLE = "Title";
    private static final String PHRASES = "Phrases";
    private static final String CITATION = "Citation";
    private static final String PERIOD = "Period";
    private static final String CHRONO_UNIT = "ChronoUnit";
    private static final String TABLE_NAME = "ChatChain.Stories";

    protected final AmazonDynamoDB dynamoDB;

    @Autowired
    public LocalDynamoDbStoryRepository(AmazonDynamoDB dynamoDB)
    {
        this.dynamoDB = dynamoDB;
        startEmbeddedDynamoDbServer();
        createStoryTable();
    }

    @Override
    public boolean putStory(Story story)
    {
        List<AttributeValue> phrases = story.getPhrases().stream()
                .map(AttributeValue::new)
                .collect(toList());
        Map<String, AttributeValue> itemValues = Map.of(
                ID, new AttributeValue().withS(story.getId().toString()),
                TOTAL_VALUE, new AttributeValue().withN(Long.toString(story.getTotalValue())),
                TITLE, new AttributeValue().withS(story.getTitle()),
                PHRASES, new AttributeValue().withL(phrases),
                CITATION, new AttributeValue().withS(story.getCitation()),
                PERIOD, new AttributeValue().withN(Integer.toString(story.getPeriod())),
                CHRONO_UNIT, new AttributeValue().withS(story.getChronoUnit().name())
        );

        PutItemRequest request = new PutItemRequest()
                .withTableName(TABLE_NAME)
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
                ID, new AttributeValue().withS(id.toString())
        );
        GetItemRequest request = new GetItemRequest()
                .withKey(key)
                .withTableName(TABLE_NAME);
        try
        {
            GetItemResult getItemResult = dynamoDB.getItem(request);
            Map<String, AttributeValue> returnedItem = getItemResult.getItem();

            if (returnedItem != null && returnedItem.containsKey(ID))
            {
                return mapStory(returnedItem);
            } else
            {
                System.out.format("No item found with the key %s!%n", id);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    private Story mapStory(Map<String, AttributeValue> returnedItem)
    {
        String title = returnedItem.containsKey(TITLE) ? returnedItem.get(TITLE).getS() : DEFAULT_TITLE;
        int period = returnedItem.containsKey(PERIOD) ? Integer.valueOf(returnedItem.get(PERIOD).getN()) : DEFAULT_PERIOD;
        ChronoUnit chronoUnit = returnedItem.containsKey(CHRONO_UNIT) ? ChronoUnit.valueOf(returnedItem.get(CHRONO_UNIT).getS()) : DEFAULT_CHRONO_UNIT;
        UUID id = UUID.fromString(returnedItem.get(ID).getS());
        Story story = new Story(id, title, period, chronoUnit);
        story.setTotalValue(Long.valueOf(returnedItem.get(TOTAL_VALUE).getN()));
        if (returnedItem.containsKey(PHRASES))
        {
            story.setPhrases(
                    returnedItem.get(PHRASES).getL().stream()
                            .map(AttributeValue::getS)
                            .filter(Objects::nonNull)
                            .collect(toList())
            );
        }
        if (returnedItem.containsKey(CITATION))
        {
            story.setCitation(returnedItem.get(CITATION).getS());
        }
        return story;
    }

    @Override
    public List<Story> getAllStories()
    {
        ScanRequest scanRequest = new ScanRequest()
                .withTableName(TABLE_NAME);

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

    private void startEmbeddedDynamoDbServer()
    {
        try
        {
            System.setProperty("sqlite4java.library.path", "native-libs");
            DynamoDBProxyServer server = ServerRunner.createServerFromCommandLineArgs(
                    new String[]{"-sharedDb"});
            server.start();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void createStoryTable()
    {
        List<String> tables = dynamoDB.listTables().getTableNames();
        if (!tables.contains(TABLE_NAME))
        {
            CreateTableRequest request = new CreateTableRequest()
                    .withAttributeDefinitions(
                            new AttributeDefinition("Id", ScalarAttributeType.S),
                            new AttributeDefinition("TotalValue", ScalarAttributeType.N))
                    .withKeySchema(
                            new KeySchemaElement("Id", KeyType.HASH))
                    .withGlobalSecondaryIndexes(
                            new GlobalSecondaryIndex()
                                    .withIndexName("ChatChain.Stories.byValue")
                                    .withKeySchema(
                                            new KeySchemaElement("Id", KeyType.HASH),
                                            new KeySchemaElement("TotalValue", KeyType.RANGE))
                                    .withProvisionedThroughput(
                                            new ProvisionedThroughput(1L, 1L))
                                    .withProjection(new Projection().withProjectionType(ProjectionType.ALL)))

                    .withProvisionedThroughput(
                            new ProvisionedThroughput(1L, 1L))
                    .withTableName(TABLE_NAME);

            dynamoDB.createTable(request);
        }
    }
}
