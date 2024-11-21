package com.cristianProyectoAD.con_external.consultas.nombre.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.nombre.postgres.servicio.LibroNombreServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroNombrePostgresRestController {

    private final LibroNombreServicePostgres libroNombreServicePostgres;

    public LibroNombrePostgresRestController(LibroNombreServicePostgres libroNombreServicePostgres) {
        this.libroNombreServicePostgres = libroNombreServicePostgres;
    }

    @GetMapping("/nombre{nombre}")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByNombre(@PathVariable String nombre) {
        return libroNombreServicePostgres.getLibrosByNombre(nombre);
    }
}
