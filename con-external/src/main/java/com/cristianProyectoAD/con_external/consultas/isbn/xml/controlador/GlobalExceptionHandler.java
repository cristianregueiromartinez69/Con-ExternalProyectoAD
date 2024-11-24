package com.cristianProyectoAD.con_external.consultas.isbn.xml.controlador;

import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Controlador global para el manejo de excepciones en la aplicación.
 * Proporciona respuestas personalizadas para excepciones específicas y generales.
 * @author cristian
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * Maneja las excepciones FeignException.NotFound.
     *
     * @param ex La excepción FeignException.NotFound capturada.
     * @return ResponseEntity con un mensaje indicando que el libro no existe o se escribió incorrectamente.
     */
    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<String> handleFeignNotFound(FeignException.NotFound ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("El libro no existe o lo escribio mal");
    }

    /**
     * Maneja excepciones generales que no estén cubiertas por otros métodos.
     *
     * @param ex La excepción general capturada.
     * @return ResponseEntity con un mensaje de error interno y detalles del mensaje de la excepción.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Error, Los datos no coinciden con ningun libro: ");
    }
}
