package com.cristianProyectoAD.con_external.consultas.nombre.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreServicePostgres {

    private final PrdRexClient prdRexClient;

    public LibroNombreServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosByNombre(String nombre) {
        return prdRexClient.consultarLibrosNombrePostgres(nombre);
    }
}
