package com.idcard.school.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.idcard.school"))
				.paths(PathSelectors.any()).build();
				// .apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any())
				// .paths(PathSelectors.any()).build();
	}
	
	private ApiInfo getInfo() {
		return new ApiInfo("ID Card Generator","This project developed by Navin Ranjan" ,
				"1.0.0", "Term of Service", new Contact("Navin Ranjan", "https://github.com/navin-ranjan/IDCardSystem/", "navinranjan15498@Gmail.com"),
				"Licences of API", "API licences URL",Collections.emptyList());
	}

}
