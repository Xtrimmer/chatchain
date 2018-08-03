package com.chatchain.repositories;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.local.main.ServerRunner;
import com.amazonaws.services.dynamodbv2.local.server.DynamoDBProxyServer;
import com.amazonaws.services.dynamodbv2.model.*;
import com.chatchain.models.Story;
import org.junit.jupiter.api.*;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.List;
import java.util.UUID;

import static com.chatchain.models.Story.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * In order to successfully run the test, it’s mandatory to have all the SQLite4Java libraries in the folder defined
 * by the sqlite4java.library.path system property. We must run Maven test-compile at least once to fulfill the
 * prerequisite.
 * <p>
 * $ mvn test-compile      <-- Run this command at least once before running unit tests
 */
class LocalDynamoDbStoryRepositoryTest
{
    private static DynamoDBProxyServer server;
    private static AmazonDynamoDB amazonDynamoDB;
    private UUID testUuid1 = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private UUID testUuid2 = UUID.fromString("11111111-1111-1111-1111-111111111111");
    private Story testStory1 = new Story(testUuid1, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private Story testStory2 = new Story(testUuid2, DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    private StoryRepository dynamoDbStoryRepository;

    @BeforeAll
    static void setUp() throws Exception
    {
        System.setProperty("sqlite4java.library.path", "native-libs");
        String port = "8000";
        server = ServerRunner.createServerFromCommandLineArgs(
                new String[]{"-inMemory", "-port", port, "-sharedDb"});
        server.start();
        amazonDynamoDB = AmazonDynamoDBClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("Key", "Secret")))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:8000/", "us-west-2"))
                .build();
    }

    @AfterAll
    static void tearDown() throws Exception
    {
        server.stop();
    }

    @BeforeEach
    void beforeEach()
    {
        dynamoDbStoryRepository = new LocalDynamoDbStoryRepository(amazonDynamoDB);
        ReflectionTestUtils.setField(dynamoDbStoryRepository, "tableName", "ChatChain.Stories");
        createStoryTable();
    }

    @AfterEach
    void afterEach() throws Exception
    {
        deleteTable();
    }

    @Test
    void putStory()
    {
        dynamoDbStoryRepository.putStory(testStory1);
        Story actualStory = dynamoDbStoryRepository.getStoryById(testUuid1);
        assertEquals(testStory1, actualStory);
    }

    @Test
    void getStoryById()
    {
        dynamoDbStoryRepository.putStory(testStory2);
        Story actualStory = dynamoDbStoryRepository.getStoryById(testUuid2);
        assertEquals(testStory2, actualStory);
    }

    @Test
    void getAllStories()
    {
        dynamoDbStoryRepository.putStory(testStory1);
        dynamoDbStoryRepository.putStory(testStory2);
        var expectedStories = List.of(testStory1, testStory2);
        var actualStories = dynamoDbStoryRepository.getAllStories();
        assertEquals(expectedStories, actualStories);
    }

    private void deleteTable() throws Exception
    {
        DynamoDB dynamoDB = new DynamoDB(amazonDynamoDB);
        Table table = dynamoDB.getTable("ChatChain.Stories");
        table.delete();
        table.waitForDelete();
    }

    private void createStoryTable()
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
                .withTableName("ChatChain.Stories");

        amazonDynamoDB.createTable(request);

        ListTablesResult tables = amazonDynamoDB.listTables();
        assertThat(tables.getTableNames(), hasSize(1));
    }
}