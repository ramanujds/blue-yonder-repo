package com.by.studentapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

}
