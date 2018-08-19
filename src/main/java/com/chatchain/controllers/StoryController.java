package com.chatchain.controllers;

import com.chatchain.models.*;
import com.chatchain.services.PaymentRequestService;
import com.chatchain.services.StoryManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class StoryController
{
    private final StoryManagementService storyManagementService;
    private final PaymentRequestService paymentRequestService;

    @Autowired
    public StoryController(StoryManagementService storyManagementService,
                           PaymentRequestService paymentRequestService)
    {
        this.storyManagementService = storyManagementService;
        this.paymentRequestService = paymentRequestService;
    }

    @GetMapping("/story/{id}")
    public Story getStory(@PathVariable UUID id)
    {
        return storyManagementService.getStoryById(id);
    }

    @GetMapping("/stories")
    public List<Story> getStories()
    {
        return storyManagementService.getAllStories();
    }

    @PostMapping("/add/candidate/")
    public InvoiceUrl addCandidate(@RequestBody AddCandidateRequest addCandidateRequest)
    {
        return paymentRequestService.addRequest(addCandidateRequest);
    }

    @PostMapping("/add/story")
    public InvoiceUrl addStory(@RequestBody AddStoryRequest addStoryRequest)
    {
        return paymentRequestService.addRequest(addStoryRequest);
    }

    @PostMapping("/vote/")
    public InvoiceUrl vote(@RequestBody VoteRequest voteRequest)
    {
        return paymentRequestService.addRequest(voteRequest);
    }

    @PostMapping("/notification")
    public void processStatusChange(@RequestBody Invoice invoice)
    {
        paymentRequestService.processStatusChange(invoice);
    }
}