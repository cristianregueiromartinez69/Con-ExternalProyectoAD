package com.cristianProyectoAD.con_external.controlador;

import com.cristianProyectoAD.con_external.dto.LibroDto;
import com.cristianProyectoAD.con_external.servicio.LibroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookhub/libros")
public class RegistroLibrosRestController {

    private final LibroService libroService;

    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public ResponseEntity<String> registroControllerLibros(@RequestBody LibroDto libroDto) {
        return libroService.registrarLibro(libroDto);
    }
}
