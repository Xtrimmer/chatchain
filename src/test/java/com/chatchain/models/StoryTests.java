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

public class StoryTests
{
    private Story testStory = new Story();

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
        long expectedTotalValue = 0L;
        testStory.setTotalValue(expectedTotalValue);
        assertEquals(expectedTotalValue, testStory.getTotalValue());
    }

    @Test
    void setTotalValueTest()
    {
        long expectedTotalValue = 1L;
        testStory.setTotalValue(expectedTotalValue);
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
        List<String> expectedPhrases = List.of("A", "long", "time", "ago");
        testStory.setPhrases(expectedPhrases);
        assertSame(expectedPhrases, testStory.getPhrases());
    }

    @Test
    void setPhrasesTest()
    {
        List<String> expectedPhrases = List.of("Once", "upon", "a", "time");
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
        assertEquals("First", String.join(" ", testStory.getPhrases()));

        candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First", 100));
        candidates.add(new CandidatePhrase("Second", -100));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(2, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
        assertEquals("First First", String.join(" ", testStory.getPhrases()));

        candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First", -100));
        candidates.add(new CandidatePhrase("Second", 100));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(3, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
        assertEquals("First First Second", String.join(" ", testStory.getPhrases()));
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
        testStory.setTotalValue(1000);

        CandidatePhrase candidatePhrase = testStory.addCandidate(null);
        assertThat(testStory.getCandidates(), hasSize(0));
        assertEquals(1000, testStory.getTotalValue());
        assertNull(candidatePhrase);

        candidatePhrase = testStory.addCandidate("");
        assertThat(testStory.getCandidates(), hasSize(0));
        assertEquals(1000, testStory.getTotalValue());
        assertNull(candidatePhrase);

        String expectedPhrase = "Test phrase";
        candidatePhrase = testStory.addCandidate(expectedPhrase);
        assertThat(testStory.getCandidates(), hasSize(1));
        assertEquals(1000 + CandidatePhrase.calculateCost(expectedPhrase), testStory.getTotalValue());
        assertEquals(expectedPhrase, candidatePhrase.getPhrase());
    }

    @Test
    void clearTest()
    {
        testStory.setPhrases(List.of("Once", "upon", "a", "time"));
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
}