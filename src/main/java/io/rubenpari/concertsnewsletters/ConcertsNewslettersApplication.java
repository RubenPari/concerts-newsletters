package io.rubenpari.concertsnewsletters;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConcertsNewslettersApplication {
    public static void main(String[] args) {
        try {
            String currentDirectory = System.getProperty("user.dir");
            String envPath = currentDirectory + "/.env";

            Dotenv dotenv = Dotenv.configure()
                    .directory(envPath)
                    .load();
            dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
            System.out.println(System.getenv("GEMINI_API_KEY"));
        } catch (Exception e) {
            System.out.println("Error occurred while loading environment variables:");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        SpringApplication.run(ConcertsNewslettersApplication.class, args);
    }
}
