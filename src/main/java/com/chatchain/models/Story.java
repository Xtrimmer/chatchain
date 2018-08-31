package com.chatchain.models;

import com.chatchain.services.story.weight.StoryWeightService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import static com.chatchain.models.VoteType.DOWNVOTE;
import static com.chatchain.models.VoteType.UPVOTE;
import static java.time.Instant.now;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;


public class Story
{
    public static final ChronoUnit DEFAULT_CHRONO_UNIT = ChronoUnit.MINUTES;
    public static final int DEFAULT_PERIOD = 10;
    public static final String DEFAULT_TITLE = "Title";
    public static final String DEFAULT_CITATION = "The syndicate of Satoshi's storytellers";

    private final UUID id;
    private String title;
    private List<Phrase> phrases = new CopyOnWriteArrayList<>();
    private SortedSet<CandidatePhrase> candidates = new ConcurrentSkipListSet<>();
    private String citation = DEFAULT_CITATION;
    private int period;
    private ChronoUnit chronoUnit;
    private Instant updateTime;

    public Story()
    {
        this(UUID.randomUUID(), DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
    }

    public Story(UUID id, String title, int period, ChronoUnit chronoUnit)
    {
        Objects.requireNonNull(id);
        this.id = id;
        setTitle(title);
        setChronoUnit(chronoUnit);
        setPeriod(period);
        updateTime = now().plus(period, chronoUnit);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }


    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(id, story.id);
    }

    @Override
    public String toString()
    {
        List<String> phrasesList = getPhrases().stream().map(Phrase::getPhrase).collect(Collectors.toList());
        return String.join(" ", phrasesList);
    }

    public List<Phrase> getPhrases()
    {
        return phrases;
    }

    public void setPhrases(List<Phrase> phrases)
    {
        this.phrases = phrases;
    }

    public String getCitation()
    {
        return citation;
    }

    public void setCitation(String citation)
    {
        this.citation = isNull(citation) || citation.isEmpty() ? DEFAULT_CITATION : citation;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = isNull(title) || title.isEmpty() ? DEFAULT_TITLE : title;
    }

    public long getTotalValue()
    {
        Long phrasesValue = phrases.stream()
                .mapToLong(phrase -> StoryWeightService
                        .getWeight(phrase.getTotalEarned(), phrase.getTimestamp()))
                .sum();

        Long candidateValue = getCandidates().stream()
                .mapToLong(candidate -> StoryWeightService
                        .getWeight(candidate.getTotalVoteCount(), candidate.getCreated()))
                .sum();

        return phrasesValue + candidateValue;
    }

    public SortedSet<CandidatePhrase> getCandidates()
    {
        return new TreeSet<>(candidates);
    }

    public void setCandidates(Set<CandidatePhrase> candidates)
    {
        this.candidates = new ConcurrentSkipListSet<>(candidates);
    }

    public ChronoUnit getChronoUnit()
    {
        return chronoUnit;
    }

    public void setChronoUnit(ChronoUnit chronoUnit)
    {
        this.chronoUnit = isNull(chronoUnit) ? DEFAULT_CHRONO_UNIT : chronoUnit;
    }

    public UUID getId()
    {
        return id;
    }

    public int getPeriod()
    {
        return period;
    }

    public void setPeriod(int period)
    {
        this.period = (period < 1 || period > 3600) ? DEFAULT_PERIOD : period;
        updateTime = now().plus(period, chronoUnit);
    }

    public boolean update()
    {
        boolean hasChange = !candidates.isEmpty();
        if (hasChange)
        {
            String winningPhraseText = candidates.first().getPhrase();
            long total = getCandidates().stream().mapToLong(CandidatePhrase::getTotalVoteCount).sum();

            Phrase winner = new Phrase(winningPhraseText, Instant.now(), total);
            phrases.add(winner);
            candidates.clear();
        }
        updateTime = updateTime.plus(period, chronoUnit);
        return hasChange;
    }

    public Instant getUpdateTime()
    {
        return updateTime;
    }

    public long getTimeRemaining()
    {
        return updateTime.toEpochMilli() - Instant.now().toEpochMilli();
    }

    public void setUpdateTime(Instant updateTime)
    {
        this.updateTime = updateTime;
    }

    public CandidatePhrase addCandidate(String phrase)
    {
        if (nonNull(phrase) && !phrase.isEmpty())
        {
            CandidatePhrase newPhrase = new CandidatePhrase(phrase);
            candidates.add(newPhrase);
            return new CandidatePhrase(phrase);
        }
        return null;
    }

    public void clear()
    {
        phrases = new ArrayList<>();
        candidates = new ConcurrentSkipListSet<>();
        updateTime = now().plus(period, chronoUnit);
    }

    public void vote(String phrase, int weight, VoteType voteType)
    {
        Optional<CandidatePhrase> candidateWord = candidates.stream()
                .filter(c -> c.getPhrase().equals(phrase))
                .findFirst();

        candidateWord.ifPresent(votedPhrase ->
        {
            synchronized (this)
            {
                candidates.remove(votedPhrase);
                if (voteType == UPVOTE)
                {
                    votedPhrase.addPositiveVotes(weight);
                } else if (voteType == DOWNVOTE)
                {
                    votedPhrase.addNegativeVotes(weight);
                }
                candidates.add(votedPhrase);
            }
        });
    }
}
