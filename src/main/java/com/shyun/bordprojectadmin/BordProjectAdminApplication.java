package com.shyun.bordprojectadmin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@ConfigurationPropertiesScan
@SpringBootApplication
public class BordProjectAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BordProjectAdminApplication.class, args);
	}

}
