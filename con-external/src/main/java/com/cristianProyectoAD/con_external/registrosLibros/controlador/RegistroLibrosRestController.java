
package com.cristianProyectoAD.con_external.registrosLibros.controlador;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para enviar la información de los libros al prd-rex
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros")
public class RegistroLibrosRestController {

    //atributo del servicio
    private final LibroService libroService;

    /**
     * Constructor de la clase
     * @param libroService el servicio de libros
     */
    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Metodo para mandar los libros a otro microservicio
     * @param libroDto el objeto libros
     * @return si se guardó o no se guardó
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registroControllerLibros(@RequestBody LibroDto libroDto) {
        return libroService.registrarLibro(libroDto);
    }
}
