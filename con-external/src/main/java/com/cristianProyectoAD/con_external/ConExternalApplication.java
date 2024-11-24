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
	  1. gestionar errores de no devolver nada en consultas que no devuelven nada
	  2. (Opcional) hacer algo con fecha lectura
	 */

	//TODO: solucionar que devuelva badrequest si no hay nada que devolver en consulta isbn

}
