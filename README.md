### API Automation Testing – REST Assured


## **Project Overview**
This project is an **API automation testing framework** built using **REST Assured** and **Java**, following the **Service Object Model** (SOM) design pattern.

The framework covers:
- Authentication 
- Forgot Password
- Get Profile
- Update Profile

## **Technologies Used**
- Java
- REST Assured
- TestNG
- Maven

## Implemented APIs

### Authentication Service
- Login API
- Token generation

### Forgot Password Service
- Trigger forgot password API
- Validate success response/message

### Profile Service
- Get Profile API
- Update Profile API

All secured APIs reuse the authentication token where required.

## Configuration Management
Environment-specific values such as **Base URI, username, password and payload** are externalized using a `config.properties` file to avoid hard-coding and to support easy environment switching.

## How to Run Tests
Tests can be executed using Maven:
```bash
mvn test


  
