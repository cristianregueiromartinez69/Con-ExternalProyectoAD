package com.cristianProyectoAD.con_external.consultas.nombre.mongo.controlador;

import com.cristianProyectoAD.con_external.consultas.nombre.mongo.servicio.LibroNombreServiceMongo;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookhub/libros/consulta/mongoDB")
public class LibroNombreMongoRestController {

    private final LibroNombreServiceMongo libroNombreServiceMongo;

    public LibroNombreMongoRestController(LibroNombreServiceMongo libroNombreServiceMongo) {
        this.libroNombreServiceMongo = libroNombreServiceMongo;
    }

    @GetMapping("/nombre{nombre}")
    public ResponseEntity<List<LibroDto>> getLibroNombreMongo(@PathVariable String nombre) {
        return libroNombreServiceMongo.getLibrosByNombreMongo(nombre);
    }
}
