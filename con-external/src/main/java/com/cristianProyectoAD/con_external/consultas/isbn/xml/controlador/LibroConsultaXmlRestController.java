package com.cristianProyectoAD.con_external.consultas.isbn.xml.controlador;

import com.cristianProyectoAD.con_external.consultas.isbn.xml.servicio.LibroIsbnServiceXml;
import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST para la consulta de libros a través de un fichero XML.
 * Proporciona endpoints para recuperar información de libros mediante su ISBN.
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros/consulta/ficheros")
public class LibroConsultaXmlRestController {

    private final LibroIsbnServiceXml libroService;

    /**
     * Constructor del controlador.
     *
     * @param libroService Servicio para gestionar las consultas de libros por ISBN.
     */
    public LibroConsultaXmlRestController(LibroIsbnServiceXml libroService) {
        this.libroService = libroService;
    }

    /**
     * Endpoint para obtener información de un libro utilizando su ISBN.
     *
     * @param isbn El ISBN del libro a buscar.
     * @return ResponseEntity con la información del libro si se encuentra, o un estado 404 si no se encuentra.
     */
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

