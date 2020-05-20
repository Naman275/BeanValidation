package com.demo.BeanValidation.dto;

import com.demo.BeanValidation.constrainGroups.Business;
import com.demo.BeanValidation.constrainGroups.Serviceman;
import com.demo.BeanValidation.constrainGroups.Student;
import com.demo.BeanValidation.constrainGroups.common;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@Valid
public class Person {
    @NotNull(message = "Name is mandatory",groups = common.class)
    private String name;
    private String occupation;
    @Min(value = 10000,message = "Account Balance must be at least 10,000",groups = Business.class)
    @Min(value = 1000,message = "Account Balance must be at least 1000",groups = Serviceman.class)
    @Min(value = 100,message = "Account Balance must be at least 100",groups = Student.class)
    @NotNull(message = "Account Balance needs to be disclosed")
    private BigDecimal accBalance;
    private String country;
    //we need to mention valid annotation explicitly if user defined object are there
    @NotNull
    @Valid
    private Address address;
}
