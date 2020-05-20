package com.demo.BeanValidation.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Valid
public class Person {
    @NotNull(message = "Name is mandatory")
    private String name;
    private String occupation;
    @Min(1000)
    @NotNull(message = "Account Balance needs to be disclosed")
    private BigDecimal accBalance;
    private String country;
    private Address address;
}
