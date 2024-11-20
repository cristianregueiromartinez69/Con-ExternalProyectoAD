package com.cristianProyectoAD.con_external.consultas.isbn.xml.servicio;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LibroIsbnServiceXml {

    private final PrdRexClient prdRexClient;

    public LibroIsbnServiceXml(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    public ResponseEntity<LibroDto> getLibroByIsbnFichero(String isbn) {
        ResponseEntity<LibroDto> response = prdRexClient.consultaLibroIsbnFichero(isbn);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Opcional: puedes devolver un mensaje genérico en lugar de null
        }

        return response;
    }
}

