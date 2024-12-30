package io.rubenpari.concertsnewsletters.controllers;

import io.rubenpari.concertsnewsletters.services.GeminiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/concerts")
public class ConcertsController {

    private final GeminiService geminiService;

    @Autowired
    public ConcertsController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @GetMapping("/artist")
    public List<String> generateContent(@RequestParam String artistName) {
        String answer = "Are there any concerts planned by the artist " + artistName + "for next month? Response should be a list of concerts cities like: \"New York\", \"Los Angeles\", \"Chicago\" ecc... If not concerts are planned, the response should be \"no concerts found\"";

        List<String> concerts = geminiService.getResponse(answer);

        if (concerts.isEmpty()) {
            return Collections.singletonList("No concerts found for the artist " + artistName);
        }

        return concerts;
    }
}
