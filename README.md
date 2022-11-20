# Spring Boot API service with AWS DynamoDB
## Overview
This is a Spring Boot RESTful API service connected to AWS DynamoDB.

The objective of this project are:
1. Familiarize with Java, Spring Boot, and Maven
2. Utilise AWS DynamoDB in a Spring Boot project
3. Build a RESTful API service

## Features
This API service handles primary housekeeping functions of a library. It helps to manage literary assets and relationships with the library members. It also keeps track of books that have been checked out by the members.

### Technologies
1. Spring Boot
   1. Spring Data DynamoDB
   2. SpringDoc OpenAPI
   3. Spring Boot Actuator
2. Lombok
3. Maven
4. MapStruct 
5. AWS Java SDK For Amazon DynamoDB


## Project Status


|Feature|Status  |
|--|--|
|CRUD functionalities|Completed  |
| Deployed on Railway| Completed


## Endpoints
|          | localhost                                   | Railway                                                     |
|----------|---------------------------------------------|-------------------------------------------------------------|
| Open API | http://localhost:8080/swagger-ui/index.html | https://springboot-api.up.railway.app/swagger-ui/index.html |
| Actuator | http://localhost:8080/actuator              | https://springboot-api.up.railway.app/actuator              |

## Reflection

NoSQL database has become popular and simpler to use than relational database. This project aimed to familiarise with NoSQL database. Despite numerous NoSQL databases options out there, AWS DynamoDB was specifically chosen so that it aids my learning in taking the AWS certifications.

The challenging aspect of this project is having a different approach to database design. In relational database, designs have to take into account of relationships with the data and conform to normalisation rules. However, for NoSQL databases, it takes more of an application-centric approach, concerning with how the application will query data. 


#### Tools used
1. Postman
2. Intellij IDE


