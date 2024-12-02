package com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.servicio.LibroFechaRegistroServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en PostgreSQL por fecha de registro.
 * Proporciona un endpoint para obtener una lista de libros registrados dentro de un rango de fechas específico.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroFechaRegistroPostgresRestController {

    private final LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres;

    /**
     * Constructor de la clase que inyecta el servicio para manejar la lógica de negocio
     * relacionada con las consultas por fecha de registro en PostgreSQL.
     *
     * @param libroFechaRegistroServicePostgres servicio para gestionar las consultas de libros
     */
    public LibroFechaRegistroPostgresRestController(LibroFechaRegistroServicePostgres libroFechaRegistroServicePostgres) {
        this.libroFechaRegistroServicePostgres = libroFechaRegistroServicePostgres;
    }

    /**
     * Endpoint para obtener una lista de libros registrados dentro de un rango de fechas específico.
     *
     * @param fechaInicio fecha de inicio del rango de consulta (incluida)
     * @param fechaFin    fecha de fin del rango de consulta (incluida)
     * @return una lista de objetos {@link LibroDto} que representan los libros registrados en el rango especificado,
     * encapsulados en una respuesta HTTP.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByFechaRegistro(@RequestParam LocalDate fechaInicio, @RequestParam LocalDate fechaFin) {
        return libroFechaRegistroServicePostgres.getLibrosByFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
