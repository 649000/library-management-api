# Library Management API Service
[![SonarCloud](https://sonarcloud.io/images/project_badges/sonarcloud-white.svg)](https://sonarcloud.io/summary/new_code?id=649000_springboot-dynamodb-rest-api)

## Overview
This project entails a Spring Boot RESTful API service seamlessly integrated with AWS DynamoDB. Its primary focus is on efficient book management within a library ecosystem.

## Objectives
* Java, Spring Boot, and Maven Mastery: Familiarize oneself comprehensively with Java programming, Spring Boot framework, and Maven for robust application development.
* Leveraging AWS DynamoDB within Spring Boot: Explore and utilize AWS DynamoDB's potential within a Spring Boot environment for effective data management.
* Crafting a RESTful API Service: Build a powerful and user-friendly API service adept at managing a library's literary assets and member relationships.

## Features
This API service serves as the backbone for essential library functions, encompassing:

* Management of Literary Assets: Facilitating the organization and oversight of books within the library.
* Member Relationship Management: Tracking and managing relationships between the library and its members.
* Efficient Book Checkout Tracking: Recording details of books checked out by library members.
* Additionally, the project is hosted on Railway, a hobbyist-friendly infrastructure platform similar to AWS, chosen for its accommodating free-tier provision.


## Technologies Utilized
* Spring Boot: Empowering rapid API development.
* Spring Data DynamoDB: Streamlining interactions with AWS DynamoDB for seamless data operations.
* SpringDoc OpenAPI: Facilitating API documentation and interaction.
* Spring Boot Actuator: Enabling efficient monitoring and management of the application.
* Lombok: Reducing boilerplate code through annotations.
* Maven: Orchestrating the project's build and dependencies.
* MapStruct: Simplifying Java bean mappings.
* AWS Java SDK For Amazon DynamoDB: Enabling smooth integration with DynamoDB using Java.

## Installation and Setup Instructions
AWS Access and Secret keys are required and must be set as an environment variable to run this app

Example on setting environment variable on macOS:
```
export aws_accesskey=<KEY GOES HERE>
export aws_secretkey=<KEY GOES HERE>
```

To run the service, navigate to the root of the project and execute the command

```
mvn spring-boot:run
```


## Endpoints
|          | localhost                                   | Render                                                     |
|----------|---------------------------------------------|-------------------------------------------------------------|
| Open API | http://localhost:8080/swagger-ui/index.html | https://library-management-api-7c4u.onrender.com/swagger-ui/index.html |
| Actuator | http://localhost:8080/actuator              | https://library-management-api-7c4u.onrender.com/actuator              |
| API      | http://localhost:8080/api                   | https://library-management-api-7c4u.onrender.com/api              |

Service on Render may spin down due to inactivity, resulting in delays of 50 seconds or more for requests.

## Reflection

This project serves a dual purpose: not only does it effectively manage library resources, but it also serves as a significant learning journey, delving into a spectrum of technologies vital for modern API development and infrastructure deployment.

The rise of NoSQL databases has transformed the database landscape, offering simplicity and popularity that diverge from traditional relational databases. This project was conceived to familiarize myself with the nuances of NoSQL databases. While a myriad of NoSQL options exists, AWS DynamoDB was deliberately chosen to align with my pursuit of AWS certifications.

The most intriguing challenge encountered during this project revolved around adopting a distinct approach to database design. Unlike the relational database paradigm, which emphasizes data relationships and normalization rules, NoSQL databases demand an application-centric approach. Here, the focus shifts towards optimizing data queries to suit the application's specific needs.



