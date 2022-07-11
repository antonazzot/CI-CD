package com.tsyrkunou.kubernetec;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class KubernetecApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubernetecApplication.class, args);
	}

}
