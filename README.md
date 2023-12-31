# Notes and Important Links

## Microservices in Details

https://github.com/ramanujds/spring-boot-microservices

## Case-study Shopping Cart App

https://github.com/ramanujds/online-shopping-app

# Spring Data JPA

## JDBC

Java Database Connectivity (JDBC) is a Java-based API that enables Java applications to interact with relational databases.

## SQL

Structured Query Language (SQL) is a domain-specific language used for managing and manipulating relational databases.

## JPA - Java Persistence API

Java Persistence API (JPA) is a Java specification for accessing, managing, and persisting data between Java objects and relational databases.

## Hibernate - ORM Framework

Hibernate is an Object-Relational Mapping (ORM) framework for Java that simplifies database interactions by mapping Java objects to database tables.

## Spring Data JPA

Spring Data JPA is a part of the larger Spring Data project that simplifies data access in a Spring-based application with JPA support.

## Object-Relational Mapping

Object-Relational Mapping (ORM) is a programming technique that converts data between incompatible type systems in object-oriented programming languages.

---

### Student class

```java
public class Student {
    private int id;
    private String name;
    private String email;
    private LocalDate dob;

    // Constructor
    public Student(int id, String name, String email, LocalDate dob) {
        // initialization
    }
}
```

### Student table

| id  | name  | email              | dob       |
| --- | ----- | ------------------ | --------- |
| 1   | Harsh | harsh@yahoo.com    | 2000-10-10 |

---

```java
// Creating a Student object
Student s1 = new Student(1, "Harsh", "harsh@yahoo.com", LocalDate.of(2000, 10, 10));

// Saving the Student object
save(s1);

// Finding a Student by ID
findById(1);
```

This example demonstrates the mapping between a `Student` Java class and a corresponding database table, along with the creation, saving, and retrieval of a `Student` object using various data access methods.


## Steps to Implement Service Discovery Using Eureka Server

*Eureka Server Configuration*

1. **Create a New Spring Boot Project:**
   - Start by initiating a new Spring Boot project, incorporating the Eureka Server dependency.

2. **Enable Eureka Server:**
   - Annotate the main class of the application with `@EnableEurekaServer` to designate it as the Eureka Server.

3. **Configure Port Settings:**
   - Set the server port to 8761, the default port for Eureka servers.

4. **Launch Eureka Server:**
   - Execute the application, and access the Eureka Server dashboard by navigating to `localhost:8761` in a web browser.

*Eureka Client Configuration*

1. **Configure Application Name:**
   - For each microservice, specify the application name in the `application.properties` or `application.yml` file:

     ```properties
     spring.application.name=...
     ```

2. **Add Eureka Client Dependencies:**
   - Integrate Eureka client dependencies into each microservice project to enable interaction with the Eureka Server.

3. **Enable Discovery Client:**
   - Annotate the main class of each microservice with `@EnableDiscoveryClient` to enable the service as a Eureka client.

4. **Load-Balanced RestTemplate:**
   - Add `@LoadBalanced` to the `RestTemplate` bean configuration within each microservice. This enables load balancing when making requests between microservices.

5. **Replace Service Address with Name:**
   - In the code where API calls are made using `RestTemplate`, replace the hardcoded service address with the registered service name. For example:

     From:
     ```text
     http://localhost:5100/api/products/..
     ```

     To:
     ```text
     http://PRODUCT-MS/api/products/..
     ```

   - This change allows Eureka to dynamically resolve the service instance's actual location.

By following these steps, you establish a Eureka Server for service registration and discovery, enabling seamless communication between microservices in a dynamic and scalable environment.


# Steps to Implement API Gateway

## What is API Gateway?

API Gateway acts as a unified entry point for client applications, providing a streamlined interface to communicate with our microservices. It simplifies the interaction between clients and the underlying services, handling cross-cutting concerns such as logging, security, and more.

## Usage

API Gateway is crucial for managing common concerns across microservices, ensuring a consistent and secure communication channel for client applications.

## Spring Gateway

To implement API Gateway using Spring Cloud Gateway, follow these detailed steps:

### 1. Create a New Spring Boot Project

Begin by creating a new Spring Boot project using your preferred IDE or Spring Initializr.

### 2. Add Gateway Dependency

Include the necessary dependencies for Spring Cloud Gateway in your project. Update your `pom.xml` file with the following:

```xml
<!-- Add the Spring Cloud Gateway dependency -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-gateway</artifactId>
</dependency>
```

### 3. Add Eureka Client Dependency (Optional)

If you are using Eureka for service discovery, include the Eureka Client dependency:

```xml
<!-- Add the Eureka Client dependency -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```

### 4. Configure `application.yml`

Create or update your `application.yml` file with the following configuration:

```yaml
server:
  port: 5000

spring:
  application:
    name: api-gateway

  cloud:
    gateway:
      routes:
        - id: product-ms
          uri: lb://product-ms
          predicates:
            - Path=/api/products/**

        - id: cart-ms
          uri: lb://cart-ms
          predicates:
            - Path=/api/cart/**

        - id: order-ms
          uri: lb://order-ms
          predicates:
            - Path=/api/order/**
```

### Explanation of Configuration

- **`server` section:** Specifies the port on which the API Gateway will run.

- **`spring.application` section:** Sets the name of the Spring Boot application.

- **`spring.cloud.gateway.routes` section:** Defines the routes for different microservices.

    - **`id`:** Unique identifier for the route.
    
    - **`uri`:** Load-balanced URI pointing to the target microservice.
    
    - **`predicates`:** Conditions based on the request path that trigger the routing to a specific microservice.

Adjust the `uri` and `predicates` based on your microservices' endpoints and routing requirements.

This configuration assumes Eureka is used for service discovery. If not, adjust the configuration accordingly. Once configured, the API Gateway will effectively route requests to the specified microservices based on the defined paths.
