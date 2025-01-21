package io.rubenpari.concertsnewsletters.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

public class ResponseObjectEvent {
    @JsonProperty("announced_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private ZonedDateTime announcedAt;

    @JsonProperty("artist_id")
    private int artistId;

    @JsonProperty("datetime_display_rule")
    private String datetimeDisplayRule;

    @JsonProperty("ends_at")
    private String endsAt;

    @JsonProperty("festival_id")
    private String festivalId;

    @JsonProperty("free")
    private boolean free;

    @JsonProperty("has_tickets")
    private boolean hasTickets;

    @JsonProperty("id")
    private int id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("rsvp_count")
    private int rsvpCount;

    @JsonProperty("starts_at")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private ZonedDateTime startsAt;

    @JsonProperty("streaming_event")
    private boolean streamingEvent;

    @JsonProperty("streaming_service_type")
    private String streamingServiceType;

    @JsonProperty("timezone")
    private String timezone;

    @JsonProperty("title")
    private String title;

    @JsonProperty("venue_id")
    private int venueId;

    public ZonedDateTime getAnnouncedAt() {
        return announcedAt;
    }

    public void setAnnouncedAt(ZonedDateTime announcedAt) {
        this.announcedAt = announcedAt;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getDatetimeDisplayRule() {
        return datetimeDisplayRule;
    }

    public void setDatetimeDisplayRule(String datetimeDisplayRule) {
        this.datetimeDisplayRule = datetimeDisplayRule;
    }

    public String getEndsAt() {
        return endsAt;
    }

    public void setEndsAt(String endsAt) {
        this.endsAt = endsAt;
    }

    public String getFestivalId() {
        return festivalId;
    }

    public void setFestivalId(String festivalId) {
        this.festivalId = festivalId;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }

    public boolean isHasTickets() {
        return hasTickets;
    }

    public void setHasTickets(boolean hasTickets) {
        this.hasTickets = hasTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRsvpCount() {
        return rsvpCount;
    }

    public void setRsvpCount(int rsvpCount) {
        this.rsvpCount = rsvpCount;
    }

    public ZonedDateTime getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(ZonedDateTime startsAt) {
        this.startsAt = startsAt;
    }

    public boolean isStreamingEvent() {
        return streamingEvent;
    }

    public void setStreamingEvent(boolean streamingEvent) {
        this.streamingEvent = streamingEvent;
    }

    public String getStreamingServiceType() {
        return streamingServiceType;
    }

    public void setStreamingServiceType(String streamingServiceType) {
        this.streamingServiceType = streamingServiceType;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVenueId() {
        return venueId;
    }

    public void setVenueId(int venueId) {
        this.venueId = venueId;
    }
}


