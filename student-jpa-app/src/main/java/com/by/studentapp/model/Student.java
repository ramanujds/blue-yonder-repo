package com.by.studentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @Column(name = "student_id")
    int id;
    @Column(name = "student_name", length =50, nullable = false)
    String name;
    @Column(name = "email", length =100, nullable = false, unique = true)
    String email;
    @Column(name = "birth_date")
    LocalDate dob;

}
