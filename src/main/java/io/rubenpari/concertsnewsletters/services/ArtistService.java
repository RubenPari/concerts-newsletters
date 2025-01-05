package io.rubenpari.concertsnewsletters.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import io.rubenpari.concertsnewsletters.models.Artist;
import io.rubenpari.concertsnewsletters.repositories.IArtistRepositories;

@Service
public class ArtistService implements IArtistService {

    private final IArtistRepositories artistRepositories;

    public ArtistService(IArtistRepositories artistRepositories) {
        this.artistRepositories = artistRepositories;
    }

    @Override
    public Artist findById(Integer id) {
        return artistRepositories.findById(id).orElse(null);
    }

    @Override
    public Artist findByName(String name) {
        return artistRepositories.findByName(name).orElse(null);
    }

    @Override
    public String save(Artist artist) {
        Artist existingArtist = artistRepositories.findById(artist.getId()).orElse(null);

        if (existingArtist != null) {
            throw new DataIntegrityViolationException("Artist with ID " + artist.getId() + " already exists");
        }

        artistRepositories.save(artist);

        return "Artist saved";
    }

    @Override
    public void deleteById(Integer id) {
        artistRepositories.deleteById(id);
    }

    @Override
    public Iterable<Artist> getAll() {
        return artistRepositories.findAll();
    }
}