package br.com.core.capy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class CapyApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapyApplication.class, args);
	}

}
