package com.demo.BeanValidation.dto;

import com.demo.BeanValidation.constrainGroups.Business;
import com.demo.BeanValidation.constrainGroups.ServiceEmployee;
import com.demo.BeanValidation.constrainGroups.Student;
import com.demo.BeanValidation.constrainGroups.common;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

@Data
@Valid
public class Person {
    @NotNull(message = "name: is mandatory",groups = common.class)
    private String name;
    @NotNull(message = "occupation:Please mention Occupation",groups = common.class)
    @Pattern(regexp = "(^student$|^business$|^service$)",message = "occupation:can be either student|business|service")
    private String occupation;
    @Min(value = 10000,message = "accBalance: must be at least 10,000",groups = Business.class)
    @Min(value = 1000,message = "accBalance: must be at least 1000",groups = ServiceEmployee.class)
    @Min(value = 100,message = "accBalance: must be at least 100",groups = Student.class)
    @NotNull(message = "accBalance: needs to be disclosed")
    private BigDecimal accBalance;
    @NotNull(message = "citizen:PLease mention citizen")
    private String citizen;
    //we need to mention valid annotation explicitly if user defined object are there
    @NotNull(message = "addressList:Please provide address")
    @Valid
    private List<Address> addressList;
}
