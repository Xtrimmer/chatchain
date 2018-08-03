package com.chatchain.services.story.weight;

import com.chatchain.shared.DatedWeightedItem;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Collection;

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


    public static long getStoryWeightTotal(Collection<DatedWeightedItem> story)
    {
        long total = 0l;
        ZonedDateTime today = ZonedDateTime.now();

        for (DatedWeightedItem entry : story)
        {
            long entryValue = entry.getValue();
            long ageInDays = Duration.between(entry.getSubmittedDate(), today).toDays();

            if (isBetween(ageInDays, 0, primaryWeightDays)) {
                total += entryValue * primaryWeightMultiplier;
            } else if (isBetween(ageInDays, primaryWeightDays, secondaryWeightDays)) {
                total += entryValue * secondaryWeightMultiplier;
            } else if (isBetween(ageInDays, secondaryWeightDays, tertiaryWeightDays)) {
                total += entryValue * tertiaryWeightMultiplier;
            } else if (isBetween(ageInDays, tertiaryWeightDays, quaternaryWeightDays)) {
                total += entryValue * quaternaryWeightMultiplier;
            } else {
                total += entryValue * finalWeightMultiplier;
            }
        }
        return total;
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


