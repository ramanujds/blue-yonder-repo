package com.mywebfluxapp.entity;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private int id;
    @Column("product_name")
    private String name;
    @Column("product_description")
    private String description;
    @Column("price")
    private float price;
}
