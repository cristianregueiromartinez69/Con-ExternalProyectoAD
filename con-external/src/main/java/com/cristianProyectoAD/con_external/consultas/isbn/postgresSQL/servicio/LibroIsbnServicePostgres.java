package com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Rest controller para consultas por isbn de postgres
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnServicePostgres {

    //variable final del servicio
    private final PrdRexClient prdRexClient;

    /**
     * Constructor de la clase
     * @param prdRexClient servicio de postgres
     */
    public LibroIsbnServicePostgres(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para mandar la consulta a prd-rex y que nos devuelva el libro
     * @param isbn el isbn a buscar
     * @return el libro o null
     */
    public ResponseEntity<LibroDto> getLibroByIsbnPostgres(String isbn) {
        return prdRexClient.consultarLibroIsbnPostgres(isbn);
    }
}
