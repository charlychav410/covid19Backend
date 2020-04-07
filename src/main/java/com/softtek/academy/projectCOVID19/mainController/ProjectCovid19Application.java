package com.softtek.academy.projectCOVID19.mainController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= {"com.softtek.academy"})
public class ProjectCovid19Application {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectCovid19Application.class, args);
	}

}
