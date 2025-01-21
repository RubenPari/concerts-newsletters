package io.rubenpari.concertsnewsletters.repositories;

import io.rubenpari.concertsnewsletters.models.Concert;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface IConcertRepositories extends CrudRepository<Concert, Integer> {
    @NotNull Optional<List<Concert>> findByArtistId(@NonNull Integer id);
}
