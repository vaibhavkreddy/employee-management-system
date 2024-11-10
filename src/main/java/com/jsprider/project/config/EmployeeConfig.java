package com.jsprider.project.config;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jsprider.project")
public class EmployeeConfig {
	@Bean(value = "emf")
	public EntityManager getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("employee").createEntityManager();
		
	}
	

}
