package com.demo.BeanValidation.controller;

import com.demo.BeanValidation.constants.Util;
import com.demo.BeanValidation.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Util.VERSION_1)
public class BasicController {
    @PostMapping("/savePerson1")
    public ResponseEntity<String> savePerson (@Valid @RequestBody Person person){
        /*if request dto validation failed then it will throw MethodArgumentNotValidException exception
           which is caught in exception handler controller */
        return new ResponseEntity<String>("Hi There", HttpStatus.OK);
    }

    @PostMapping("/savePerson2")
    public ResponseEntity<Object> save(@Valid @RequestBody Person person,Errors errors){
        if(errors.hasErrors()){
            //if you want to validate request dto and catch errors in the controller layer itself
            return new ResponseEntity<>(errors.getFieldErrors(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Hi There", HttpStatus.OK);
    }
}
