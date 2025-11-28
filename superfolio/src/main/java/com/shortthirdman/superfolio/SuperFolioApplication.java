package com.shortthirdman.superfolio;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.stream.Collectors;

@EnableWebMvc
@SpringBootApplication
public class SuperFolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperFolioApplication.class, args);
	}

	@Bean
	public OpenAPI openApiSwagger() {
		Contact contact = new Contact()
				.email("shortthirdman@gmail.com")
				.name("ShortThirdMan")
				.url("https://superfolio.shortthirdman.com");

		License mitLicense = new License()
				.name("MIT License")
				.url("https://choosealicense.com/licenses/mit/")
				.identifier("mit-license");

		Info info = new Info()
				.title("SuperFolio")
				.version("1.0").contact(contact)
				.description("This API exposes endpoints to manage data dictionaries for user portfolio.")
				.termsOfService("https://www.shortthirdman.com/terms")
				.license(mitLicense)
				.summary("SuperFolio");

		return new OpenAPI().info(info);
	}
}
