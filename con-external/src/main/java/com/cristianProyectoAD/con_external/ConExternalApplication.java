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


	//TODO: hacer consultas entre fechas de registro

	/*
	  (Para Más adelante)
	  1. Mejorar control de errores de no devolver nada
	  2. hacer algo con fecha lectura
	 */

}
