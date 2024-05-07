FROM openjdk:17-jdk-alpine
COPY build/libs/version-one-0.0.1-SNAPSHOT.jar java-app.jar
ENTRYPOINT ["java", "-jar", "java-app.jar"]