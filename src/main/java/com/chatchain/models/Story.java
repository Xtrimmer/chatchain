package com.chatchain.models;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

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
    private List<String> phrases = new ArrayList<>();
    private ConcurrentSkipListSet<CandidatePhrase> candidates = new ConcurrentSkipListSet<>(CandidatePhrase.CANDIDATE_PHRASE_COMPARATOR);
    private String citation = DEFAULT_CITATION;
    private volatile long totalValue;
    private int period;
    private ChronoUnit chronoUnit;
    private Instant updateTime;

    public Story(UUID id, String title, int period, ChronoUnit chronoUnit)
    {
        Objects.requireNonNull(id);
        this.id = id;
        setTitle(title);
        setChronoUnit(chronoUnit);
        setPeriod(period);
        updateTime = now().plus(period, chronoUnit);
    }

    public Story()
    {
        this(UUID.randomUUID(), DEFAULT_TITLE, DEFAULT_PERIOD, DEFAULT_CHRONO_UNIT);
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
        return totalValue;
    }

    public void setTotalValue(long totalValue)
    {
        this.totalValue = totalValue;
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

    public List<String> getPhrases()
    {
        return phrases;
    }

    public void setPhrases(List<String> phrases)
    {
        this.phrases = phrases;
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
            phrases.add(candidates.first().getPhrase());
            candidates.clear();
        }
        updateTime = updateTime.plus(period, chronoUnit);
        return hasChange;
    }

    @Override
    public String toString()
    {
        return String.join(" ", phrases);
    }

    public Instant getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(Instant updateTime)
    {
        this.updateTime = updateTime;
    }

    public void addCandidate(String phrase)
    {
        if (nonNull(phrase) && !phrase.isEmpty())
        {
            CandidatePhrase newPhrase = new CandidatePhrase(phrase);
            candidates.add(newPhrase);
            totalValue += newPhrase.getCost();
        }
    }

    public void clear()
    {
        phrases.clear();
        candidates.clear();
        updateTime = now().plus(period, chronoUnit);
    }

    public Set<CandidatePhrase> getCandidates()
    {
        return new TreeSet<>(candidates);
    }

    public void setCandidates(Set<CandidatePhrase> candidates)
    {
        this.candidates = new ConcurrentSkipListSet<>(candidates);
    }

    public void vote(String phrase, int weight, int polarity)
    {
        Optional<CandidatePhrase> candidateWord = candidates.stream()
                .filter(c -> c.getPhrase().equals(phrase))
                .findFirst();
        candidateWord.ifPresent(c ->
        {
            candidates.remove(c);
            int polarizedWeight = weight * polarity;
            c.setWeight(c.getWeight() + polarizedWeight);
            totalValue += weight;
            candidates.add(c);
        });
    }

    private Instant now()
    {
        return Instant.now();
    }
}
