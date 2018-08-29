package com.chatchain.repositories;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import com.chatchain.models.Phrase;
import com.chatchain.models.Story;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static com.amazonaws.services.dynamodbv2.model.KeyType.HASH;
import static com.amazonaws.services.dynamodbv2.model.KeyType.RANGE;
import static com.chatchain.models.Story.*;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toList;

@Repository
public class DynamoDbStoryRepository implements StoryRepository
{
    private static final Logger LOGGER = LoggerFactory.getLogger(DynamoDbStoryRepository.class);

    private static final String ID = "Id";
    private static final String TOTAL_VALUE = "TotalValue";
    private static final String TITLE = "Title";
    private static final String PHRASES = "Phrases";
    private static final String CITATION = "Citation";
    private static final String PERIOD = "Period";
    private static final String CHRONO_UNIT = "ChronoUnit";
    private static final String TABLE_NAME = "ChatChain.Stories.test";
    private static final String SECONDARY_GLOBAL_INDEX_NAME = "ChatChain.Stories.byValue";

    private final AmazonDynamoDB dynamoDB;

    @Autowired
    public DynamoDbStoryRepository(AmazonDynamoDB dynamoDB)
    {
        this.dynamoDB = dynamoDB;
    }

    @Override
    public boolean putStory(Story story)
    {
        List<AttributeValue> phrases = story.getPhrases().stream()
                .map(phrase -> new AttributeValue().withM(Map.of(
                        "phrase", new AttributeValue().withS(phrase.getPhrase()),
                        "timestamp", new AttributeValue().withS(phrase.getTimestamp().toString()),
                        "totalEarned", new AttributeValue().withN(Long.toString(phrase.getTotalEarned()))
                )))
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
        } catch (ConditionalCheckFailedException e)
        {
            LOGGER.error("A condition specified in the operation could not be evaluated.", e);
        } catch (ProvisionedThroughputExceededException e)
        {
            LOGGER.error("Your request rate is too high.", e);
        } catch (ResourceNotFoundException e)
        {
            LOGGER.error("The operation tried to access a nonexistent table or index.", e);
        } catch (ItemCollectionSizeLimitExceededException e)
        {
            LOGGER.error("An item collection is too large.", e);
        } catch (InternalServerErrorException e)
        {
            LOGGER.error("An error occurred on the server side.", e);
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
                LOGGER.info("No story found with ID " + id.toString());
            }
        } catch (ProvisionedThroughputExceededException e)
        {
            LOGGER.error("Your request rate is too high", e);
        } catch (ResourceNotFoundException e)
        {
            LOGGER.error("The operation tried to access a nonexistent table or index.", e);
        } catch (InternalServerErrorException e)
        {
            LOGGER.error("An error occurred on the server side.", e);
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
        if (returnedItem.containsKey(PHRASES))
        {
            if (returnedItem.containsKey(PHRASES))
            {
                story.setPhrases(
                        returnedItem.get(PHRASES).getL().stream()
                                .map(AttributeValue::getM)
                                .filter(Objects::nonNull)
                                .map(map -> new Phrase(
                                        map.get("phrase").getS(),
                                        Instant.parse(map.get("timestamp").getS()),
                                        Long.valueOf(map.get("totalEarned").getN())
                                ))
                                .collect(toList())
                );
            }
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
        } catch (ProvisionedThroughputExceededException e)
        {
            LOGGER.error("Your request rate is too high", e);
        } catch (ResourceNotFoundException e)
        {
            LOGGER.error("The operation tried to access a nonexistent table or index.", e);
        } catch (InternalServerErrorException e)
        {
            LOGGER.error("An error occurred on the server side.", e);
        }
        return isNull(stories) ? new ArrayList<>() : stories;
    }

    @Override
    public void createStoryTable()
    {
        List<String> tables = dynamoDB.listTables().getTableNames();
        if (!tables.contains(TABLE_NAME))
        {
            CreateTableRequest request = new CreateTableRequest()
                    .withAttributeDefinitions(
                            new AttributeDefinition(ID, ScalarAttributeType.S),
                            new AttributeDefinition(TOTAL_VALUE, ScalarAttributeType.N))
                    .withKeySchema(
                            new KeySchemaElement(ID, HASH))
                    .withGlobalSecondaryIndexes(
                            new GlobalSecondaryIndex()
                                    .withIndexName(SECONDARY_GLOBAL_INDEX_NAME)
                                    .withKeySchema(
                                            new KeySchemaElement(ID, HASH),
                                            new KeySchemaElement(TOTAL_VALUE, RANGE))
                                    .withProvisionedThroughput(
                                            new ProvisionedThroughput(1L, 1L))
                                    .withProjection(new Projection().withProjectionType(ProjectionType.ALL)))

                    .withProvisionedThroughput(
                            new ProvisionedThroughput(1L, 1L))
                    .withTableName(TABLE_NAME);

            try
            {
                dynamoDB.createTable(request);
            } catch (ResourceInUseException e)
            {
                LOGGER.error("The operation conflicts with the resource's availability. For example, you attempted to recreate an existing table, or tried to delete a table currently in the CREATING state.", e);
            } catch (LimitExceededException e)
            {
                LOGGER.error("There is no limit to the number of daily on-demand backups that can be taken.", e);
            } catch (InternalServerErrorException e)
            {
                LOGGER.error("An error occurred on the server side.", e);
            }
        }
    }
}
