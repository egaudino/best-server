# best-server
> API to measure connection latency between Game Servers

## Installation

OS X & Linux:

```sh
docker pull mongo
```

```sh
docker run -d -p 27017:27017 -p 28017:28017 -e AUTH=no mongo
```

## Usage example

```sh
mvn spring-boot:run
```

## Access in browser (Not Implemented)

```sh
http://localhost:8080/swagger-ui.html
```

## Stack
Java 8
Spring Boot 2
Lombok
