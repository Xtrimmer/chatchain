package com.chatchain.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoryErrorController implements ErrorController
{
    @RequestMapping("/error")
    public String handleError()
    {
        return "/";
    }

    @Override
    public String getErrorPath()
    {
        return "/error";
    }
}
