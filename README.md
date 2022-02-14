# Room Type CRUD operations
## Requirements:
- Java ( jdk 1.8+)
- Maven 3.0+
- Spring Boot(2.6.3)
- Database(postgreSQL)
- Database Drivers
- IDE( IntelliJ or Eclipse)
- Postman (To test application)
## Features
- Create `POST` `http://localhost:8080/api/room-types`
- Update `PUT` `http://localhost:8080/api/room-types`
- Get `GET` `http://localhost:8080/api/room-types`
- Get `GET` `http://localhost:8080/api/room-types/{id}`
- Delete `DELETE` `http://localhost:8080/api/room-types/{id}`
## Dependency added
- spring web
- spring data jpa
- bean validation
- postgresql

## Steps to create Application
- Create project using [Spring Initializer](https://start.spring.io/)

- Select `maven`

- Select `spring boot version`

- Select `java version`

- Project metadata
  ```
  group(com.sunglowsys)
  artifact(room-type-crud-operation)
  package name(com.sunglowsys)
  ```

- Select Packaging `jar`

- Add dependencies `Spring Web`, `Spring Data JPA`, `PostgreSQL Driver`, `Bean Validation`

- Click on `Generate`

- Extract the generated zip file

- Import application in IntelliJ or Eclipse

- Implement CRUD Operations

## How to run application
- Open terminal and go inside application directory(room-type-crud-operation)
- Run command `mvn`

## Steps to Test application (Postman)

###  Create API
- Method `POST`
- URL `http://localhost:8080/api/room-types`
- JSON Body
  ```
  {
      "id": null,
      "name": "AC Room"
  }
  ```
###  Update API
- Method `PUT`
- URL `http://localhost:8080/api/room-types`
- JSON Body
  ```
  {
      "id": 1,
      "name": "Non AC Room"
  }
  ```
###  Get All API
- Method `GET`
- URL `http://localhost:8080/api/room-types?page=0&size=10`

###  Get By ID API
- Method `GET`
- URL `http://localhost:8080/api/room-types/1`

###  Delete API
- Method `DELETE`
- URL `http://localhost:8080/api/room-types/1`

