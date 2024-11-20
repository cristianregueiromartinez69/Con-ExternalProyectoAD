package com.cristianProyectoAD.con_external.consultas.isbn.xml.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;

public class LibroIsbnServiceXml {

    private final PrdRexClient prdRexClient;

    public LibroIsbnServiceXml(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<LibroDto> getLibroByIsbnFichero(String isbn) {
        return ResponseEntity.ok(prdRexClient.consultaLibroIsbnFichero(isbn));
    }
}
