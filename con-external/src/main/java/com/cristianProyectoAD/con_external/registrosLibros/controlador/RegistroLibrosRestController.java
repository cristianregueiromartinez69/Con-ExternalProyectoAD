
package com.cristianProyectoAD.con_external.registrosLibros.controlador;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.AutorException;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.DuplicateIsbnException;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.ISBNExcepction;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.NombreException;
import com.cristianProyectoAD.con_external.registrosLibros.servicio.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para enviar la información de los libros al prd-rex
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/bookhub/libros")
public class RegistroLibrosRestController {

    //atributo del servicio
    private final LibroService libroService;

    /**
     * Constructor de la clase
     *
     * @param libroService el servicio de libros
     */
    public RegistroLibrosRestController(LibroService libroService) {
        this.libroService = libroService;
    }

    /**
     * Metodo para mandar los libros a otro microservicio
     *
     * @param libroDto el objeto libros
     * @return si se guardó o no se guardó
     */
    @PostMapping("/registro")
    public ResponseEntity<String> registroControllerLibros(@RequestBody LibroDto libroDto) {
        try {
            return libroService.registrarLibro(libroDto);
        } catch (ISBNExcepction e) {
            return ResponseEntity.badRequest().body("Formato isbn incorrecto, debe de tener entre 3 o 4 guiones, no ir juntos los guiones, empezar por 978 o 979, no acabar en guion el isbn, llevar solo numeros o guiones");
        } catch (AutorException e) {
            return ResponseEntity.badRequest().body("Nombre incorrecto, nada de numeros, caracteres raros o escribir una sola letra de nombre");
        } catch (NombreException e) {
            return ResponseEntity.badRequest().body("Formato de nombre de libro erróneo, nada de numeros, carácteres especiales y longitud mayor a 1 letra");
        }catch(DuplicateIsbnException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}