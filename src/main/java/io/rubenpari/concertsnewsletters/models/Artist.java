package io.rubenpari.concertsnewsletters.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
public class Artist {

    @Id
    @Min(value = 1, message = "ID must be greater than or equal to 1")
    private Integer id;

    @NotBlank
    private String name;

    @NotBlank
    private String genre;

    @NotBlank
    private String imageUrl;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Concert> concerts;

    protected Artist() {
    }

    @Override
    public String toString() {
        return String.format("Artist[id=%d, name='%s', genre='%s']", id, name, genre);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer value) {
        id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        name = value;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String value) {
        genre = value;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String value) {
        imageUrl = value;
    }

    public List<Concert> getConcerts() {
        return concerts;
    }

    public void setConcerts(List<Concert> concerts) {
        this.concerts = concerts;
    }
}