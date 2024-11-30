package com.cristianProyectoAD.con_external.consultas.nombre.mongo.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio para gestionar la lógica de negocio relacionada con la consulta de libros
 * en MongoDB por nombre.
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroNombreServiceMongo {

    private final PrdRexClient prdRexClient;

    /**
     * Constructor de la clase que inyecta un cliente para comunicarse con el sistema
     * que realiza la consulta de libros en MongoDB.
     *
     * @param prdRexClient cliente de comunicación para realizar consultas externas relacionadas con libros
     */
    public LibroNombreServiceMongo(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Realiza la consulta de libros en MongoDB cuyo nombre coincide con el especificado.
     *
     * @param nombre el nombre del libro que se desea buscar
     * @return una lista de objetos {@link LibroDto} que representan los libros encontrados,
     * encapsulados en una respuesta HTTP.
     */
    public ResponseEntity<List<LibroDto>> getLibrosByNombreMongo(String nombre) {
        return prdRexClient.consultaLibroNombreMongo(nombre);
    }
}
