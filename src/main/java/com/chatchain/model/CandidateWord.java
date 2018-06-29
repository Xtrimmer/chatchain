package com.chatchain.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Comparator;

public class CandidateWord implements Comparable<CandidateWord>
{
    public static final Comparator<CandidateWord> CANDIDATE_WORD_COMPARATOR = Comparator.comparing(CandidateWord::getWeight).reversed().thenComparing(CandidateWord::getCreated);
    private final String word;
    private final long created;
    private int weight;

    public CandidateWord(String word, int weight)
    {
        this.created = System.currentTimeMillis();
        this.word = word;
        this.weight = weight;
    }

    public CandidateWord(String word)
    {
        this(word, 1);
    }

    public String getWord()
    {
        return word;
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
        return word.hashCode();
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
    public int compareTo(CandidateWord o)
    {
        return CANDIDATE_WORD_COMPARATOR.compare(this, o);
    }
}
