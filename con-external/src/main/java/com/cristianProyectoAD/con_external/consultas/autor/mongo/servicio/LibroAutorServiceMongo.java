package com.cristianProyectoAD.con_external.consultas.autor.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que proporciona la lógica para consultar libros almacenados en MongoDB por autor.
 * Este servicio actúa como intermediario entre el cliente y el cliente REST que se comunica con otro microservicio.
 *
 * @author Cristian
 * @version 1.0
 */
@Service
public class LibroAutorServiceMongo {
    private final PrdRexClient prdRexClient;

    /**
     * Constructor que inyecta el cliente REST utilizado para realizar las consultas.
     *
     * @param prdRexClient Cliente REST encargado de comunicarse con el microservicio correspondiente.
     */
    public LibroAutorServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Realiza una consulta para obtener una lista de libros en MongoDB filtrados por autor.
     *
     * @param autor El nombre del autor utilizado como filtro en la consulta.
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado adecuado en caso de no encontrarse resultados.
     */
    public ResponseEntity<List<LibroDto>> getLibrosMongoByAutor(String autor){
        return prdRexClient.consultaLibroAutorMongo(autor);
    }
}
