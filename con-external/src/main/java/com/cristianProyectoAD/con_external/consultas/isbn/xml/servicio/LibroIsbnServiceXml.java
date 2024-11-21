package com.cristianProyectoAD.con_external.consultas.isbn.xml.servicio;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Servicio para consulta de libros en ficheros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroIsbnServiceXml {

    //variable final del servicio
    private final PrdRexClient prdRexClient;

    /**
     * Constructor de la clase
     * @param prdRexClient el cliente
     */
    public LibroIsbnServiceXml(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para buscar libro por isbn en ficheros xml
     * @param isbn el isbn
     * @return el libro o null
     */
    public ResponseEntity<LibroDto> getLibroByIsbnFichero(String isbn) {
        /*
          Explicacion:
          1. creamos una variable para almacenar el libro
          2. si hay resultado, lo mostramos, si no es null
         */
        ResponseEntity<LibroDto> response = prdRexClient.consultaLibroIsbnFichero(isbn);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Opcional: puedes devolver un mensaje genérico en lugar de null
        }

        return response;
    }
}

