package com.cristianProyectoAD.con_external.registrosLibros.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


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

    public @NotBlank String getIsbn() {
        return isbn;
    }

    public void setIsbn(@NotBlank String isbn) {
        this.isbn = isbn;
    }

    public @NotBlank LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(@NotBlank LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank String getAutor() {
        return autor;
    }

    public void setAutor(@NotBlank String autor) {
        this.autor = autor;
    }

    public @NotBlank LocalDate getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(@NotBlank LocalDate fechaLectura) {
        this.fechaLectura = fechaLectura;
    }
}
