package com.manning.sbip.ch01.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:custom.properties")
//@PropertySource("classpath:test.properties")
public class TestConfiguration {
//    @Autowired
//    private Environment environment;

    @Value("${user}")
    String user;

    @Value("${department}")
    String department;

    @Override
    public String toString() {
        return "User: " + user + " Department: " + department;
    }
}
