# Spring Boot JWT Security System

## Overview

This project is a secure REST API built with Spring Boot and Spring Security.
It implements authentication using JSON Web Tokens (JWT) and role-based authorization.

## Technologies Used

* Java
* Spring Boot
* Spring Security
* JWT Authentication
* PostgreSQL
* Maven

## Features

* User Registration
* Login using Email and Password
* JWT Token Generation
* Role-based Authorization (Admin/User)
* Secure REST API Endpoints
* Password Encryption using BCrypt

## Project Structure

src/main/java/com/example/mukabeta

* controller → Handles API requests
* service → Business logic
* repository → Database access
* entity → Database models
* config → Security configuration
* filter → JWT authentication filter
* dto → Request/Response objects

## API Endpoints

### Register

POST /auth/register

Example Body:
{
"username": "admin",
"email": "[admin@gmail.com](mailto:admin@gmail.com)",
"password": "1234",
"role": "ADMIN"
}

### Login

POST /auth/login

Example Body:
{
"email": "[admin@gmail.com](mailto:admin@gmail.com)",
"password": "1234"
}

Response:
{
"token": "JWT_TOKEN"
}

### Get All Users

GET /user/all

Requires Bearer Token Authorization.

## Security

* Passwords encrypted using BCrypt
* Stateless authentication using JWT
* Custom JWT filter for token validation

## Author

Lovemore Mukabeta
