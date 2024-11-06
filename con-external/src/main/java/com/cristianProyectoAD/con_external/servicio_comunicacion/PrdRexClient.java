package com.cristianProyectoAD.con_external.servicio_comunicacion;

import com.cristianProyectoAD.con_external.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "prd-rex", url = ("http://localhost:8081"))
public interface PrdRexClient {

    @PostMapping("prd-rex/libros/registro")
    ResponseEntity<String> registrarLibro(@RequestBody LibroDto libroDto);
}
