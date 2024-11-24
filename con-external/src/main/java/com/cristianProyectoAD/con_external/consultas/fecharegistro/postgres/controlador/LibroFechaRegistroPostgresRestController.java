package com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroFechaRegistroPostgresRestController {

    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByFechaRegistro(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
