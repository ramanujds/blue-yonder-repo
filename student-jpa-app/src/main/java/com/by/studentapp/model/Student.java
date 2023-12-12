package com.by.studentapp.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "student_name", length =50, nullable = false)
    private String name;
    @Column(name = "email", length =100, nullable = false, unique = true)
    private String email;
    @Column(name = "birth_date")
    private LocalDate dob;
    @Column(name = "cgpa", nullable = true)
    private float cgpa;

}
