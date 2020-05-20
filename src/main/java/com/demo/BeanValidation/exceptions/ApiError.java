package com.demo.BeanValidation.exceptions;
import lombok.Data;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;
@Data
public class ApiError {
    private int status;
    private String message;
    private List<String> Errors = new ArrayList<>();
    ApiError(int status, String message, List<FieldError> fieldErrors){
        this.status=status;
        this.message=message;
        for(FieldError error:fieldErrors){
            Errors.add(error.getDefaultMessage());
        }
    }
}