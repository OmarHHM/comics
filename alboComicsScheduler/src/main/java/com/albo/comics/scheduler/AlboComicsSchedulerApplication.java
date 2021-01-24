package com.albo.comics.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AlboComicsSchedulerApplication {

	public static void main(String[] args) {
		SpringApplication
		   .run(AlboComicsSchedulerApplication.class, args);
	}

}
