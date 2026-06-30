# Airport API

A REST API built with Spring Boot and MySQL for managing cities, airports, passengers, and aircraft. Deployed on Railway.

## Tech Stack

- Java 17
- Spring Boot 4.0.7
- Spring Data JPA
- MySQL
- Railway (cloud deployment)

## Live API

https://midterm-sprint-airport-api-production.up.railway.app

## Entities

- **City** - Represents a city with a name, state, and population
- **Airport** - Belongs to a city, has a name and IATA code
- **Passenger** - Lives in a city, can fly on many aircraft
- **Aircraft** - Operates out of many airports and carries many passengers

## Relationships

- A City has many Airports
- An Airport belongs to one City
- A Passenger lives in one City
- A Passenger can fly on many Aircraft
- An Aircraft can carry many Passengers
- An Aircraft can operate out of many Airports

## API Endpoints

### Cities

| Method | Endpoint         | Description    |
| ------ | ---------------- | -------------- |
| GET    | /api/cities      | Get all cities |
| GET    | /api/cities/{id} | Get city by ID |
| POST   | /api/cities      | Create a city  |
| PUT    | /api/cities/{id} | Update a city  |
| DELETE | /api/cities/{id} | Delete a city  |

### Airports

| Method | Endpoint           | Description                  |
| ------ | ------------------ | ---------------------------- |
| GET    | /api/airports      | Get all airports (paginated) |
| GET    | /api/airports/{id} | Get airport by ID            |
| POST   | /api/airports      | Create an airport            |
| PUT    | /api/airports/{id} | Update an airport            |
| DELETE | /api/airports/{id} | Delete an airport            |

### Passengers

| Method | Endpoint             | Description                    |
| ------ | -------------------- | ------------------------------ |
| GET    | /api/passengers      | Get all passengers (paginated) |
| GET    | /api/passengers/{id} | Get passenger by ID            |
| POST   | /api/passengers      | Create a passenger             |
| PUT    | /api/passengers/{id} | Update a passenger             |
| DELETE | /api/passengers/{id} | Delete a passenger             |

### Aircraft

| Method | Endpoint           | Description        |
| ------ | ------------------ | ------------------ |
| GET    | /api/aircraft      | Get all aircraft   |
| GET    | /api/aircraft/{id} | Get aircraft by ID |
| POST   | /api/aircraft      | Create aircraft    |
| PUT    | /api/aircraft/{id} | Update aircraft    |
| DELETE | /api/aircraft/{id} | Delete aircraft    |

## Pagination & Sorting

The following endpoints support pagination and sorting:

GET /api/passengers and GET /api/airports both accept these query parameters:

- page - page number (default 0)
- size - results per page (default 10)
- sort - field to sort by (default id)
- direction - asc or desc (default asc)

Example:
GET /api/passengers?page=0&size=5&sort=lastName&direction=asc

## How to Run Locally

1. Clone the repo
   git clone https://github.com/BCoishous/midterm-sprint-airport-api.git

2. Create a MySQL database
   CREATE DATABASE airport_db;

3. Configure application.properties
   spring.datasource.url=jdbc:mysql://localhost:3306/airport_db
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update

4. Run the app
   ./mvnw spring-boot:run

The app will start on http://localhost:8080 and seed the database automatically on first run.

## Team

- Brandon Coish - REST API
- Samantha Stroud - CLI Client
