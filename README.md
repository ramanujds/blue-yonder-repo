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
