package com.demo.BeanValidation.validation;
import com.demo.BeanValidation.constrainGroups.Business;
import com.demo.BeanValidation.constrainGroups.ServiceEmployee;
import com.demo.BeanValidation.constrainGroups.Student;
import com.demo.BeanValidation.dto.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
import java.util.Set;

@Component
@Scope(value = ConfigurableBeanFactory. SCOPE_SINGLETON)
public class CustomValidation {
    public static ValidatorFactory validatorFactory;
    public static Validator validator;
    public static  ExecutableValidator executableValidator;
    static{
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        //executable validator is required to validate method params, method return type, constructor params
        ExecutableValidator executableValidator = validator.forExecutables();
    }
    public static Set<ConstraintViolation<Object>> validate(Object object, Class<?>... groups){
        return validator.validate(object,groups);
    }
    public static void validateSavePerson(Person person){
        System.out.println("inside valudation");
        Set<ConstraintViolation<Object>> voilations;
        String occupation=person.getOccupation();
        switch (occupation.toLowerCase()){
            case "business":voilations= CustomValidation.validate(person, Business.class);break;
            case "service":voilations=CustomValidation.validate(person, ServiceEmployee.class);break;
            case "student":voilations=CustomValidation.validate(person, Student.class);break;
            default:voilations=CustomValidation.validate(person, Default.class);break;
        }
        if(voilations.size()>0){
            throw new ConstraintViolationException(voilations);
        }
    }
}
