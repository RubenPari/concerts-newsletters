package io.rubenpari.concertsnewsletters.services;

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

        String json = "{\n" + " \"contents\": [{\n" + " \"parts\": [{\"text\": \"" + answer + "\"}]\n" + " }]\n" + "}";

        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));

        Request request = new Request.Builder()
                .url(this.BASE_URL)
                .post(body).addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            String StringConcerts = response.body().string();

            if (StringConcerts.equals("no concerts found")) {
                return Collections.emptyList();
            }

            return List.of(StringConcerts.split(","));
        } catch (IOException e) {
            logger.error("Error occurred while getting response", e);
            return Collections.singletonList(e.getMessage());
        }
    }
}