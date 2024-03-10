package com.jsp.swastha.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Swastha", "www.Swastha.com", "Swastha@gmail.com");
		List<VendorExtension> extention = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("Swastha", "WE ARE HERE TO SERVICE YOU", "verstion 1.0", "terms", contact,
				"license", "url", extention);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.jsp.swastha")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
		
	}

}
