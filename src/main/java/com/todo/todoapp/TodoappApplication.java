package com.todo.todoapp;
//Package name-groups all todo app classes together

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//Main annotation that enables Spring Boot,auto-configuration and component scanning
public class TodoappApplication {

	public static void main(String[] args)//Entry point of the application
            //Starts the Spring Boot Application
    {
		SpringApplication.run(TodoappApplication.class, args);
	}

}

