package com.chatchain.models;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

import static com.chatchain.MockObjects.MOCK_STORY;
import static com.chatchain.models.Story.DEFAULT_CHRONO_UNIT;
import static com.chatchain.models.Story.DEFAULT_PERIOD;
import static java.time.Instant.EPOCH;
import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoryTest
{
    private Story testStory = MOCK_STORY;

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
        testStory.setPeriod(DEFAULT_PERIOD);
        testStory.setChronoUnit(DEFAULT_CHRONO_UNIT);
        testStory.setPhrases(new ArrayList<>());
        testStory.setCandidates(new HashSet<>());

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
        assertEquals("First", testStory.toString());

        candidates = new ConcurrentSkipListSet<>();
        candidates.add(new CandidatePhrase("First", 100));
        candidates.add(new CandidatePhrase("Second", -100));
        testStory.setCandidates(candidates);
        assertTrue(testStory.update());
        assertEquals(2, testStory.getPhrases().size());
        assertEquals(0, testStory.getCandidates().size());
        assertEquals("First First", testStory.toString());

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
        String expectedString = "Once upon a time";
        testStory.setPhrases(List.of("Once", "upon", "a", "time"));
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
        testStory.setCandidates(new HashSet<>());
        testStory.setTotalValue(1000);

        testStory.addCandidate(null);
        assertThat(testStory.getCandidates(), hasSize(0));
        assertEquals(1000, testStory.getTotalValue());

        testStory.addCandidate("");
        assertThat(testStory.getCandidates(), hasSize(0));
        assertEquals(1000, testStory.getTotalValue());

        String testPhrase = "Test phrase";
        testStory.addCandidate(testPhrase);
        assertThat(testStory.getCandidates(), hasSize(1));
        assertEquals(1000 + CandidatePhrase.calculateCost(testPhrase), testStory.getTotalValue());
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
        ConcurrentSkipListSet<CandidatePhrase> expectedCandidates = new ConcurrentSkipListSet<>(Set.of(
                new CandidatePhrase("First", 1),
                new CandidatePhrase("Second", 2)
        ));
        testStory.setCandidates(expectedCandidates);
        assertEquals(expectedCandidates, testStory.getCandidates());
    }

    @Test
    void setCandidatesTest()
    {
        ConcurrentSkipListSet<CandidatePhrase> expectedCandidates = new ConcurrentSkipListSet<>(Set.of(
                new CandidatePhrase("Third", 3),
                new CandidatePhrase("Fourth", 4)
        ));
        testStory.setCandidates(expectedCandidates);
        assertEquals(expectedCandidates, testStory.getCandidates());
    }

    @Test
    void voteTest()
    {

    }
}