FROM openjdk:23

WORKDIR /app

COPY . .

RUN chmod +x ./mvnw

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "target/concerts-newsletters-0.0.1-SNAPSHOT.jar"]
