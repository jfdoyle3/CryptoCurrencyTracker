package com.cryptocurrency.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ImportResource("classpath:app-config.xml")
@EntityScan("com.cryptocurrency.entity")
 @EnableJpaRepositories("com.cryptocurrency.jpa.repository")
public class BackendApplication {

	public static void main(String[] args) {
		 SpringApplication.run(BackendApplication.class, args);
	}

}
