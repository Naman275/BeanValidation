package com.demo.BeanValidation.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> allowedPath=new ArrayList<>();
        allowedPath.add("/api/v1/savePerson1");
        registry.addInterceptor(new CustomInterceptor()).addPathPatterns(allowedPath);
    }

}
