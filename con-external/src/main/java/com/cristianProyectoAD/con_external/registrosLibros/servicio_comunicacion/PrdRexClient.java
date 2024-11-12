
package com.cristianProyectoAD.con_external.registrosLibros.servicio_comunicacion;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Interfaz a donde vamos a enviar los datos del libro, a otro microservicio
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "prd-rex", url = ("http://localhost:8081"))
public interface PrdRexClient {
    /**
     * Metodo para enviar los datos del libro a la url que hay en el postMapping
     * @param libroDto el libro
     * @return una respuesta que será si se registraron o no
     */
    @PostMapping("/prd-rex/libros/registro")
    ResponseEntity<String> registrarLibro(@RequestBody LibroDto libroDto);

    @GetMapping("/prd-rex/libros/consulta/postresSQL/isbn/{isbn}")
    LibroDto consultarLibro(@PathVariable("isbn") String isbn);
}
