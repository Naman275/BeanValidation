package com.demo.BeanValidation.dto;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Valid
public class Address {
    @NotNull
    @Pattern(regexp = "/^[a-zA-Z0-9\\-_]{0,40}$/",message = "Only Alpha-numeric characters are allowed in ApplicantId ")
    private String applicantId;
    @NotNull(message = "Please provide City name")
    private String city;
    @NotNull(message ="Please provide proper state name")
    private String state;
    @NotNull
    @Pattern(regexp = "^[0-9]{1,6}$",message ="Please provide pincode upto 6 digit")
    private String pincode;
    @NotNull(message = "Please provide country")
    private String country;
    private String Line1;
    private String Line2;
}
