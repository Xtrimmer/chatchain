package com.chatchain.models;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.Instant.now;
import static java.util.Objects.nonNull;


public class Story
{
    private final UUID id;
    private List<String> phrases = new ArrayList<>();
    private Set<CandidatePhrase> candidates = new HashSet<>();
    private long totalValue;
    private int period;
    private ChronoUnit chronoUnit;
    private Instant updateTime;

    public Story(UUID id, int period, ChronoUnit chronoUnit)
    {
        this.id = id;
        this.period = period;
        this.chronoUnit = chronoUnit;
        updateTime = now().plus(period, chronoUnit);
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
        this.chronoUnit = chronoUnit;
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
        this.period = period;
        updateTime = now().plus(period, chronoUnit);
    }

    public boolean update()
    {
        Optional<CandidatePhrase> winner = candidates.stream().min(CandidatePhrase.CANDIDATE_PHRASE_COMPARATOR);
        boolean hasChange = false;
        if (winner.isPresent())
        {
            phrases.add(winner.get().getPhrase());
            candidates.clear();
            hasChange = true;
        }
        updateTime = updateTime.plus(period, chronoUnit);
        return hasChange;
    }

    @Override
    public String toString()
    {
        return String.join(" ", phrases);
    }

    public String getUpdateTime()
    {
        return updateTime.toString();
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
        this.candidates = candidates;
    }

    public void vote(String phrase, int weight, int polarity)
    {
        Optional<CandidatePhrase> candidateWord = candidates.stream()
                .filter(c -> c.getPhrase().equals(phrase))
                .findFirst();
        candidateWord.ifPresent(c ->
        {
            int polarizedWeight = weight * polarity;
            c.setWeight(c.getWeight() + polarizedWeight);
            totalValue += weight;
        });
    }
}
