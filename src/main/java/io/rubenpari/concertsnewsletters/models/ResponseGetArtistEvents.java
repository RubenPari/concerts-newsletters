package io.rubenpari.concertsnewsletters.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseGetArtistEvents {
    @JsonProperty("events")
    private List<ResponseObjectEvent> events;

    public List<ResponseObjectEvent> getEvents() {
        return events;
    }

    public void setEvents(List<ResponseObjectEvent> events) {
        this.events = events;
    }
}
