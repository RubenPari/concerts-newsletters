package io.rubenpari.concertsnewsletters.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Environment {
    public static void loadEnv() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            String envPath = currentDirectory + "/.env";

            Dotenv dotenv = Dotenv.configure()
                    .directory(envPath)
                    .load();
            dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));
        } catch (Exception e) {
            System.out.println("Error occurred while loading environment variables:");
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
