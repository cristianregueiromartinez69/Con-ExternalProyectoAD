package com.cristianProyectoAD.con_external.consultas.autor.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.autor.postgres.servicio.LibroAutorServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en una base de datos PostgreSQL.
 * Proporciona un punto de acceso para obtener libros filtrados por autor desde PostgreSQL.
 *
 * @author Cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroAutorPostgresSQLRestController {

    private final LibroAutorServicePostgres libroAutorServicePostgres;

    /**
     * Constructor que inyecta el servicio encargado de realizar la lógica de consultas a PostgreSQL.
     *
     * @param libroAutorServicePostgres Servicio que interactúa con la capa lógica de PostgreSQL.
     */
    public LibroAutorPostgresSQLRestController(LibroAutorServicePostgres libroAutorServicePostgres) {
        this.libroAutorServicePostgres = libroAutorServicePostgres;
    }

    /**
     * Punto de acceso HTTP GET para obtener una lista de libros filtrados por autor desde PostgreSQL.
     *
     * @param autor El nombre del autor utilizado como filtro en la consulta.
     * @return Una respuesta HTTP que contiene una lista de objetos {@link LibroDto} con los libros encontrados,
     * o un estado HTTP adecuado en caso de error.
     */
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<LibroDto>> getLibroByAutor(@PathVariable String autor) {
        ResponseEntity<List<LibroDto>> response = libroAutorServicePostgres.getLibrosPostgresByAutor(autor);
        return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
    }

}
