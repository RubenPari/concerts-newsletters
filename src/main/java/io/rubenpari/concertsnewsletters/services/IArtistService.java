package io.rubenpari.concertsnewsletters.services;

import io.rubenpari.concertsnewsletters.models.Artist;

import java.util.Map;

public interface IArtistService {
    Artist getById(Integer id);

    Artist getByName(String name);

    Iterable<Artist> getAll();

    String save(Artist artist);

    String updatePartial(String id, Map<String, Object> updates);

    void deleteById(Integer id);
}