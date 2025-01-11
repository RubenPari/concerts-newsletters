package io.rubenpari.concertsnewsletters.services;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import io.rubenpari.concertsnewsletters.models.Artist;
import io.rubenpari.concertsnewsletters.repositories.IArtistRepositories;

import java.util.Map;

@Service
public class ArtistService implements IArtistService {

    private final IArtistRepositories artistRepositories;

    public ArtistService(IArtistRepositories artistRepositories) {
        this.artistRepositories = artistRepositories;
    }

    @Override
    public Artist getById(Integer id) {
        return artistRepositories.findById(id).orElse(null);
    }

    @Override
    public Artist getByName(String name) {
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
    public String updatePartial(String id, Map<String, Object> updates) {
        Artist existingArtist = artistRepositories.findById(Integer.valueOf(id)).orElse(null);

        if (existingArtist == null) {
            throw new DataIntegrityViolationException("Artist with ID " + id + " does not exist");
        }

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    existingArtist.setName((String) value);
                    break;
                case "genre":
                    existingArtist.setGenre((String) value);
                    break;
                case "imageUrl":
                    existingArtist.setImageUrl((String) value);
                    break;
            }
        });

        artistRepositories.save(existingArtist);

        return "Artist updated";
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