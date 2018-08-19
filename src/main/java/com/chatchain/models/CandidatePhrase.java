package com.chatchain.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CandidatePhrase implements Comparable<CandidatePhrase>
{
    public static final Comparator<CandidatePhrase> CANDIDATE_PHRASE_COMPARATOR = Comparator.comparing(CandidatePhrase::getWeight).reversed().thenComparing(CandidatePhrase::getCreated);
    private final String phrase;
    private final long created;
    private final long cost;
    private int weight;

    public CandidatePhrase(String phrase)
    {
        this(phrase, 1);
    }

    public CandidatePhrase(String phrase, int weight)
    {
        this.created = System.currentTimeMillis();
        this.phrase = phrase;
        this.weight = weight;
        this.cost = calculateCost(phrase);
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

    public long getCost()
    {
        return cost;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public long getCreated()
    {
        return created;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }
}
