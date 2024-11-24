package com.cristianProyectoAD.con_external.consultas.autor.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.autor.mongo.servicio.LibroAutorServiceMongo;
import com.cristianProyectoAD.con_external.consultas.autor.postgres.servicio.LibroAutorServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroAutorMongoRestController {

    private final LibroAutorServiceMongo libroAutorServiceMongo;

    public LibroAutorMongoRestController(LibroAutorServiceMongo libroAutorServiceMongo) {
        this.libroAutorServiceMongo = libroAutorServiceMongo;
    }

    @GetMapping("/autor{autor}")
    public ResponseEntity<List<LibroDto>> getLibroByAutor(@PathVariable String autor) {
        ResponseEntity<List<LibroDto>> response = libroAutorServiceMongo.getLibrosMongoByAutor(autor);
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
