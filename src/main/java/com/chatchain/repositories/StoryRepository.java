package com.chatchain.repositories;

import com.chatchain.models.Story;

import java.time.temporal.ChronoUnit;
import java.util.UUID;

public interface StoryRepository
{
    boolean putStory(Story story);

    Story getStoryById(UUID id);

    default ChronoUnit getChronoUnitByName(String name)
    {
        switch (name)
        {
            case "Nanos":
                return ChronoUnit.NANOS;
            case "Micros":
                return ChronoUnit.MICROS;
            case "Millis":
                return ChronoUnit.MILLIS;
            case "Seconds":
                return ChronoUnit.SECONDS;
            case "Minutes":
                return ChronoUnit.MINUTES;
            case "Hours":
                return ChronoUnit.HOURS;
            case "HalfDays":
                return ChronoUnit.HALF_DAYS;
            case "Days":
                return ChronoUnit.DAYS;
            case "Weeks":
                return ChronoUnit.WEEKS;
            case "Months":
                return ChronoUnit.MONTHS;
            case "Years":
                return ChronoUnit.YEARS;
            case "Decades":
                return ChronoUnit.DECADES;
            case "Centuries":
                return ChronoUnit.CENTURIES;
            case "Millennia":
                return ChronoUnit.MILLENNIA;
            case "Eras":
                return ChronoUnit.ERAS;
            case "Forever":
                return ChronoUnit.FOREVER;
            default:
                return ChronoUnit.MINUTES;
        }
    }
}
