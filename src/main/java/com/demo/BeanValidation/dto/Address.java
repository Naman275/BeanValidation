package com.demo.BeanValidation.dto;

import lombok.Data;

@Data
public class Address {
    private String applicantId;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String Line1;
    private String Line2;
}
