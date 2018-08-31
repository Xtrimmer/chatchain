package com.chatchain.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StoryWeightService
{
    //TODO: Move values to config
    private static final int PRIMARY_WEIGHT_DAYS = 2;
    private static final float PRIMARY_WEIGHT_MULTIPLIER = 1.0f;
    private static final int SECONDARY_WEIGHT_DAYS = 2;
    private static final float SECONDARY_WEIGHT_MULTIPLIER = 0.8f;
    private static final int TERTIARY_WEIGHT_DAYS = 10;
    private static final float TERTIARY_WEIGHT_MULTIPLIER = 0.65f;
    private static final int QUATERNARY_WEIGHT_DAYS = 30;
    private static final float QUATERNARY_WEIGHT_MULTIPLIER = 0.2f;
    private static final float FINAL_WEIGHT_MULTIPLIER = 0.05f;

    private StoryWeightService()
    {
    }

    public static long getWeight(long entryValue, Instant instant)
    {
        Long ageInDays = ChronoUnit.DAYS.between(instant, Instant.now());

        Float value;

        if (isBetween(ageInDays, 0, PRIMARY_WEIGHT_DAYS))
        {
            value = entryValue * PRIMARY_WEIGHT_MULTIPLIER;
        } else if (isBetween(ageInDays, PRIMARY_WEIGHT_DAYS, SECONDARY_WEIGHT_DAYS))
        {
            value = entryValue * SECONDARY_WEIGHT_MULTIPLIER;
        } else if (isBetween(ageInDays, SECONDARY_WEIGHT_DAYS, TERTIARY_WEIGHT_DAYS))
        {
            value = entryValue * TERTIARY_WEIGHT_MULTIPLIER;
        } else if (isBetween(ageInDays, TERTIARY_WEIGHT_DAYS, QUATERNARY_WEIGHT_DAYS))
        {
            value = entryValue * QUATERNARY_WEIGHT_MULTIPLIER;
        } else
        {
            value = entryValue * FINAL_WEIGHT_MULTIPLIER;
        }

        return value.longValue();
    }

    public static boolean isBetween(long value, long start, long end)
    {
        if ((value >= start) && (value < end))
        {
            return true;
        }
        return false;
    }
}


