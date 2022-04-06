FROM alpine:3.11.2
RUN apk update && apk add --no-cache openjdk11
COPY build/libs/ms9-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-jar" , "/app/ms9-0.0.1-SNAPSHOT.jar"]