package io.rubenpari.concertsnewsletters.repositories;

import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import io.rubenpari.concertsnewsletters.models.Artist;

public interface IArtistRepositories extends CrudRepository<Artist, Integer> {
    @NotNull Optional<Artist> findById(@NonNull Integer id);

    Optional<Artist> findByName(@NonNull String name);
}
