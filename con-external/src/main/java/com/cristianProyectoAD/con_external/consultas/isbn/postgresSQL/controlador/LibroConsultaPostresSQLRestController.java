package com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.excepcion.NotFoundIsbnException;
import com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.servicio.LibroIsbnService;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.servicio.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroConsultaPostresSQLRestController {

    private final LibroIsbnService libroService;

    public LibroConsultaPostresSQLRestController(LibroIsbnService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/isbn{isbn}")
    public ResponseEntity<LibroDto> getLibrobyISbn(@PathVariable String isbn) {
        ResponseEntity<LibroDto> response = libroService.getLibroByIsbn(isbn);

        if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(response.getBody());
    }
}
