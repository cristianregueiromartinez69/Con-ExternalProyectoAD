package com.cristianProyectoAD.con_external.registrosLibros.excepcion;

/**
 * Excepción personalizada para manejar errores relacionados con un ISBN inválido.
 */
public class ISBNExcepction extends Exception {

    /**
     * Constructor que inicializa la excepción con un mensaje específico.
     *
     * @param message el mensaje de error que se desea asociar a la excepción
     */
    public ISBNExcepction(String message) {
        super(message);
    }
}
