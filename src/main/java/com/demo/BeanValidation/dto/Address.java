package com.demo.BeanValidation.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Valid
public class Address {
    @NotNull(message = "applicantId: cannot be null")
   //// @Pattern(regexp = "[A-Za-z0-9]",message = "applicantId:Only Alpha-numeric characters are allowed ")
    private String applicantId;
    @NotNull(message = "city:Please provide name")
    private String city;
    @NotNull(message ="state:Please provide proper state name")
    private String state;
    @NotNull(message = "pincode: cannot be null")
    @Pattern(regexp = "^[0-9]{1,6}$",message ="pincode:Please provide pincode upto 6 digit")
    private String pincode;
    @NotNull(message = "country:Please provide country")
    private String country;
    private String Line1;
    private String Line2;
}
