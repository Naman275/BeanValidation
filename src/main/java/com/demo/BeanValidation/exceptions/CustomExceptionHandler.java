package com.demo.BeanValidation.exceptions;
import com.demo.BeanValidation.constants.Util;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError> handleConstraintException(MethodArgumentNotValidException ex,WebRequest request){
        BindingResult result = ex.getBindingResult();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),"Validation_Failed",result.getFieldErrors());
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({InvalidFormatException.class})
    public ResponseEntity<ApiError> handleInvalidFormat(InvalidFormatException ex){
        List<JsonMappingException.Reference> references = ex.getPath();
        String errorMessage = Util.PROPER_FORMAT_MESSAGE + references.get(references.size() - 1).getFieldName();
        errorMessage +=",Expected value of type:"+((MismatchedInputException)ex).getTargetType().getSimpleName();
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST.value(),"Invalid Format",errorMessage);
        return new ResponseEntity<ApiError>(apiError,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> constraintViolations=ex.getConstraintViolations();
        if(constraintViolations.size()>0){

        }
        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST.value(),"Validation_Failed","");
        return null;
    }

}
/*
https://dzone.com/articles/global-exception-handling-with-controlleradvice
 */