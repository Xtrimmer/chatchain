package com.chatchain.models;

import org.apache.commons.lang3.builder.ToStringBuilder;

enum VoteType
{
    UPVOTE(1), DOWNVOTE(-1);

    private final int value;

    VoteType(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}

public class Vote
{
    private String phrase;
    private VoteType voteType;
    private int weight;

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }

    public VoteType getVoteType()
    {
        return voteType;
    }

    public void setVoteType(VoteType voteType)
    {
        this.voteType = voteType;
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
