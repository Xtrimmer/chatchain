package com.chatchain.controller;

import com.chatchain.model.Story;
import com.chatchain.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class NotificationController
{
    @Autowired
    private Story story;

    @GetMapping("/story")
    public Story getNotification()
    {
        return story;
    }

    @PostMapping("/add")
    public void addPhrase(@RequestBody String phrase)
    {
        story.addCandidate(phrase.trim());
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote)
    {
        story.vote(vote.getPhrase().trim(), vote.getWeight() * vote.getWeightPolarity());
    }
}