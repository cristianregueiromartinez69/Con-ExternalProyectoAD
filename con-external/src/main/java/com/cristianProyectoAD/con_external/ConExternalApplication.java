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


}
