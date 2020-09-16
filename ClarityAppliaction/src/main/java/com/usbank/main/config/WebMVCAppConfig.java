package com.usbank.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = {"com.usbank.main"})
public class WebMVCAppConfig {

	 @Bean
	   public ResourceBundleMessageSource messageSource() {
			
			ResourceBundleMessageSource messageSource =new ResourceBundleMessageSource();
			messageSource.setBasename("com/usbank/commons/errors");
			return messageSource;
	    }
	
}
