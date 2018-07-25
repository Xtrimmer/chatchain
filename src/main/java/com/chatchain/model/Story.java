package com.chatchain.model;

import com.chatchain.service.EventCoordinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.Instant.now;
import static java.time.temporal.ChronoUnit.MINUTES;
import static java.util.Objects.nonNull;


@Component
public class Story
{
    private final EventCoordinationService eventCoordinationService;
    private final SimpMessagingTemplate template;
    private List<String> words = new ArrayList<>();
    private Set<CandidateWord> candidates = new HashSet<>();
    private int period = 10;
    private Instant updateTime;

    @Autowired
    public Story(EventCoordinationService eventCoordinationService, SimpMessagingTemplate template)
    {
        updateTime = now().plus(period, MINUTES);
        eventCoordinationService.scheduleUpdate(this);
        this.eventCoordinationService = eventCoordinationService;
        this.template = template;
    }

    public List<String> getWords()
    {
        return words;
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
        updateTime = updateTime.plus(period, MINUTES);
        template.convertAndSend("/topic/story", this);
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
        template.convertAndSend("/topic/story", this);
    }

    public void clear()
    {
        words.clear();
        candidates.clear();
        updateTime = now().plus(period, MINUTES);
        eventCoordinationService.scheduleUpdate(this);
        template.convertAndSend("/topic/story", this);
    }

    public Set<CandidateWord> getCandidates()
    {
        return new TreeSet<>(candidates);
    }

    public void vote(String word, int weight)
    {
        Optional<CandidateWord> candidateWord = candidates.stream()
                .filter(c -> c.getWord().equals(word))
                .findFirst();
        candidateWord.ifPresent(c -> c.setWeight(c.getWeight() + weight));
        template.convertAndSend("/topic/story", this);
    }
}
