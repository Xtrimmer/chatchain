package com.chatchain.shared;

import java.time.ZonedDateTime;

public interface DatedWeightedItem
{
    long getValue();
    ZonedDateTime getSubmittedDate();
}