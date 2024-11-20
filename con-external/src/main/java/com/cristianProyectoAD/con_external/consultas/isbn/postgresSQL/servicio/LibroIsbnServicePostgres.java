package com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroIsbnServicePostgres {

    private final PrdRexClient prdRexClient;

    public LibroIsbnServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<LibroDto> getLibroByIsbnPostgres(String isbn) {
        return ResponseEntity.ok(prdRexClient.consultarLibroIsbnPostgres(isbn));
    }
}
