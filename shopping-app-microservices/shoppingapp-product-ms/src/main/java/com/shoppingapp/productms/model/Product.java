package com.shoppingapp.productms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    private String id;
    private String name;

    private float price;

    private String description;


}
