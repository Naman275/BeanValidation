package com.demo.BeanValidation.validation;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
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
}
