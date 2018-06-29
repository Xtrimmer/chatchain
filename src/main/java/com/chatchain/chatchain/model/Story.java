package com.chatchain.chatchain.model;

import com.chatchain.chatchain.service.EventCoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.Instant.now;
import static java.util.Objects.nonNull;


@Component
public class Story
{
    private int period = 10;
    private EventCoordinationService eventCoordinationService;
    private Instant updateTime;
    private List<String> words = new ArrayList<>();
    private Set<CandidateWord> candidates = new HashSet<>();

    @Autowired
    public Story(EventCoordinationService eventCoordinationService)
    {
        updateTime = now().plus(period, ChronoUnit.MINUTES);
        eventCoordinationService.scheduleUpdate(this);
        this.eventCoordinationService = eventCoordinationService;
    }

    public int getPeriod()
    {
        return period;
    }

    public void setPeriod(int period)
    {
        this.period = period;
    }

    public void update()
    {
        Optional<CandidateWord> winner = candidates.stream().min(CandidateWord.CANDIDATE_WORD_COMPARATOR);
        if (winner.isPresent())
        {
            words.add(winner.get().getWord());
            candidates.clear();
        }
        updateTime = updateTime.plus(period, ChronoUnit.MINUTES);
    }

    @Override
    public String toString()
    {
        String story = words.stream().collect(Collectors.joining(" "));
        return story.length() > 0 ? story : "[Start a new story]";
    }

    public String getUpdateTime()
    {
        return updateTime.toString();
    }

    public void addCandidate(String word)
    {
        if (nonNull(word) && !word.isEmpty())
        {
            candidates.add(new CandidateWord(word));
        }
    }

    public void clear()
    {
        words.clear();
        candidates.clear();
        updateTime = now().plus(period, ChronoUnit.MINUTES);
        eventCoordinationService.scheduleUpdate(this);
    }

    public Set<CandidateWord> getCandidates()
    {
        return new TreeSet<>(candidates);
    }

    public void vote(String word, int weight)
    {
        Optional<CandidateWord> cantidateWord = candidates.stream().filter(c -> ("" + c.getWord().hashCode()).equals(word)).findFirst();
        cantidateWord.ifPresent(c -> c.setWeight(c.getWeight() + weight));
    }
}
