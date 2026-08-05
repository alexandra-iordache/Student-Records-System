# Student Records System

A Java student records system built for the Software Engineering module at Royal Holloway. It manages students, their module registrations and their grades, and exposes the data through a secured REST API backed by a relational database.

The project is split into two stages:

- **CW1** – the domain model (`Student`, `Module`, `Registration`, `Grade`) with custom exceptions and a JUnit test suite.
- **CW2** – the same model exposed as a Spring Boot REST service, with Spring Data JPA persistence, Spring Security, and controller and application tests.

## Tech stack

- **Language:** Java
- **Framework:** Spring Boot (REST controllers, dependency injection)
- **Persistence:** Spring Data JPA / Hibernate
- **Security:** Spring Security
- **Testing:** JUnit
- **Build:** Maven

## What it does

- Stores students, the modules they are registered on, and the grades they earn.
- Serves and updates that data through REST endpoints (for example a grade controller).
- Persists everything to a relational database through JPA repositories rather than in memory.
- Protects the endpoints with a Spring Security configuration.
- Handles missing data cleanly through custom exceptions such as `NoGradesAvailableException` and `NoRegistrationException`.

## Running it

```bash
cd CW2
./mvnw spring-boot:run
```

The service starts on `http://localhost:8080`.

## Tests

```bash
cd CW2
./mvnw test
```

Tests cover the domain model (students, modules, registrations, grades) and the REST controller layer.

## Repository layout

```
CW1/   Domain model and unit tests
CW2/   Spring Boot REST API, JPA repositories, security config and tests
```
