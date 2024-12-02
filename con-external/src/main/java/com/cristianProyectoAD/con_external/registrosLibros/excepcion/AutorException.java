package com.cristianProyectoAD.con_external.registrosLibros.excepcion;

/**
 * Excepción personalizada para manejar errores relacionados con el autor de un libro.
 */
public class AutorException extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param message el mensaje de error que se desea asociar a la excepción
     */
    public AutorException(String message) {
        super(message);
    }
}
