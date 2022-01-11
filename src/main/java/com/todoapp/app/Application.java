package com.todoapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	/*
	 * TODO:
	 * - Agregar validador para el registro
	 * - Hacer que el script funcione en otro archivo
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
