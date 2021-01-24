package com.albo.comics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.albo.comics.config.SwaggerConfiguration;

@SpringBootApplication
@ComponentScan("com")
@Import(SwaggerConfiguration.class)
public class AlboComicsApplication  implements WebMvcConfigurer {

	public static void main(String[] args) {
	  
		SpringApplication
		  .run(AlboComicsApplication.class,
		       args);
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  
		registry
			.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");
		
	}
	
}
