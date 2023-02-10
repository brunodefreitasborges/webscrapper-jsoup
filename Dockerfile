FROM openjdk:17-jdk-slim-buster
ADD build/libs/WebScrapperMercadoLivre-0.0.1-SNAPSHOT.jar dockerapp.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "dockerapp.jar"]