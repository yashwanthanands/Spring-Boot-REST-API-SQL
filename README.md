# Spring Boot, MySQL, JPA, Hibernate Rest API

Build Restful CRUD API for a simple Micro-Notes App using Spring Boot, MySQL, JPA and Hibernate.

## Requirements

1. Java - 1.8.x

2. Maven - 3.x.x

3. Mysql - 5.x.x

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/yashwanthanands/Spring-Boot-REST-API-SQL.git
```

**2. Create MySQL database**
```bash
create database notes_app
```

**3. Change MySQL Username and Password as per your installation**

+ open `src/main/resources/application.properties`

+ change `spring.datasource.username` and `spring.datasource.password` as per your MySQL installation

**4. Build and Run the app using maven**

```bash
mvn package
java -jar target/easy-notes-1.0.0.jar
```

Alternatively, you can run the app without packaging it using -

```bash
mvn spring-boot:run
```

The app will start running at <http://localhost:8080>.

## Explore Rest APIs

The app defines following CRUD APIs.

    GET /API/Notes
    
    POST /API/Note
    
    GET /API/Notes/{noteId}
    
    PUT /API/Notes/{noteId}
    
    DELETE /API/Notes/{noteId}

You can test them using POSTMAN or any other rest client.
 
