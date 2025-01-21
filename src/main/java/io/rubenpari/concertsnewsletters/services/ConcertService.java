package io.rubenpari.concertsnewsletters.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.rubenpari.concertsnewsletters.models.Artist;
import io.rubenpari.concertsnewsletters.models.Concert;
import io.rubenpari.concertsnewsletters.models.ResponseGetArtistEvents;
import io.rubenpari.concertsnewsletters.models.ResponseObjectEvent;
import io.rubenpari.concertsnewsletters.repositories.IArtistRepositories;
import io.rubenpari.concertsnewsletters.repositories.IConcertRepositories;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConcertService implements IConcertService {

    private static final Logger logger = LoggerFactory.getLogger(ConcertService.class);
    private static final String API_KEY = "d496d95a13mshddb4bcdbe22c1b0p1d4624jsn771cb414e0f8";
    private static final String API_HOST = "concerts-artists-events-tracker.p.rapidapi.com";
    private final IConcertRepositories concertRepositories;
    private final IArtistRepositories artistRepository;

    public ConcertService(IConcertRepositories concertRepositories, IArtistRepositories artistRepository) {
        this.concertRepositories = concertRepositories;
        this.artistRepository = artistRepository;
    }

    @Override
    public void getConcerts(Integer artistId) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://concerts-artists-events-tracker.p.rapidapi.com/artist/events?artist_id=" + artistId)
                .get()
                .addHeader("x-rapidapi-key", API_KEY)
                .addHeader("x-rapidapi-host", API_HOST)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                logger.error("Failed to get artist events: {}", response);
            }

            String jsonResponse = response.body().string();
            ObjectMapper mapper = new ObjectMapper();
            ResponseGetArtistEvents responseGetArtistEvents = mapper.readValue(jsonResponse, ResponseGetArtistEvents.class);

            for (var event : responseGetArtistEvents.getEvents()) {
                Concert concert = mapToConcert(event);
                concertRepositories.save(concert);
            }

        } catch (IOException e) {
            logger.error("Error fetching list of artist events: {}", e.getMessage());
        }
    }

    private Concert mapToConcert(ResponseObjectEvent event) {
        Concert concert = new Concert();
        concert.setId(event.getId());
        concert.setAnnouncedAt(event.getAnnouncedAt());
        concert.setDatetimeDisplayRule(event.getDatetimeDisplayRule());
        concert.setEndsAt(event.getEndsAt());
        concert.setFestivalId(event.getFestivalId());
        concert.setFree(event.isFree());
        concert.setHasTickets(event.isHasTickets());
        concert.setImage(event.getImage());
        concert.setRsvpCount(event.getRsvpCount());
        concert.setStartsAt(event.getStartsAt());
        concert.setStreamingEvent(event.isStreamingEvent());
        concert.setStreamingServiceType(event.getStreamingServiceType());
        concert.setTimezone(event.getTimezone());
        concert.setTitle(event.getTitle());
        concert.setVenueId(event.getVenueId());
        concert.setArtist(getArtistById(event.getArtistId()));
        return concert;
    }

    private Artist getArtistById(Integer artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalArgumentException("Artist not found with ID: " + artistId));
    }
}