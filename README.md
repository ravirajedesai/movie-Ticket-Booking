# Movie Ticket Booking System 🎬

A complete **microservices-based movie ticket booking platform** built with Spring Boot, Spring Cloud, and modern Java practices.

## Microservices
- **api-gateway** – Spring Cloud Gateway (currently in the repo)
- movie-service – Manage movies & showtimes
- booking-service – Handle seat selection & bookings
- user-service – Authentication & user profiles (coming)
- payment-service – Payment integration (coming)
- discovery-server (Eureka) – Service registry (coming)

## Tech Stack
- Java 21
- Spring Boot 3.x
- Spring Cloud (Gateway, Config, OpenFeign, Eureka)
- Maven
- PostgreSQL / MySQL (planned)

## How to Run
```bash
./mvnw spring-boot:run   # inside each service folder
