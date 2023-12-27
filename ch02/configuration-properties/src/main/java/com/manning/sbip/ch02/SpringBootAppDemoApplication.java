package com.manning.sbip.ch02;

import com.manning.sbip.ch02.configurationproperties.AppProperties;
import com.manning.sbip.ch02.configurationproperties.InvisibleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableConfigurationProperties(AppProperties.class)
@ConfigurationPropertiesScan
public class SpringBootAppDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootAppDemoApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootAppDemoApplication.class, args);
		AppService appService = applicationContext.getBean(AppService.class);
		log.info(appService.getAppProperties().toString());
		InvisibleProperties invisibleProperties = applicationContext.getBean(InvisibleProperties.class);
		log.info(invisibleProperties.toString());
	}
}
