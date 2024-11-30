package com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.servicio.LibroFechaRegistroServicioMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros registrados en un rango de fechas
 * dentro de una base de datos MongoDB.
 *
 * Proporciona un endpoint para obtener una lista de libros registrados entre dos fechas específicas.
 *
 * @author Cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroFechaRegistroMongoRestController {

    private final LibroFechaRegistroServicioMongo libroFechaRegistroServicio;

    /**
     * Constructor que inyecta la dependencia del servicio de consultas por rango de fechas.
     *
     * @param libroFechaRegistroServicio Servicio que realiza la lógica de negocio para las consultas en MongoDB.
     */
    public LibroFechaRegistroMongoRestController(LibroFechaRegistroServicioMongo libroFechaRegistroServicio) {
        this.libroFechaRegistroServicio = libroFechaRegistroServicio;
    }

    /**
     * Endpoint para obtener libros registrados entre un rango de fechas.
     *
     * @param fechaInicio Fecha de inicio del rango (inclusive).
     * @param fechaFin Fecha de fin del rango (inclusive).
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado adecuado en caso de error.
     */
    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDto>> getLibrosMongoByFechaR(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaRegistroServicio.getLibrosMongoFechaRegistro(fechaInicio, fechaFin);
    }

}
