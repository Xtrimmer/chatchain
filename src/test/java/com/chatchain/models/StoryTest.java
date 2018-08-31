package com.chatchain.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListSet;

import static com.chatchain.models.Story.*;
import static com.chatchain.models.VoteType.DOWNVOTE;
import static com.chatchain.models.VoteType.UPVOTE;
import static java.time.Instant.EPOCH;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

public class StoryTest
{
    private Story testStory = new Story();

    private static final List<Phrase> DEFAULT_PHRASE_LIST = List.of(
                new Phrase("This", Instant.now(), 12345l),
                new Phrase("is", Instant.now(), 12345l),
                new Phrase("a", Instant.now(), 12345l),
                new Phrase("phrase", Instant.now(), 12345l),
                new Phrase("list!", Instant.now(), 12345l)
        );

    @BeforeEach
    void beforeEach()
    {
        testStory = new Story(
                UUID.fromString("00000000-0000-0000-0000-000000000000"),
                DEFAULT_TITLE,
                DEFAULT_PERIOD,
                DEFAULT_CHRONO_UNIT
        );
    }

    @Test
    void getCitationTest()
    {
        String expectedCitation = Story.DEFAULT_CITATION;
        testStory.setCitation(expectedCitation);
        assertSame(expectedCitation, testStory.getCitation());
    }

    @Test
    void setCitationTest()
    {
        String expectedCitation = "Test Citation";
        testStory.setCitation(expectedCitation);
        assertSame(expectedCitation, testStory.getCitation());

        testStory.setCitation(null);
        assertSame(Story.DEFAULT_CITATION, testStory.getCitation());

        testStory.setCitation("");
        assertSame(Story.DEFAULT_CITATION, testStory.getCitation());
    }

    @Test
    void getTitleTest()
    {
        String expectedTitle = Story.DEFAULT_TITLE;
        testStory.setTitle(expectedTitle);
        assertSame(expectedTitle, testStory.getTitle());
    }

    @Test
    void setTitleTest()
    {
        String expectedTitle = "Test Title";
        testStory.setTitle(expectedTitle);
        assertSame(expectedTitle, testStory.getTitle());

        testStory.setTitle(null);
        assertSame(Story.DEFAULT_TITLE, testStory.getTitle());

        testStory.setTitle("");
        assertSame(Story.DEFAULT_TITLE, testStory.getTitle());
    }

    @Test
    void getTotalValueTest()
    {
        testStory.setPhrases(List.of(new Phrase("Test", Instant.now(), 1)));
        testStory.setCandidates(Set.of(new CandidatePhrase("Test", 1)));
        long expectedTotalValue = 2L;
        assertEquals(expectedTotalValue, testStory.getTotalValue());
    }

    @Test
    void getChronoUnitTest()
    {
        ChronoUnit expectedChronoUnit = DEFAULT_CHRONO_UNIT;
        testStory.setChronoUnit(expectedChronoUnit);
        assertSame(expectedChronoUnit, testStory.getChronoUnit());
    }

    @Test
    void setChronoUnitTest()
    {
        ChronoUnit expectedChronoUnit = HOURS;
        testStory.setChronoUnit(expectedChronoUnit);
        assertSame(expectedChronoUnit, testStory.getChronoUnit());

        testStory.setChronoUnit(null);
        assertSame(MINUTES, testStory.getChronoUnit());
    }

    @Test
    void getIdTest()
    {
        UUID expectedId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        assertEquals(expectedId, testStory.getId());
    }

    @Test
    void getPhrasesTest()
    {
        List<Phrase> expectedPhrases = DEFAULT_PHRASE_LIST;
        testStory.setPhrases(expectedPhrases);
        assertSame(expectedPhrases, testStory.getPhrases());
    }

    @Test
    void setPhrasesTest()
    {
        List<Phrase> expectedPhrases = DEFAULT_PHRASE_LIST;
        testStory.setPhrases(expectedPhrases);
        assertSame(expectedPhrases, testStory.getPhrases());
    }

    @Test
    void getPeriodTest()
    {
        int expectedPeriod = 25;
        testStory.setPeriod(expectedPeriod);
        assertEquals(expectedPeriod, testStory.getPeriod());
    }

    @Test
    void setPeriodTest()
    {
        int expectedPeriod;

        expectedPeriod = DEFAULT_PERIOD;
        testStory.setPeriod(0);
        assertEquals(expectedPeriod, testStory.getPeriod());

        expectedPeriod = DEFAULT_PERIOD;
        testStory.setPeriod(-100);
        assertEquals(expectedPeriod, testStory.getPeriod());

        expectedPeriod = 1;
        testStory.setPeriod(expectedPeriod);
        assertEquals(expectedPeriod, testStory.getPeriod());

        expectedPeriod = 3600;
        testStory.setPeriod(expectedPeriod);
        assertEquals(expectedPeriod, testStory.getPeriod());

        expectedPeriod = DEFAULT_PERIOD;
        testStory.setPeriod(3601);
        assertEquals(expectedPeriod, testStory.getPeriod());
    }

    @Test
    void updateTest()
    {
        testStory.setCandidates(new ConcurrentSkipListSet<>());
        Instant expectedUpdateTime = EPOCH.plus(DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
        testStory.setUpdateTime(EPOCH);
        testStory.update();
        assertEquals(expectedUpdateTime, testStory.getUpdateTime());

        testStory.setCandidates(new ConcurrentSkipListSet<>());
        assertFalse(testStory.update());
        assertEquals(0, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());

        Set<CandidatePhrase> candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First"));
        candidates.add(new CandidatePhrase("Second"));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(1, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
//        assertEquals("First", String.join(" ", testStory.getPhrases()));

        candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First", 100));
        candidates.add(new CandidatePhrase("Second", -100));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(2, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
//        assertEquals("First First", String.join(" ", testStory.getPhrases()));

        candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First", -100));
        candidates.add(new CandidatePhrase("Second", 100));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(3, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
        assertEquals("First First Second", testStory.toString());
    }

    @Test
    void toStringTest()
    {
        String expectedString = "This is a phrase list!";
        testStory.setPhrases(DEFAULT_PHRASE_LIST);
        assertEquals(expectedString, testStory.toString());
    }

    @Test
    void getUpdateTimeTest()
    {
        Instant expectedUpdateTime = EPOCH.plus(15, MINUTES);
        testStory.setUpdateTime(expectedUpdateTime);
        assertEquals(expectedUpdateTime, testStory.getUpdateTime());
    }

    @Test
    void setUpdateTimeTest()
    {
        Instant expectedUpdateTime = EPOCH.plus(30, MINUTES);
        testStory.setUpdateTime(expectedUpdateTime);
        assertEquals(expectedUpdateTime, testStory.getUpdateTime());
    }

    @Test
    void addCandidateTest()
    {
        testStory.setCandidates(new ConcurrentSkipListSet<>());

        assertThat(testStory.getCandidates(), hasSize(0));
        assertEquals(0, testStory.getTotalValue());

        CandidatePhrase actualCandidatePhrase = testStory.addCandidate(null);
        assertNull(actualCandidatePhrase);
        assertThat(testStory.getCandidates(), hasSize(0));

        actualCandidatePhrase = testStory.addCandidate("");
        assertNull(actualCandidatePhrase);
        assertThat(testStory.getCandidates(), hasSize(0));

        String expectedPhrase1 = "Test phrase 1";
        CandidatePhrase candidatePhrase1 = new CandidatePhrase(expectedPhrase1, 1000);
        actualCandidatePhrase = testStory.addCandidate(candidatePhrase1.getPhrase());
        testStory.vote("Test phrase 1", 1000, VoteType.UPVOTE);
        assertNotNull(actualCandidatePhrase);
        assertThat(testStory.getCandidates(), hasSize(1));
        assertEquals(1001, testStory.getTotalValue());
        assertEquals(expectedPhrase1, candidatePhrase1.getPhrase());

        String expectedPhrase = "Test phrase 2";
        testStory.addCandidate(expectedPhrase);
        assertThat(testStory.getCandidates(), hasSize(2));
        assertEquals(1002, testStory.getTotalValue());
    }

    @Test
    void clearTest()
    {
        testStory.setPhrases(DEFAULT_PHRASE_LIST);
        testStory.setCandidates(Set.of(
                new CandidatePhrase("there"),
                new CandidatePhrase("was"),
                new CandidatePhrase("a")
        ));
        testStory.clear();
        assertThat(testStory.getPhrases(), hasSize(0));
        assertThat(testStory.getCandidates(), hasSize(0));
    }

    @Test
    void getCandidatesTest()
    {
        var expectedCandidates = Set.of(
                new CandidatePhrase("First", 1),
                new CandidatePhrase("Second", 2)
        );
        testStory.setCandidates(expectedCandidates);
        assertEquals(expectedCandidates, testStory.getCandidates());
    }

    @Test
    void setCandidatesTest()
    {
        var expectedCandidates = Set.of(
                new CandidatePhrase("Third", 3),
                new CandidatePhrase("Fourth", 4)
        );
        testStory.setCandidates(expectedCandidates);
        assertEquals(expectedCandidates, testStory.getCandidates());
    }

    @Test
    void voteTest()
    {
        var candidate1 = new CandidatePhrase("Candidate1", 1);
        var candidate2 = new CandidatePhrase("Candidate2", 2);
        var candidate3 = new CandidatePhrase("Candidate3", 4);
        var candidate4 = new CandidatePhrase("Candidate4", 8);
        testStory.setCandidates(Set.of(candidate1, candidate2, candidate3, candidate4));

        var expectedOrder = List.of("Candidate4", "Candidate3", "Candidate2", "Candidate1");
        var actualOrder = testStory.getCandidates().stream().map(CandidatePhrase::getPhrase).collect(toList());
        assertEquals(expectedOrder, actualOrder);

        testStory.vote("Candidate-5", 10, UPVOTE);
        assertEquals(expectedOrder, actualOrder);

        testStory.vote("Candidate1", 2, UPVOTE);
        expectedOrder = List.of("Candidate4", "Candidate3", "Candidate1", "Candidate2");
        actualOrder = testStory.getCandidates().stream().map(CandidatePhrase::getPhrase).collect(toList());
        assertEquals(expectedOrder, actualOrder);
        assertEquals(3, candidate1.getWeight());

        testStory.vote("Candidate4", 10, DOWNVOTE);
        expectedOrder = List.of("Candidate3", "Candidate1", "Candidate2", "Candidate4");
        actualOrder = testStory.getCandidates().stream().map(CandidatePhrase::getPhrase).collect(toList());
        assertEquals(expectedOrder, actualOrder);
        assertEquals(-2, candidate4.getWeight());
    }

    @Test
    void getTimeRemainingTest()
    {
        testStory.setUpdateTime(Instant.now().plus(60, MINUTES));
        assertTrue(testStory.getTimeRemaining() > 0);
    }
}