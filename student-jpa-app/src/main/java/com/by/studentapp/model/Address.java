package com.by.studentapp.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Address {

    private String buildingName;
    private String area;
    private String zipcode;
    private String city;
    private String state;

}
