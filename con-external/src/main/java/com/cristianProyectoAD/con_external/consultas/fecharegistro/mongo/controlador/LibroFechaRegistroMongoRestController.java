package com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.fecharegistro.mongo.servicio.LibroFechaRegistroServicioMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroFechaRegistroMongoRestController {

    private final LibroFechaRegistroServicioMongo libroFechaRegistroServicio;

    public LibroFechaRegistroMongoRestController(LibroFechaRegistroServicioMongo libroFechaRegistroServicio) {
        this.libroFechaRegistroServicio = libroFechaRegistroServicio;
    }

    @GetMapping("/fecharegistro")
    public ResponseEntity<List<LibroDto>> getLibrosMongoByFechaR(LocalDate fechaInicio, LocalDate fechaFin) {
        return libroFechaRegistroServicio.getLibrosMongoFechaRegistro(fechaInicio, fechaFin);
    }

}
