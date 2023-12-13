package com.by.studentapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    private int id;

    @Column(length = 100)
    private String brand;

    private int ram;

    private int storage;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

}
