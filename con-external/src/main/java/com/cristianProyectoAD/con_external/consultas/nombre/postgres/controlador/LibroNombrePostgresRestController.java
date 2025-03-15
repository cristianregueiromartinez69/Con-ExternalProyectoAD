package com.cristianProyectoAD.con_external.consultas.nombre.postgres.controlador;

import com.cristianProyectoAD.con_external.consultas.nombre.postgres.servicio.LibroNombreServicePostgres;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controlador REST para gestionar consultas de libros en PostgreSQL por nombre.
 * Proporciona un endpoint para obtener una lista de libros cuyo nombre coincide con el criterio dado.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/postgresSQL")
public class LibroNombrePostgresRestController {

    private final LibroNombreServicePostgres libroNombreServicePostgres;

    /**
     * Constructor de la clase que inyecta el servicio para manejar la lógica de negocio
     * relacionada con las consultas por nombre en PostgreSQL.
     *
     * @param libroNombreServicePostgres servicio para gestionar las consultas de libros por nombre
     */
    public LibroNombrePostgresRestController(LibroNombreServicePostgres libroNombreServicePostgres) {
        this.libroNombreServicePostgres = libroNombreServicePostgres;
    }

    /**
     * Endpoint para obtener una lista de libros cuyo nombre coincide con el especificado en PostgreSQL.
     *
     * @param nombre el nombre del libro que se desea buscar
     * @return una lista de objetos {@link LibroDto} que representan los libros encontrados,
     * encapsulados en una respuesta HTTP.
     */
    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<LibroDto>> getLibrosPostgresByNombre(@PathVariable String nombre) {
        return libroNombreServicePostgres.getLibrosByNombre(nombre);
    }
}
