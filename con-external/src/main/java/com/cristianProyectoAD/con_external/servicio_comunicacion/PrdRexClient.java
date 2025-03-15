
package com.cristianProyectoAD.con_external.servicio_comunicacion;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz a donde vamos a enviar los datos del libro, a otro microservicio
 * @author cristian
 * @version 1.0
 */
@FeignClient(name = "prd-rex", url = ("http://localhost:8081"))
public interface PrdRexClient {
    /**
     * Metodo para enviar los datos del libro a la url que hay en el postMapping
     * @param libroDto el libro
     * @return una respuesta que será si se registraron o no
     */
    @PostMapping("/prd-rex/libros/registro")
    ResponseEntity<String> registrarLibro(@RequestBody LibroDto libroDto);

    /**
     * Consulta un libro en PostgreSQL utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("/prd-rex/libros/consulta/postresSQL/isbn/{isbn}")
    ResponseEntity<LibroDto> consultarLibroIsbnPostgres(@PathVariable("isbn") String isbn);

    /**
     * Consulta un libro en MongoDB utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("/prd-rex/libros/consulta/mongoDB/isbn/{isbn}")
    ResponseEntity<LibroDto> consultaLibroIsbnMongo(@PathVariable("isbn") String isbn);

    /**
     * Consulta un libro en un fichero utilizando su ISBN.
     *
     * @param isbn El ISBN del libro.
     * @return ResponseEntity con los datos del libro si se encuentra.
     */
    @GetMapping("/prd-rex/libros/consulta/ficheros/isbn/{isbn}")
    ResponseEntity<LibroDto> consultaLibroIsbnFichero(@PathVariable("isbn") String isbn);

    /**
     * Consulta libros en PostgreSQL utilizando el nombre de un autor.
     *
     * @param autor El nombre del autor.
     * @return ResponseEntity con una lista de libros del autor si se encuentran.
     */
    @GetMapping("/prd-rex/libros/consulta/postgresSQL/autor/{autor}")
    ResponseEntity<List<LibroDto>> consultarLibrosAutorPostgres(@PathVariable("autor") String autor);

    /**
     * Consulta los libros de un autor en MongoDB.
     *
     * @param autor El nombre del autor
     * @return lista de libros encontrados del autor en MongoDB
     */
    @GetMapping("/prd-rex/libros/consulta/mongoDB/autor/{autor}")
    ResponseEntity<List<LibroDto>> consultaLibroAutorMongo(@PathVariable("autor") String autor);

    /**
     * Consulta los libros de un autor en PostgreSQL por nombre.
     *
     * @param nombre El nombre del libro
     * @return lista de libros encontrados con el nombre proporcionado en PostgreSQL
     */
    @GetMapping("/prd-rex/libros/consulta/postgresSQL/nombre/{nombre}")
    ResponseEntity<List<LibroDto>> consultarLibrosNombrePostgres(@PathVariable("nombre") String nombre);

    /**
     * Consulta los libros de un autor en MongoDB por nombre.
     *
     * @param nombre El nombre del libro
     * @return lista de libros encontrados con el nombre proporcionado en MongoDB
     */
    @GetMapping("/prd-rex/libros/consulta/mongoDB/nombre/{nombre}")
    ResponseEntity<List<LibroDto>> consultaLibroNombreMongo(@PathVariable("nombre") String nombre);


    /**
     * Consulta libros en PostgreSQL por rango de fechas de registro.
     *
     * @param fechaInicio Fecha de inicio para el rango de consulta
     * @param fechaFin Fecha de fin para el rango de consulta
     * @return lista de libros encontrados dentro del rango de fechas en PostgreSQL
     */
    @GetMapping("/prd-rex/libros/consulta/postgresSQL/fecharegistro")
    ResponseEntity<List<LibroDto>> consultaLibroFechaRegistroPostgres(@RequestParam("fechaInicio") LocalDate fechaInicio ,
                                                                      @RequestParam("fechaFin") LocalDate fechaFin);

    /**
     * Consulta libros en MongoDB por rango de fechas de registro.
     *
     * @param fechaInicio Fecha de inicio para el rango de consulta
     * @param fechaFin Fecha de fin para el rango de consulta
     * @return lista de libros encontrados dentro del rango de fechas en MongoDB
     */
    @GetMapping("/prd-rex/libros/consulta/mongoDB/fecharegistro")
    ResponseEntity<List<LibroDto>> consultaLibroFechaRegistroMongo(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                                   @RequestParam("fechaFin") LocalDate fechaFin);


    /**
     * Consulta libros en PostgreSQL por rango de fechas de lectura.
     *
     * @param fechaInicio Fecha de inicio para el rango de consulta
     * @param fechaFin Fecha de fin para el rango de consulta
     * @return lista de libros encontrados dentro del rango de fechas en PostgreSQL
     */
    @GetMapping("/prd-rex/libros/consulta/postgresSQL/fechalectura")
    ResponseEntity<List<LibroDto>> consultaLibroFechaLecturaPostgres(@RequestParam("fechaInicio") LocalDate fechaInicio ,
                                                                      @RequestParam("fechaFin") LocalDate fechaFin);


    /**
     * Consulta libros en MongoDB por rango de fechas de lectura.
     *
     * @param fechaInicio Fecha de inicio para el rango de consulta
     * @param fechaFin Fecha de fin para el rango de consulta
     * @return lista de libros encontrados dentro del rango de fechas en MongoDB
     */
    @GetMapping("/prd-rex/libros/consulta/mongoDB/fechalectura")
    ResponseEntity<List<LibroDto>> consultaLibroFechaLecturaMongo(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                                   @RequestParam("fechaFin") LocalDate fechaFin);










}
