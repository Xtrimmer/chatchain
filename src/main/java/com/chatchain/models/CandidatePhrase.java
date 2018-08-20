package com.chatchain.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CandidatePhrase implements Comparable<CandidatePhrase>
{
    public static final Comparator<CandidatePhrase> CANDIDATE_PHRASE_COMPARATOR = Comparator.comparing(CandidatePhrase::getWeight).reversed().thenComparing(CandidatePhrase::getCreated);
    private final String phrase;
    private final Instant created;
    private final long cost;
    private long positiveVotes;
    private long negativeVotes;

    public CandidatePhrase(String phrase, int weight)
    {
        this.created = Instant.now();
        this.phrase = phrase;
        this.cost = calculateCost(phrase);
        this.positiveVotes += weight;
    }

    public CandidatePhrase(String phrase)
    {
        this.created = Instant.now();
        this.phrase = phrase;
        this.cost = calculateCost(phrase);
        this.positiveVotes += 1;
    }

    public void addPositiveVotes(long amount)
    {
        positiveVotes += amount;
    }

    public void addNegativeVotes(long amount)
    {
        negativeVotes += amount;
    }

    public long getTotalVoteCount()
    {
        return positiveVotes + negativeVotes;
    }

    public long getCost()
    {
        return cost;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public Instant getCreated()
    {
        return created;
    }

    public long getWeight()
    {
        return positiveVotes - negativeVotes;
    }

    public static long calculateCost(String phrase)
    {
        List<Double> values = new ArrayList<>();

        values.add(0.0);
        values.add(0.02);

        for (int i = 2; i <= phrase.length(); i++)
        {
            values.add(values.get(i - 1) + values.get(i - 2));
        }

        return (long) Math.ceil(values.get(phrase.length()));
    }

    @Override
    public int hashCode()
    {
        return phrase.hashCode();
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (obj == this)
        {
            return true;
        }
        if (obj.getClass() != getClass())
        {
            return false;
        }
        CandidatePhrase rhs = (CandidatePhrase) obj;
        return EqualsBuilder.reflectionEquals(this, rhs, "created", "weight");
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int compareTo(CandidatePhrase o)
    {
        return CANDIDATE_PHRASE_COMPARATOR.compare(this, o);
    }
}
