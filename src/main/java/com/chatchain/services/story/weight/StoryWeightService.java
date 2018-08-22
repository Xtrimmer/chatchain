package com.chatchain.services.story.weight;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class StoryWeightService
{
    //TODO: Move values to config
    private static final int primaryWeightDays = 2;
    private static final float primaryWeightMultiplier = 1.0f;
    private static final int secondaryWeightDays = 2;
    private static final float secondaryWeightMultiplier = 0.8f;
    private static final int tertiaryWeightDays = 10;
    private static final float tertiaryWeightMultiplier = 0.65f;
    private static final int quaternaryWeightDays = 30;
    private static final float quaternaryWeightMultiplier = 0.2f;
    private static final float finalWeightMultiplier = 0.05f;

    public static long getWeight(long entryValue, Instant instant)
    {
        Long ageInDays = ChronoUnit.DAYS.between(instant, Instant.now());

        Float value;

        if (isBetween(ageInDays, 0, primaryWeightDays))
        {
            value = entryValue * primaryWeightMultiplier;
        } else if (isBetween(ageInDays, primaryWeightDays, secondaryWeightDays))
        {
            value = entryValue * secondaryWeightMultiplier;
        } else if (isBetween(ageInDays, secondaryWeightDays, tertiaryWeightDays))
        {
            value = entryValue * tertiaryWeightMultiplier;
        } else if (isBetween(ageInDays, tertiaryWeightDays, quaternaryWeightDays))
        {
            value = entryValue * quaternaryWeightMultiplier;
        } else
        {
            value = entryValue * finalWeightMultiplier;
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


