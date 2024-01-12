package com.Project2.CustomerManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

@OpenAPIDefinition(
	info = @Info(
		title= "CUSTOMER MANAGEMENET",
				version= "2.0.1",
				description= "Hello THere",
				termsOfService = "Nothing",
				contact = @Contact(
						name = "Mr. Vaibhav Waghmare",
						email = "xyz.com"
				),
				license = @License(
						name = "copyright @2020",
						url = "something.com"
				)
	)
)

public class CustomerManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerManagementApplication.class, args);
		System.out.println("--------------------->>>> Application Started  <<<<<<<<<<<<<<<<<<-----------------");
	}

}
