FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN mkdir db

COPY /target/*.jar /app/app.jar

EXPOSE 8888

ENTRYPOINT [ "java", "-jar", "app.jar" ]