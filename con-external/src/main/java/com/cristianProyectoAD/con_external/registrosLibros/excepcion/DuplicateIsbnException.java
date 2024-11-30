package com.cristianProyectoAD.con_external.registrosLibros.excepcion;

/**
 * Excepción personalizada para manejar casos en los que un ISBN duplicado se encuentra en el sistema.
 */
public class DuplicateIsbnException extends RuntimeException {

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param message el mensaje de error que se desea asociar a la excepción
     */
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
