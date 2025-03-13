package com.cristianProyectoAD.con_external.consultas.fechalectura.mongo.service;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio de consulta de libros en mongo por fecha de lectura
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaLecturaMongoService {

    //servicio de comunicacion
    private final PrdRexClient prdRexClient;

    /**
     * Constructor de la clase
     * @param prdRexClient el servicio de comunicacion
     */
    public LibroFechaLecturaMongoService(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para devolver un libro entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return el listado de libros
     */
    public ResponseEntity<List<LibroDto>> getLibrosByFechaLecturaMongoService(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaLecturaMongo(fechaInicio, fechaFin);
    }
}
