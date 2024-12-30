package io.rubenpari.concertsnewsletters.services;

import java.util.List;

public interface IGeminiService {
    List<String> getResponse(String answer);
}
