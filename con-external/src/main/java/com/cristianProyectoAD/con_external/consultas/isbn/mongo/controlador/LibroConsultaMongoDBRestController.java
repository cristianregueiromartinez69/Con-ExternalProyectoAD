package com.cristianProyectoAD.con_external.consultas.isbn.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.mongo.servicio.LibroIsbnServiceMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroConsultaMongoDBRestController {

    private final LibroIsbnServiceMongo libroService;

    public LibroConsultaMongoDBRestController(LibroIsbnServiceMongo libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/isbn{isbn}")
    public ResponseEntity<LibroDto> getLibrobyISbn(@PathVariable String isbn) {
        ResponseEntity<LibroDto> response = libroService.getLibroByIsbnMongo(isbn);

        if(response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(response.getBody());
    }
}