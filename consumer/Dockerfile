FROM maven:3-amazoncorretto-21

WORKDIR /usr/src/app

COPY . .
RUN mvn clean install
EXPOSE 8081
CMD [ "java", "-jar", "target/consumer-0.0.1-SNAPSHOT.jar" ]