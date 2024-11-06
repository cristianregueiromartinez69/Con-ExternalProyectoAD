package com.cristianProyectoAD.con_external.registrosLibros.servicio_comunicacion;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "prd-rex", url = ("http://localhost:8081"))
public interface PrdRexClient {

    @PostMapping("prd-rex/libros/registro")
    ResponseEntity<String> registrarLibro(@RequestBody LibroDto libroDto);
}
