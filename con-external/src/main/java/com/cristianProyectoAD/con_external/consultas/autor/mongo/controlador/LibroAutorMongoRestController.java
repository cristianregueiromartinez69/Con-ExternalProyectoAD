package com.cristianProyectoAD.con_external.consultas.autor.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.autor.mongo.servicio.LibroAutorServiceMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en MongoDB por autor.
 * Este controlador proporciona un endpoint para buscar libros cuyo autor coincide con el especificado.
 * Utiliza un servicio para realizar la consulta en la base de datos MongoDB.
 *
 * @author Cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroAutorMongoRestController {

    private final LibroAutorServiceMongo libroAutorServiceMongo;

    /**
     * Constructor que inyecta el servicio encargado de las consultas por autor en MongoDB.
     *
     * @param libroAutorServiceMongo Servicio de consulta de libros por autor en MongoDB.
     */
    public LibroAutorMongoRestController(LibroAutorServiceMongo libroAutorServiceMongo) {
        this.libroAutorServiceMongo = libroAutorServiceMongo;
    }

    /**
     * Endpoint para obtener una lista de libros filtrados por el autor especificado.
     *
     * @param autor El nombre del autor por el cual se desea filtrar los libros.
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado HTTP adecuado si no se encuentran resultados.
     */
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<LibroDto>> getLibroByAutor(@PathVariable String autor) {
        ResponseEntity<List<LibroDto>> response = libroAutorServiceMongo.getLibrosMongoByAutor(autor);
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }
}
