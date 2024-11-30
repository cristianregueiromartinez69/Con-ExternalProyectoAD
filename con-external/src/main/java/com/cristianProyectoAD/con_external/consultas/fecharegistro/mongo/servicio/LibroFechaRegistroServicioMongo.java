package com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio para gestionar consultas de libros registrados en un rango de fechas
 * dentro de una base de datos MongoDB.
 * Proporciona la lógica de negocio necesaria para interactuar con el cliente que realiza
 * las consultas a la base de datos externa.
 *
 * @author Cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroServicioMongo {

    private final PrdRexClient prdRexClient;

    /**
     * Constructor que inyecta la dependencia del cliente de comunicación externa.
     *
     * @param prdRexClient Cliente para realizar consultas a servicios externos.
     */
    public LibroFechaRegistroServicioMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Obtiene una lista de libros registrados en MongoDB dentro de un rango de fechas específico.
     *
     * @param fechaInicio Fecha de inicio del rango (inclusive).
     * @param fechaFin Fecha de fin del rango (inclusive).
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado adecuado en caso de error.
     */
    public ResponseEntity<List<LibroDto>> getLibrosMongoFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaRegistroMongo(fechaInicio, fechaFin);
    }
}
