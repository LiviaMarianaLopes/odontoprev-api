FROM gradle:jdk21-graal AS BUILD
USER $APP_UID
WORKDIR /usr/app/
COPY . .
RUN gradle build
VOLUME ["/app/data"]

FROM openjdk:21-jdk-slim
COPY --from=BUILD /usr/app .
EXPOSE 8080
ENTRYPOINT exec java -jar build/libs/odontoprev-0.0.1-SNAPSHOT.jar