package com.cristianProyectoAD.con_external.consultas.nombre.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroNombreServiceMongo {

    private final PrdRexClient prdRexClient;

    public LibroNombreServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosByNombreMongo(String nombre) {
        return prdRexClient.consultaLibroNombreMongo(nombre);
    }
}
