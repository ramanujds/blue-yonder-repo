package com.by.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @Transient
    private int age;

    @ElementCollection
    private List<String> papers=new ArrayList<>();


//    @OneToOne(cascade = CascadeType.PERSIST)
//    private Laptop laptop;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "student")
    private List<Laptop> laptops;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Laptop> laptops;

}
