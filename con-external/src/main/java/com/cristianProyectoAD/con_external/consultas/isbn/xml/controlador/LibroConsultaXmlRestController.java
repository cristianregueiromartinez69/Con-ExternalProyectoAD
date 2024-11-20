package com.cristianProyectoAD.con_external.consultas.isbn.xml.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.xml.servicio.LibroIsbnServiceXml;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookhub/libros/consulta/ficheros")
public class LibroConsultaXmlRestController {

    private final LibroIsbnServiceXml libroService;

    public LibroConsultaXmlRestController(LibroIsbnServiceXml libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<LibroDto> getLibroByIsbn(@PathVariable String isbn) {
        ResponseEntity<LibroDto> response = libroService.getLibroByIsbnFichero(isbn);

        if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        return response;
    }
}

