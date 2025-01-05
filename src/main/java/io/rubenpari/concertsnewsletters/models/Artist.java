package io.rubenpari.concertsnewsletters.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Artist {

    @Id
    @Min(value = 1, message = "ID must be greater than or equal to 1")
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String genre;

    protected Artist() {
    }

    @Override
    public String toString() {
        return String.format("Artist[id=%d, name='%s', genre='%s']", id, name, genre);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
