# About The System
Create a small service that will manage appointments. This service receives a high load of requests that can contain appointment data:
The goal of this project is to assess your development skills suitable for a
software developer position. It tests knowledge and proficiency with software
design, unit testing and web technologies like HTTP and REST.

{
"id": Int,
"start": Date, "end": Date, "createdAt": Date "updatedAt": Date
}


You will need to process each request and:

• Make sure the appointment does not already exist, return an error
message if the requested time range is not available

• Make sure the data is valid, otherwise return an error message.

• Update the previous appointment data if the same ID is received with
updated information, while keeping the historical data

• Make sure you always keep the latest updated information while
keeping the historical data

• Make sure your application can handle multiple concurrent requests


This sample application is developed by using Java 11, Maven, Junit and Spring Boot framework. MySql is considered as the DBMS of this app but by a simple change in POM and application properties you can define your own DBMS.
It has been tried to keep the code clean and decouple to other module or layers.
JPA has been used as its main ORM and there is no need to define an initial sql file to create tables, so all tables will be created via DDL.

The controller is totally decoupled from main domain, so the entity and all services (instead of main service) are working in an encapsulated way.
There has been considered OOP, SOLID, KISS principles and some design patterns to make the code more maintainable.

The error handling section is implemented via exception throwing and handling to make the methods and errors more traceable.
And also some unit and integration tests has been implemented to cover a significant part of the code.
All validations have their own tests. and a separated database named `sesami_test` considered for integration tests.
# How To Run
You can the application by docker or your intelliJ IDE.
### Running With Docker (Recommended)
1. First of all, make sure you have installed the docker and docker compose in your system.
2. Install Maven in your system (https://maven.apache.org/install.html)
   (If you don't want to install Maven and JDK 11, no worries! I have put a pre-built JAR file in the project's root, You can move it to the `target` folder and comment the first line of the `run.sh`)
3. There is a bash script file that make the running project easier named `run.sh` in the project's root, so you can run it and after downloading images and building the application will be served. The docker composer will serve the main application, Mysql and phpMyAdmin.
4. The Project will be served on port `8000` automatically, if you want change this, you can alter this on the `docker-compose.yml` file in the project`s root.

**NOTE:** There is a `request.sh` file in the project's root. please use this to test concurrency. it is same as the file that the assignment said but there is a simple change in the default port and IDs of each request data. I mean, I remove some of IDs to consider them as a new appointment and also remove the single quotation around IDs because they are `Integer` in this application.

**NOTE:** There is also a postman export in the project's root.  
