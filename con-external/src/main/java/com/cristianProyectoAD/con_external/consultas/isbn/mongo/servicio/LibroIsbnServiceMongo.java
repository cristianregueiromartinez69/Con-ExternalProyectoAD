package com.cristianProyectoAD.con_external.consultas.isbn.mongo.servicio;


import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Servicio de consultas de libro por isbn en mongo
 * @author cristian
 * @verison 1.0
 */
@Service
public class LibroIsbnServiceMongo {

    //atributo final del cliente
    private final PrdRexClient prdRexClient;

    /**
     * Contructor de la clase
     * @param prdRexClient el cliente
     */
    public LibroIsbnServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para mandar la consulta a prd-rex y que nos devuelva el libro
     * @param isbn el isbn a buscar
     * @return el libro o null
     */
    public ResponseEntity<LibroDto> getLibroByIsbnMongo(String isbn) {
        return prdRexClient.consultaLibroIsbnMongo(isbn);
    }
}