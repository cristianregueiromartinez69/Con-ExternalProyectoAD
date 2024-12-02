package com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Servicio para gestionar la lógica de negocio relacionada con la consulta de libros
 * registrados en PostgreSQL dentro de un rango de fechas.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroFechaRegistroServicePostgres {

    private final PrdRexClient prdRexClient;

    /**
     * Constructor de la clase que inyecta un cliente para comunicarse con el sistema
     * que realiza la consulta de libros en PostgreSQL.
     *
     * @param prdRexClient cliente de comunicación para realizar consultas externas relacionadas con libros
     */
    public LibroFechaRegistroServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Realiza la consulta de libros registrados en PostgreSQL dentro de un rango de fechas específico.
     *
     * @param fechaInicio fecha de inicio del rango de consulta (incluida)
     * @param fechaFin    fecha de fin del rango de consulta (incluida)
     * @return una lista de objetos {@link LibroDto} que representan los libros encontrados,
     * encapsulados en una respuesta HTTP.
     */
    public ResponseEntity<List<LibroDto>> getLibrosByFechaRegistroPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
