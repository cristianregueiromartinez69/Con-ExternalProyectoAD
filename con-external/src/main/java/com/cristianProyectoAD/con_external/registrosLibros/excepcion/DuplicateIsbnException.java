package com.cristianProyectoAD.con_external.registrosLibros.excepcion;

public class DuplicateIsbnException extends RuntimeException {
    public DuplicateIsbnException(String message) {
        super(message);
    }
}
