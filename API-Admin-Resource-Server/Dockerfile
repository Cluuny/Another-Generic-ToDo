FROM amazoncorretto:17-alpine-jdk
LABEL authors="Cluuny"

COPY  target/API-Admin-Resource-Server-0.0.1-SNAPSHOT.jar API-Admin-Resource-Server-Final.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "API-Admin-Resource-Server-Final.jar"]