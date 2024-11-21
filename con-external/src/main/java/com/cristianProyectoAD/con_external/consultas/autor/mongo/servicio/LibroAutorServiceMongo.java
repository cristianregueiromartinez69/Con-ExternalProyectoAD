package com.cristianProyectoAD.con_external.consultas.autor.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorServiceMongo {
    private final PrdRexClient prdRexClient;

    public LibroAutorServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosMongoByAutor(String autor){
        return prdRexClient.consultaLibroAutorMongo(autor);
    }
}
