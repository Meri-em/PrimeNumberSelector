FROM maven:3-amazoncorretto-21

WORKDIR /usr/src/app

COPY . .

ENV CONSUMER_HOST=http://host.docker.internal:8081

RUN mvn clean install

EXPOSE 8080

CMD [ "java", "-jar", "target/producer-0.0.1-SNAPSHOT.jar" ]