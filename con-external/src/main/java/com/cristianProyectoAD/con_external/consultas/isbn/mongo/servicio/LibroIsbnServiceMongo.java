package com.cristianProyectoAD.con_external.consultas.isbn.mongo.servicio;


import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroIsbnServiceMongo {

    private final PrdRexClient prdRexClient;

    public LibroIsbnServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<LibroDto> getLibroByIsbnMongo(String isbn) {
        return ResponseEntity.ok(prdRexClient.consultaLibroIsbnMongo(isbn));
    }
}