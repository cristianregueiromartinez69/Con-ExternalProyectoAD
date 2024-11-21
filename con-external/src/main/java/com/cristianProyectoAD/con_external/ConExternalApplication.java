package com.cristianProyectoAD.con_external;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConExternalApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConExternalApplication.class, args);
	}


	/*
	  "Errores" a solucionar:
	  1. doble etiqueta de libro en xml
	  2. que se guarde el xml pese a que la introduccion a las bases de datos es incorrecta
	  3. gestionar error doble clave isbn en registro
	  4. gestionar errores de no devolver nada en consultas
	 */

}
