📌 Project Overview

This is a production-ready Student Management Microservice developed using Spring Boot.
The application allows managing student records with file upload capability and is secured using Spring Security.

🚀 Features

✅ Add Student with File Upload

✅ Get Student by Roll Number

✅ Get All Students

✅ Delete Student

✅ Download Uploaded File

✅ Spring Security (Basic Authentication)

✅ MySQL Database Integration

✅ JPA & Hibernate

✅ Validation & Exception Handling

✅ Eureka Client (Service Registration)

✅ Logging Configuration

🛠️ Tech Stack

Java 21

Spring Boot 3.2

Spring Data JPA

Spring Security

MySQL

Hibernate

Lombok

MapStruct

Netflix Eureka

Maven

🔐 Security

Basic Authentication enabled

Secured APIs

Configurable credentials via application.properties

📦 API Endpoints
Method	Endpoint	Description
POST	/api/v1/student	Add student with file
GET	/api/v1/student/{rollNo}	Get student by ID
GET	/api/v1/student	Get all students
DELETE	/api/v1/student/{rollNo}	Delete student
GET	/api/v1/student/download/{rollNo}	Download file
