package com.chatchain.models;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;

import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.Objects.nonNull;


@Component
public class Story
{
    private final ChronoUnit chronoUnit = MINUTES;
    private UUID id;
    private List<String> phrases = new ArrayList<>();
    private int period = 10;
    private Set<CandidatePhrase> candidates = new HashSet<>();
    private Instant updateTime;

    public Story()
    {
        updateTime = now().plus(period, chronoUnit);
        this.id = UUID.randomUUID();
    }

    public ChronoUnit getChronoUnit()
    {
        return chronoUnit;
    }

    public UUID getId()
    {
        return id;
    }

    public void setId(UUID id)
    {
        this.id = id;
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
    }

    public void update()
    {
        Optional<CandidatePhrase> winner = candidates.stream().min(CandidatePhrase.CANDIDATE_PHRASE_COMPARATOR);
        if (winner.isPresent())
        {
            phrases.add(winner.get().getPhrase());
            candidates.clear();
        }
        updateTime = updateTime.plus(period, chronoUnit);
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
            candidates.add(new CandidatePhrase(phrase));
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

    public void vote(String phrase, int weight)
    {
        Optional<CandidatePhrase> candidateWord = candidates.stream()
                .filter(c -> c.getPhrase().equals(phrase))
                .findFirst();
        candidateWord.ifPresent(c -> c.setWeight(c.getWeight() + weight));
    }
}
