package io.rubenpari.concertsnewsletters.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

@Entity
public class Concert {
    @Id
    @Min(value = 1, message = "ID must be greater than or equal to 1")
    private Integer id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime announcedAt;

    @NotBlank
    private String datetimeDisplayRule;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime endsAt;

    private String festivalId;

    private boolean free;

    private boolean hasTickets;

    private String image;

    @NotNull
    private Integer rsvpCount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime startsAt;

    private boolean streamingEvent;

    private String streamingServiceType;

    @NotBlank
    private String timezone;

    @NotBlank
    private String title;

    @NotNull
    private Integer venueId;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAnnouncedAt(ZonedDateTime announcedAt) {
        this.announcedAt = announcedAt;
    }

    public void setDatetimeDisplayRule(String datetimeDisplayRule) {
        this.datetimeDisplayRule = datetimeDisplayRule;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = ZonedDateTime.parse(endsAt);
    }

    public void setFestivalId(String festivalId) {
        this.festivalId = festivalId;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public void setHasTickets(boolean hasTickets) {
        this.hasTickets = hasTickets;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setRsvpCount(int rsvpCount) {
        this.rsvpCount = rsvpCount;
    }

    public void setStartsAt(ZonedDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public void setStreamingEvent(boolean streamingEvent) {
        this.streamingEvent = streamingEvent;
    }

    public void setStreamingServiceType(String streamingServiceType) {
        this.streamingServiceType = streamingServiceType;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }

    public void setArtist(Artist artistById) {
        this.artist = artistById;
    }

    public ZonedDateTime getAnnouncedAt() {
        return announcedAt;
    }

    public String getDatetimeDisplayRule() {
        return datetimeDisplayRule;
    }

    public ZonedDateTime getEndsAt() {
        return endsAt;
    }

    public String getFestivalId() {
        return festivalId;
    }

    public boolean isFree() {
        return free;
    }

    public boolean isHasTickets() {
        return hasTickets;
    }

    public String getImage() {
        return image;
    }

    public Integer getRsvpCount() {
        return rsvpCount;
    }

    public ZonedDateTime getStartsAt() {
        return startsAt;
    }

    public boolean isStreamingEvent() {
        return streamingEvent;
    }

    public String getStreamingServiceType() {
        return streamingServiceType;
    }

    public String getTimezone() {
        return timezone;
    }

    public String getTitle() {
        return title;
    }

    public Integer getVenueId() {
        return venueId;
    }

    public Artist getArtist() {
        return artist;
    }
}