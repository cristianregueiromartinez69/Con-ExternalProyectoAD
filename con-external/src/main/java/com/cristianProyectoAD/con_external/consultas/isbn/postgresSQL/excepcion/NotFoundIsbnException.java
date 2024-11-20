package com.cristianProyectoAD.con_external.consultas.isbn.postgresSQL.excepcion;

public class NotFoundIsbnException extends RuntimeException {
    public NotFoundIsbnException(String message) {
        super(message);
    }
}
