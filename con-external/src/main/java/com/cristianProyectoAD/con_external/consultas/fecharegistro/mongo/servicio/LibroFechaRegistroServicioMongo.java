package com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroServicioMongo {

    private final PrdRexClient prdRexClient;

    public LibroFechaRegistroServicioMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosMongoFechaRegistro(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaRegistroMongo(fechaInicio, fechaFin);
    }
}
