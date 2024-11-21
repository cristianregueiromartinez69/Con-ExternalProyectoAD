package com.cristianProyectoAD.con_external.consultas.autor.postgres.controlador;

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
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroAutorPostgresSQLRestController {

    private final LibroAutorServicePostgres libroAutorServicePostgres;

    public LibroAutorPostgresSQLRestController(LibroAutorServicePostgres libroAutorServicePostgres) {
        this.libroAutorServicePostgres = libroAutorServicePostgres;
    }

    @GetMapping("/autor{autor}")
    public ResponseEntity<List<LibroDto>> getLibroByAutor(@PathVariable String autor) {
        ResponseEntity<List<LibroDto>> response = libroAutorServicePostgres.getLibrosPostgresByAutor(autor);

        if(response.getStatusCode() == HttpStatus.NOT_FOUND){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}
