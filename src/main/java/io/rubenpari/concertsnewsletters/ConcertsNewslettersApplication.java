package io.rubenpari.concertsnewsletters;

import io.rubenpari.concertsnewsletters.utils.Environment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcertsNewslettersApplication {
    public static void main(String[] args) {
        Environment.loadEnv();

        SpringApplication.run(ConcertsNewslettersApplication.class, args);
    }
}
