package com.chatchain.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Vote
{
    private String phrase;
    private int weightPolarity;
    private int weight;

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }

    public int getWeightPolarity()
    {
        return weightPolarity;
    }

    public void setWeightPolarity(int weightPolarity)
    {
        this.weightPolarity = weightPolarity;
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
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
}
