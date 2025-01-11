package io.rubenpari.concertsnewsletters.controllers;

import io.rubenpari.concertsnewsletters.exceptions.InvalidIdPathException;
import io.rubenpari.concertsnewsletters.exceptions.InvalidNamePathException;
import io.rubenpari.concertsnewsletters.models.Artist;
import io.rubenpari.concertsnewsletters.services.ArtistService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/all")
    public Iterable<Artist> getAll() {
        return artistService.getAll();
    }

    @GetMapping("/{id}")
    public Artist getById(@PathVariable String id) {
        if (id == null || !id.matches("\\d+")) {
            throw new InvalidIdPathException("Invalid ID: " + id);
        }

        return artistService.findById(Integer.valueOf(id));
    }

    @GetMapping("/name/{name}")
    public Artist getByName(@PathVariable String name) {
        if (name == null || name.isEmpty()) {
            throw new InvalidNamePathException("Invalid name: " + name);
        }

        return artistService.findByName(name);
    }

    @PostMapping("/new")
    public String save(@Valid @RequestBody Artist artist) {
        return artistService.save(artist);
    }

    @PatchMapping("/{id}")
    public String updatePartial(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        return artistService.updatePartial(id, updates);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        if (id == null || !id.matches("\\d+")) {
            throw new InvalidIdPathException("Invalid ID: " + id);
        }

        artistService.deleteById(Integer.valueOf(id));

        return String.format("Artist with ID %s has been deleted", id);
    }
}
