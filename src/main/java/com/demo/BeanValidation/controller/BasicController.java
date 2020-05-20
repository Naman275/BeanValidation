package com.demo.BeanValidation.controller;

import com.demo.BeanValidation.constants.Util;
import com.demo.BeanValidation.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(Util.VERSION_1)
public class BasicController {
    @PostMapping("/savePerson")
    public ResponseEntity<String> savePerson (@Valid @RequestBody Person person){
        return new ResponseEntity<String>("Hi There", HttpStatus.OK);
    }
}
