package com.demo.BeanValidation.exceptions;

import lombok.Data;

@Data
public class CustomError {
    private String timeStamp;
    private String message;
    private String details;
}
