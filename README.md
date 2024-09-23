# Prime Number Selector

This is an example project utilizing the producer-consumer pattern.

The producer service generates random numbers while the consumer service filters all prime numbers from among them.

## Technologies used
- maven 3
- java 21
- spring boot
- docker + docker-compose

## Running the project

### Locally

You can open the project in your IDE and run both services from there.

Note that an environment variable `CONSUMER_HOST` (`http://localhost:8081`) should be set.

### Using Docker

There is a Dockerfile in each project, so if you want you can build and run each service separately.

- consumer service

        cd consumer
        docker build -t consumer .
        docker run -p 8081:8081 -v ./output:/usr/src/app/output consumer

- producer service

        cd producer
        docker build -t producer .
        docker run -p 8080:8080 -v ./output:/usr/src/app/output producer

### Using Docker compose

There is also a docker-compose configuration so you can also just do:

    docker compose up