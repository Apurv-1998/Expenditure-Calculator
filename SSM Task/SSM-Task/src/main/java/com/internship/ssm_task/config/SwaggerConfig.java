package com.internship.ssm_task.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	Contact contact = new Contact(
								  "Apurv Sirohi",
								  "https://github.com/Apurv-1998/SSM_TASK",
								  "apurvsirohi1071998@gmail.com");
	
	@SuppressWarnings("rawtypes")
	ArrayList<VendorExtension> vendorExtensions = new ArrayList<>();
	
	ApiInfo apiInfo = new ApiInfo(
            "SSM Internship Task",
            "This page documents Expenditure Details RESTFul Web-Services Endpoint",
            "1.0",
            "https://github.com/Apurv-1998/SSM_TASK",
            contact,
            "Apache 2.0",
            "http://www.apache.org/licences/LICENSE-2.0",
            vendorExtensions);
	
	@Bean
	public Docket apiDocket() {
		
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				            .protocols(new HashSet<>(Arrays.asList("HTTP","HTTPs")))
				            .apiInfo(apiInfo)
				            .select()
				            .apis(RequestHandlerSelectors.basePackage("com.internship.ssm_task"))
				            .paths(PathSelectors.any())
				            .build();
		return docket;
		
	}
	

}
