package com.demo.BeanValidation.controller;

import com.demo.BeanValidation.constants.Util;
import com.demo.BeanValidation.dto.Person;
import com.demo.BeanValidation.service.BasicService;
import com.demo.BeanValidation.validation.CustomValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

@RestController
@RequestMapping(Util.VERSION_1)
public class BasicController {

    @Autowired
    private BasicService basicService;

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
        }
        CustomValidation.validateSavePerson(person);
        return new ResponseEntity<>("Hi There", HttpStatus.OK);
    }

    @PostMapping("/savePerson3")
    public ResponseEntity<Object> saveAfterValidation(@RequestBody Person person){
        //here the validation will be performed in interceptor first then only will hit this api
        return new ResponseEntity<>("-verified Dto-", HttpStatus.OK);
    }
}
