package com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.servicio.LibroIsbnServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller para consultas por isbn de postgresSQL
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroConsultaIsbnPostresSQLRestController {

    //variable final del servicio
    private final LibroIsbnServicePostgres libroService;

    /**
     * Constructor de la clase
     * @param libroService servicio de mongo
     */
    public LibroConsultaIsbnPostresSQLRestController(LibroIsbnServicePostgres libroService) {
        this.libroService = libroService;
    }

    /**
     * endpoint para mandar las consultas por isbn
     * @param isbn el isbn a buscar
     * @return el libro o null
     */
    @GetMapping("/isbn{isbn}")
    public ResponseEntity<LibroDto> getLibrobyISbn(@PathVariable String isbn) {
        /*
          Explicacion:
          1. creamos un objeto ResponseEntity igual a un metodo que nos va a devolver un libro por isbn
          2. si no lo encuentra, devuelve null
          3. si no devuelve el libro por isbn
         */
        ResponseEntity<LibroDto> response = libroService.getLibroByIsbnPostgres(isbn);

        if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(response.getBody());
    }
}
