package com.chatchain.controller;

import com.chatchain.model.Story;
import com.chatchain.model.WordForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StoryController
{
    @Autowired
    private Story story;

    @RequestMapping("/")
    public String index(@ModelAttribute WordForm wordForm, Model model)
    {
        model.addAttribute("story", story);
        return "index";
    }

    @RequestMapping("/{word}/upvote")
    public String upvote(@PathVariable String word)
    {
        story.vote(word, 1);
        return "redirect:/";
    }

    @RequestMapping("/{word}/downvote")
    public String downvote(@PathVariable String word)
    {
        story.vote(word, -1);
        return "redirect:/";
    }

    @RequestMapping(value = "/addword", method = RequestMethod.POST)
    public String addWord(@ModelAttribute WordForm wordForm, Model model)
    {
        story.addCandidate(wordForm.getWord().trim());
        return "redirect:/";
    }

    @RequestMapping("/restart")
    public String restart()
    {
        story.clear();
        return "redirect:/";
    }
}
