package com.shoppingapp.orderms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CartItem {


    @Id
    private int id;

    private String productId;

    private String productName;

    private float price;

    private int quantity;

}
