package com.cristianProyectoAD.con_external.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LibroDto {

    private String isbn;
    private String nombre;
    private String autor;
    private String fechaLectura;
    private String fechaRegistro;

    public LibroDto(String isbn, String nombre, String autor, String fechaLectura, String fechaRegistro) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public LibroDto() {
    }


}
