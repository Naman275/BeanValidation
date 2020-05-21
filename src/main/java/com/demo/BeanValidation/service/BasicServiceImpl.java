package com.demo.BeanValidation.service;

import com.demo.BeanValidation.constrainGroups.Business;
import com.demo.BeanValidation.constrainGroups.ServiceEmployee;
import com.demo.BeanValidation.constrainGroups.Student;
import com.demo.BeanValidation.dto.Person;
import com.demo.BeanValidation.exceptions.BadRequestException;
import com.demo.BeanValidation.validation.CustomValidation;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.groups.Default;
import java.util.HashSet;
import java.util.Set;

@Service
public class BasicServiceImpl implements BasicService {

    public void validateSavePerson(Person person){

        Set<ConstraintViolation<Object>> voilations;
        String occupation=person.getOccupation();
        switch (occupation){
            case "Business":voilations= CustomValidation.validate(person, Business.class);break;
            case "Service":voilations=CustomValidation.validate(person,ServiceEmployee.class);break;
            case "Student":voilations=CustomValidation.validate(person, Student.class);break;
            default:voilations=CustomValidation.validate(person, Default.class);break;
        }
        if(voilations.size()>0){
            throw new ConstraintViolationException(voilations);
        }
    }

}
