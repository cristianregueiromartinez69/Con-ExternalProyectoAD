package com.cristianProyectoAD.con_external.consultas.fechalectura.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibroFechaLecturaServicePostgres {

    private final PrdRexClient prdRexClient;

    public LibroFechaLecturaServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosFechaLecturaPostgres(LocalDate fechaInicio, LocalDate fechaFin) {
        return prdRexClient.consultaLibroFechaLecturaPostgres(fechaInicio, fechaFin);
    }
}
