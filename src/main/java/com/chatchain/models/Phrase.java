package com.chatchain.models;

import java.time.Instant;

public class Phrase
{
    private String phrase;
    private Instant timestamp;
    private long totalEarned;

    public Phrase(String phrase, Instant timestamp, long totalEarned)
    {
        this.phrase = phrase;
        this.timestamp = timestamp;
        this.totalEarned = totalEarned;
    }

    public String getPhrase()
    {
        return phrase;
    }

    public void setPhrase(String phrase)
    {
        this.phrase = phrase;
    }

    public Instant getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp)
    {
        this.timestamp = timestamp;
    }

    public long getTotalEarned()
    {
        return totalEarned;
    }

    public void setTotalEarned(long totalEarned)
    {
        this.totalEarned = totalEarned;
    }

    @Override
    public String toString()
    {
        return "Phrase{" +
                "phrase='" + phrase + '\'' +
                ", timestamp=" + timestamp +
                ", totalEarned=" + totalEarned +
                '}';
    }
}
