package com.demo.BeanValidation.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleConstraintException(MethodArgumentNotValidException ex,WebRequest request){
        BindingResult result = ex.getBindingResult();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),"Validation_Failed",result.getFieldErrors());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }

}
/*
https://dzone.com/articles/global-exception-handling-with-controlleradvice
 */