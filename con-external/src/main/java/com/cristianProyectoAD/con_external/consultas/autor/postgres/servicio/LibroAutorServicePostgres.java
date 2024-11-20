package com.cristianProyectoAD.con_external.consultas.autor.postgres.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroAutorServicePostgres {

    private final PrdRexClient prdRexClient;

    public LibroAutorServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<List<LibroDto>> getLibrosPostgresByAutor(String autor){
        return prdRexClient.consultarLibrosAutorPostgres(autor);
    }
}
