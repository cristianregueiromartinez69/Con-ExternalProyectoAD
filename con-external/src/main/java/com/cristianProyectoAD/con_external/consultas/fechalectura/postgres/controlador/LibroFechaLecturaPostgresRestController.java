package com.cristianProyectoAD.con_external.consultas.fechalectura.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.fechalectura.postgres.servicio.LibroFechaLecturaServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroFechaLecturaPostgresRestController {

    private final LibroFechaLecturaServicePostgres libroFechaLecturaServicePostgres;

    public LibroFechaLecturaPostgresRestController(LibroFechaLecturaServicePostgres libroServicePostgres) {
        this.libroFechaLecturaServicePostgres = libroServicePostgres;
    }

    @GetMapping("/fechalectura")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresFechaLectura(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaLecturaServicePostgres.getLibrosFechaLecturaPostgres(fechaInicio, fechaFin);
    }
}
