package com.chatchain.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class WordForm implements Serializable
{
    private String word;

    public String getWord()
    {
        return word;
    }

    public void setWord(String word)
    {
        this.word = word;
    }
}
