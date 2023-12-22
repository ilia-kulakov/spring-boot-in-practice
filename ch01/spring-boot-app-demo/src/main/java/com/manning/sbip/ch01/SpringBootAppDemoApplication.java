package com.manning.sbip.ch01;

import com.manning.sbip.ch01.config.CustomConfiguration;
import com.manning.sbip.ch01.config.TestConfiguration;
import com.manning.sbip.ch01.listener.ApplicationReadyEventListener;
import com.manning.sbip.ch01.listener.ApplicationStartingEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;

import java.util.Date;
import java.util.Properties;

@SpringBootApplication
public class SpringBootAppDemoApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.setProperty("spring.config.on-not-found", "ignore");
		properties.setProperty("user", "defaultUser");

		SpringApplication springApplication = new SpringApplication(SpringBootAppDemoApplication.class);
		springApplication.setWebApplicationType(WebApplicationType.SERVLET);
		springApplication.addListeners(new ApplicationStartingEventListener(), new ApplicationReadyEventListener());
		springApplication.setDefaultProperties(properties);
		ConfigurableApplicationContext applicationContext = springApplication.run(args);
		CustomConfiguration customConfiguration = applicationContext.getBean(CustomConfiguration.class);
		System.out.println("customConfiguration: " + customConfiguration);
		TestConfiguration testConfiguration = applicationContext.getBean(TestConfiguration.class);
		System.out.println("testConfiguration:" + testConfiguration);

		Environment environment = applicationContext.getEnvironment();
		System.out.println("spring.config.import=" + environment.getProperty("spring.config.import", "unknown"));
		System.out.println("department=" + environment.getProperty("department", "unknown"));
	}

	@EventListener(ApplicationReadyEvent.class)
	public void applicationReadyEvent(ApplicationReadyEvent applicationReadyEvent) {
		System.out.println("Application Ready Event generated at " + new Date(applicationReadyEvent.getTimestamp()));
	}

}
