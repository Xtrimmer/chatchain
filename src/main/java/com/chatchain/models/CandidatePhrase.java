package com.chatchain.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Comparator;

public class CandidatePhrase implements Comparable<CandidatePhrase>
{
    public static final Comparator<CandidatePhrase> CANDIDATE_PHRASE_COMPARATOR = Comparator.comparing(CandidatePhrase::getWeight).reversed().thenComparing(CandidatePhrase::getCreated);
    private final String phrase;
    private final long created;
    private int weight;

    public CandidatePhrase(String phrase, int weight)
    {
        this.created = System.currentTimeMillis();
        this.phrase = phrase;
        this.weight = weight;
    }

    public CandidatePhrase(String phrase)
    {
        this(phrase, 1);
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

    @Override
    public int hashCode()
    {
        return phrase.hashCode();
    }

    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj, "created", "weight");
    }

    @Override
    public int compareTo(CandidatePhrase o)
    {
        return CANDIDATE_PHRASE_COMPARATOR.compare(this, o);
    }
}
