# Restaurant Dining Review API

## Overview

This project showcases my ability to build a RESTful web API from scratch using Spring and Spring Data JPA. The application serves as a platform for users to submit dining reviews for restaurants, allowing for data persistence and a structured API interface.

## Project Objectives

- Construct a RESTful web API with data persistence using Spring and Spring Data JPA.
- Utilize Spring Initializr to generate the initial Java project.
- Configure application properties for dependencies, including the H2 embedded database.
- Define entities for users, restaurants, and dining reviews.
- Create repositories for these entities to facilitate CRUD operations.
- Define API contracts for the application's functionality.
- Leverage Lombok to reduce boilerplate code.
- Use cURL to test various API scenarios.

## Setup

1. **Project Initialization**
   - Used [Spring Initializr](https://start.spring.io/) to create a Maven project with necessary dependencies: Spring Web, Spring Data JPA, H2 Database, and Lombok.

2. **Configuration**
   - Configured `application.properties` for H2 database persistence and Hibernate settings to auto-create tables.

3. **IDE Installation**
   - Set up an integrated development environment (IDE) for coding and debugging.

## API Development

### Defined Entities

1. **User**
   - Represents a user with a unique display name, city, state, zip code, and allergy interests.

2. **Restaurant**
   - Contains restaurant details and scores for various allergies.

3. **Dining Review**
   - Captures user submissions, restaurant references, allergy scores, and commentary.

### API Endpoints

The API endpoints were designed based on the following contract requirements:

- Users referenced by unique display names.
- Restaurants and dining reviews referenced by their database IDs.
- Input validation for creating and updating entities.
- JSON responses with appropriate HTTP status codes.

## Testing the API

Utilized cURL commands to test the API scenarios iteratively, allowing for immediate feedback and refinement of the functionality.

## Project Structure

Organized the project to maintain clarity, grouping related classes into packages and following Spring’s best practices for project structure.

## Lombok Integration

Applied Lombok annotations throughout the entities to minimize boilerplate code. This improved code readability and maintainability.

## Next Steps

Future enhancements for the API could include:

- Building a client-side application that interacts with the API.
- Adding advanced querying capabilities.
- Exploring additional Spring concepts to enhance functionality.

## Resources

- [Spring Framework Documentation](https://spring.io/projects/spring-framework)
- [Spring Data JPA Documentation](https://spring.io/projects/spring-data-jpa)
- [H2 Database Documentation](https://h2database.com/html/main.html)
- [Lombok Documentation](https://projectlombok.org/)

