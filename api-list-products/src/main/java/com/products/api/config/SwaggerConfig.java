package com.products.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	@Bean
	public Docket beanDetails() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		docket.select().apis(RequestHandlerSelectors.basePackage("com.products.api")).paths(PathSelectors.any()).build()
				.apiInfo(this.informationsApi().build());
		return docket;
	}

	private ApiInfoBuilder informationsApi() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title("API de listagem de produtos");
		apiInfoBuilder.description("Listagem de produtos com mercado alvo e tecnologias");
		apiInfoBuilder.contact(this.contact());
		return apiInfoBuilder;

	}

	private Contact contact() {
		return new Contact("Vinícius de Souza Augutis", "", "");
	}
}