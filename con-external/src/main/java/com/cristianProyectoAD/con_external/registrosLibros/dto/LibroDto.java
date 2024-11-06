package com.cristianProyectoAD.con_external.registrosLibros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LibroDto {

    @NotBlank
    private String isbn;
    @NotBlank
    private String nombre;
    @NotBlank
    private String autor;
    @NotBlank
    private LocalDate fechaLectura;
    @NotBlank
    private LocalDate fechaRegistro;

    public LibroDto(String isbn, String nombre, String autor, LocalDate fechaLectura, LocalDate fechaRegistro) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.autor = autor;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public LibroDto() {
    }


}
