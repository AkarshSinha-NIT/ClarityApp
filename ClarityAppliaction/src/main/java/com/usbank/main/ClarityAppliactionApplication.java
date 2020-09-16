package com.usbank.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.usbank.main.config.WebMVCAppConfig;

@SpringBootApplication
@Import({WebMVCAppConfig.class})
public class ClarityAppliactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClarityAppliactionApplication.class, args);
	}

}
