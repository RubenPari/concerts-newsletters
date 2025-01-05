package io.rubenpari.concertsnewsletters.services;

import io.rubenpari.concertsnewsletters.models.Artist;

public interface IArtistService {
    Artist findById(Integer id);

    Artist findByName(String name);

    String save(Artist artist);

    void deleteById(Integer id);

    Iterable<Artist> getAll();
}