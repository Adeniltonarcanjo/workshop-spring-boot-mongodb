
# Projct MongoDB with Spring Boot

# About project ⁉️ 

https://course-javade.herokuapp.com

This project is part of the course "Java COMPLETO Programação Orientada a Objetos +Projetos", organized by [DevSuperior](https://devsuperior.com "Site da DevSuperior").
The application consists of a web services, more specifically a a Back-end API of a post part.


## Domain Model
![domain model post](https://user-images.githubusercontent.com/69324694/204677884-67ece394-2a50-47b1-ab08-27376e8d5b40.png)


## Domain Instance
![domain instance](https://user-images.githubusercontent.com/69324694/204677913-ccabc032-0d2a-4e0b-a8e9-76c5c84265af.png)


## Structure data posts
![estruct search](https://user-images.githubusercontent.com/69324694/204677951-1fa999a1-05dc-43ae-8579-b299bb25caa7.png)


## Technologies
- Java 11
- Spring Boot 2.7.5
- JPA / Hibernate
- MongoDB
- Maven
- Postman 

# How it works
### For the project to work it is necessary to have mongoDB installed and a database call workshop_mongo


### Endpoints for tests (port 8080)
#### Query (GET)
- Users (http://localhost:8080/users)
- Posts by title (http://localhost:8080/posts/fullsearch?text={put%20text%20here}))

#### Update (PUT)
- Users (http://localhost:8080/users/{id}) put the ID and in the body of the request, put the field and the value you want to change.

#### Delete(DELETE)
- Users (http://localhost:8080/users/{id})

#### Insert(POST)
- Users (http://localhost:8080/users) In the body of the request, put the field and the value you want to insert.

All tests can be done in Postman


### Author
**Adenilton Morais Arcanjo**

https://www.linkedin.com/in/adeniltonarcanjo/
