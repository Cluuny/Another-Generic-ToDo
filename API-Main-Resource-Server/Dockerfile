FROM amazoncorretto:17-alpine-jdk
LABEL authors="Cluuny"

COPY  target/API-Main-Resource-Server-0.0.1-SNAPSHOT.jar API-Main-Resource-Server-0.0.1-SNAPSHOT.jar

EXPOSE 7070

ENTRYPOINT ["java", "-jar", "API-Main-Resource-Server-0.0.1-SNAPSHOT.jar"]