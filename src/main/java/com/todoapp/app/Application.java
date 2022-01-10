package com.todoapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	/*
	 * TODO:
	 * - Agregar validador para el registro
	 * - Implementar modificar / eliminar items
	 * - Implementar marcar como compleado un item
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
