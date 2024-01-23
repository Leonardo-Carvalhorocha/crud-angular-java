package com.leonardo.crudspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.leonardo.crudspring.Repositorio.RepositoryCourse;
import com.leonardo.crudspring.model.Courses;

import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase( RepositoryCourse repositoryCourse) {
		return args -> {
			repositoryCourse.deleteAll();

			Courses c = new Courses();
			c.setName("Angular");
			c.setCategory("front-end");

			repositoryCourse.save(c);
		};
	}
}
