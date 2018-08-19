package com.chatchain.models;

import com.chatchain.services.StoryManagementService;

public interface PaidRequest
{
    double SATOSHI_PER_BITCOIN = 100000000;

    Invoice getInvoice(StoryManagementService storyManagementService);

    void processPaidRequest(StoryManagementService storyManagementService);
}
