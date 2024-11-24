package com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroFechaRegistroPostgresRestController {

    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    @GetMapping("/{fechaInicio}/{fechaFin}")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByFechaRegistro(@PathVariable LocalDate fechaInicio, @PathVariable LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
