package com.cristianProyectoAD.con_external.consultas.fecharegistro.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaRegistroServicePostgres {

    private final PrdRexClient prdRexClient;

    public LibroFechaRegistroServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosByFechaRegistroPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaRegistroPostgres(fechaInicio, fechaFin);
    }
}
