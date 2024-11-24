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
	  1. gestionar error doble clave isbn en registro en base de datos
	  2. gestionar errores de no devolver nada en consultas que no devuelven nada
	 */

	//TODO: solucionar que no de error 500 en registro de doble isbn

}
