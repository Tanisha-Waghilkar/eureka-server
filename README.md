# Student File Upload Service

Spring Boot microservice for managing student records with file upload & download support. Integrated with Eureka Service Registry and secured using Spring Security Basic Authentication.

## Features
- Add student with file upload
- Get student by Roll Number
- Download uploaded file
- Delete student record
- MySQL database integration
- Eureka Client (Service Discovery)
- Spring Security (Basic Auth)
- File storage on local system

## Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Security
- Netflix Eureka
- Maven
- Lombok
- MapStruct

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /api/v1/student | Add student with file |
| GET | /api/v1/student/{rollNo} | Get student by ID |
| DELETE | /api/v1/student/{rollNo} | Delete student |
| GET | /api/v1/student/download/{rollNo} | Download file |

## Security
Basic Authentication enabled  
Username: `tanisha`  
Password: `12345`

## Author
Tanisha Waghilkar
