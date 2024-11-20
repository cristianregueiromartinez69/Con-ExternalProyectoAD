package com.cristianProyectoAD.con_external.consultas.isbn.mongo.servicio;


import com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.excepcion.NotFoundIsbnException;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
public class LibroIsbnService {

    private final PrdRexClient prdRexClient;

    public LibroIsbnService(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<LibroDto> getLibroByIsbn(String isbn) {
        return ResponseEntity.ok(prdRexClient.consultaLibroIsbnMongo(isbn));
    }
}