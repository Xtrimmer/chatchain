package com.chatchain;

import com.chatchain.models.Story;

import java.util.UUID;

import static com.chatchain.models.Story.*;

public class MockObjects
{
    public static final Story MOCK_STORY = new Story(
            UUID.fromString("00000000-0000-0000-0000-000000000000"),
            DEFAULT_TITLE,
            DEFAULT_PERIOD,
            DEFAULT_CHRONO_UNIT
    );
}
