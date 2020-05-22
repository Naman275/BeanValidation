package com.demo.BeanValidation.interceptor;

import com.demo.BeanValidation.dto.Person;
import com.demo.BeanValidation.validation.CustomValidation;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.stream.Collectors;

@Configuration
public class CustomInterceptor implements HandlerInterceptor {
    public ObjectMapper objectMapper=new ObjectMapper();
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        Person person=objectMapper.readValue(test, Person.class);
        CustomValidation.validateSavePerson(person);
        return true;
    }
}
