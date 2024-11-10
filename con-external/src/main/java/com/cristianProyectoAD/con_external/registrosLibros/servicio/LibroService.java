
package com.cristianProyectoAD.con_external.registrosLibros.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Clase servicio de registro de libros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroService {


    //atributo con el servicio a enviar los datos
    private PrdRexClient prdRexClient;

    /**
     * Constructor de la clase
     * @param prdRexClient el cliente al que le vamos a enviar los datos
     */
    public LibroService(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para registrar un libro y mandarlo a otro microservicio
     * @param libro el objeto libro
     * @return el registro
     */
    public ResponseEntity<String> registrarLibro(LibroDto libro) {
        return prdRexClient.registrarLibro(libro);
    }


}
