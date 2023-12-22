package com.manning.sbip.ch01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:custom.properties")
@PropertySource("classpath:department.properties")
public class CustomConfiguration {
    @Autowired
    private Environment environment;

    @Override
    public String toString() {
        return "User: " + environment.getProperty("user") + " Department: " + environment.getProperty("department");
    }
}
