package com.review.accounts;

import com.review.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
/*
* In case of don't follow the current structure. Need to define with below
* @ComponentScans({@ComponentScan("com.review.accounts.controller")})
* @EnableJpaRepositories("com.review.accounts.repository")
* @EntityScan("com.review.accounts.model")
* */
@EnableFeignClients
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Accounts services REST API Docs",
				version = "v1",
				contact = @Contact(
						name = "Robert",
						email = "trang@gmail.com",
						url = "http://www.trangbn.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.trangbn.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Spring Open Docs",
				url = "http://localhost:8080/swagger-ui/index.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
