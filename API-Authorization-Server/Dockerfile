FROM amazoncorretto:17-alpine-jdk
LABEL authors="Cluuny"

COPY  target/API-Authorization-Server-0.0.1-SNAPSHOT.jar API-Authorization-Server-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "API-Authorization-Server-0.0.1-SNAPSHOT.jar"]