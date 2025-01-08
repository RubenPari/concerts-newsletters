package io.rubenpari.concertsnewsletters.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.rubenpari.concertsnewsletters.models.RequestGeminiPayload;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.rubenpari.concertsnewsletters.models.ResponseGeminiPayload;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class GeminiService implements IGeminiService {

    private static final Logger logger = LoggerFactory.getLogger(GeminiService.class);
    private String BASE_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";

    public GeminiService() {
        this.BASE_URL = this.BASE_URL + "?key=" + System.getenv("GEMINI_API_KEY");
    }

    @Override
    public List<String> getResponse(String answer) {
        OkHttpClient client = new OkHttpClient();

        // create JSON serialized object payload for request body
        RequestGeminiPayload.Part part = new RequestGeminiPayload.Part(answer);
        RequestGeminiPayload.Content content = new RequestGeminiPayload.Content(List.of(part));
        RequestGeminiPayload geminiPayload = new RequestGeminiPayload(List.of(content));

        ObjectMapper objectMapper = new ObjectMapper();
        String json;

        try {
            json = objectMapper.writeValueAsString(geminiPayload);
        } catch (JsonProcessingException e) {
            logger.error("Error occurred while serializing payload", e);
            return Collections.singletonList(e.getMessage());
        }

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(this.BASE_URL)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code: " + response.body().string());
            }

            String stringResponse = response.body().string();
            ResponseGeminiPayload objectResponse = objectMapper.readValue(stringResponse, ResponseGeminiPayload.class);
            String Concerts = objectResponse.getCandidates().getFirst().getContent().getParts().getFirst().getText();

            return List.of(Concerts.split(","));
        } catch (IOException e) {
            logger.error("Error occurred while getting response", e);
            return Collections.singletonList(e.getMessage());
        }
    }
}