package com.softtek.academy.projectCOVID19.mainController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.softtek.academy.projectCOVID19.repositoryMethods")
@EntityScan("com.softtek.academy.projectCOVID19.dataBaseEntities.*") 
@ComponentScan(basePackages= {"com.softtek.academy.projectCOVID19"})
public class ProjectCovid19Application {
	
	public static void main(String[] args) {
		SpringApplication.run(ProjectCovid19Application.class, args);
	}

}
