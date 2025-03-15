package com.cristianProyectoAD.con_external.consultas.fechalectura.mongo.controller;

import com.cristianProyectoAD.con_external.consultas.fechalectura.mongo.service.LibroFechaLecturaMongoService;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * Rest controller consulta libro fecha lectura
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroFechaLecturaMongoRestController {

    //variable del servicio de fecha de lectura
    private final LibroFechaLecturaMongoService libroFechaLecturaMongoService;

    /**
     * Constructor de la clase
     * @param libroFechaLecturaMongoService el servicio de mongo fecha lectura
     */
    public LibroFechaLecturaMongoRestController(LibroFechaLecturaMongoService libroFechaLecturaMongoService) {
        this.libroFechaLecturaMongoService = libroFechaLecturaMongoService;
    }

    /**
     * Get para obtener un listado de libros en mongo entre fechas de lectura
     * @param fechaInicio la fecha de inicio
     * @param fechaFin la fecha de fin
     * @return el listado de libros entre fechas de lectura
     */
    @GetMapping("/fechalectura")
    public ResponseEntity<List<LibroDto>> getLibroByfechaLecturaMongoRestController(@RequestParam("fechaInicio") LocalDate fechaInicio,
                                                                                    @RequestParam("fechaFin") LocalDate fechaFin){

        return libroFechaLecturaMongoService.getLibrosByFechaLecturaMongoService(fechaInicio, fechaFin);
    }
}
