package com.cristianProyectoAD.con_external.consultas.isbn.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.mongo.servicio.LibroIsbnServiceMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller para consultas por isbn de mongo
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroIsbnMongoDBRestController {

    //variable final del servicio
    private final LibroIsbnServiceMongo libroService;

    /**
     * Constructor de la clase
     * @param libroService servicio de mongo
     */
    public LibroIsbnMongoDBRestController(LibroIsbnServiceMongo libroService) {
        this.libroService = libroService;
    }

    /**
     * endpoint para mandar las consultas por isbn
     * @param isbn el isbn a buscar
     * @return el libro o null
     */
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LibroDto> getLibrobyISbn(@PathVariable String isbn) {
        /*
          Explicacion:
          1. creamos un objeto ResponseEntity igual a un metodo que nos va a devolver un libro por isbn
          2. si no lo encuentra, devuelve null
          3. si no devuelve el libro por isbn
         */
        ResponseEntity<LibroDto> response = libroService.getLibroByIsbnMongo(isbn);
        return ResponseEntity.ok(response.getBody());
    }
}