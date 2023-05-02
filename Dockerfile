FROM openjdk:17-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY build/libs/note_app-0.0.1-SNAPSHOT.jar /
CMD ["java", "-jar", "/note_app-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080