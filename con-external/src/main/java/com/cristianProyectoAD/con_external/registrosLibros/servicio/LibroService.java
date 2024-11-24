
package com.cristianProyectoAD.con_external.registrosLibros.servicio;

import com.cristianProyectoAD.con_external.registrosLibros.dto.LibroDto;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.AutorException;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.DuplicateIsbnException;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.ISBNExcepction;
import com.cristianProyectoAD.con_external.registrosLibros.excepcion.NombreException;
import com.cristianProyectoAD.con_external.servicio_comunicacion.PrdRexClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase servicio de registro de libros
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroService {


    //atributo con el servicio a enviar los datos
    private final PrdRexClient prdRexClient;


    /**
     * Constructor de la clase
     * @param prdRexClient el cliente al que le vamos a enviar los datos
     */
    public LibroService(PrdRexClient prdRexClient) {
        this.prdRexClient = prdRexClient;
    }

    /**
     * Metodo para registrar un libro y mandarlo a otro microservicio
     * @param libro el objeto libro
     * @return el registro
     */
    public ResponseEntity<String> registrarLibro(LibroDto libro) throws ISBNExcepction, AutorException, NombreException {
        if(!authenticationIsbn(libro.getIsbn())) {
            throw new ISBNExcepction("ISBN no válido");
        } else if (!authenticationAutorLibro(libro.getAutor())) {
            throw new AutorException("Autor incorrecto");
        } else if (!authenticationBookName(libro.getNombre())) {
            throw new NombreException("Nombre  de libro incorrecto");
        }
        return prdRexClient.registrarLibro(libro);
    }

    /**
     * función de autenticación del isbn de los libros
     * @param isbn el isbn a introducir
     * @return true o false si se cumplen las condiciones
     */
    public boolean authenticationIsbn(String isbn){
        return checkStartIsbn(isbn) && checkIsbnEndGuion(isbn) && checkIsbnHasMoreThan2TimeGuion(isbn) &&
                checkNoGuionesTogether(isbn) && checkIsbnHasOnlyNumbersAndGuion(isbn);
    }


    /**
     * funcion para comprobar si el isbn empieza por los prefijos correctos
     *
     * @param isbn el isbn proporcionado
     * @return true o false dependiendo del isbn que introduzcas
     */
    public boolean checkStartIsbn(String isbn) {

        //array con los prefijos correctos del isbn
        String[] prefixes = {"978-", "979-"};

        //bucle para comprobar la coincidencia
        for (String prefix : prefixes) {
            if (isbn.startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }

    /**
     * funcion que comprueba si el isbn acaba en guion
     *
     * @param isbn el isbn
     * @return true o false dependiendo de si acaba o no en guion
     */
    public boolean checkIsbnEndGuion(String isbn) {
        return !isbn.endsWith("-");
    }

    /**
     * Metodo para comprobar si un isbn tiene 2 guiones juntos
     *
     * @param isbn el isbn
     * @return true o false dependiendo del guion introducido
     */
    public boolean checkNoGuionesTogether(String isbn) {

        //array con las letras del isbn
        char[] chars = isbn.toCharArray();
        //el guion a encontrar
        char guion = '-';
        //contador de guiones
        int contador = 0;

        /*
         * 1. recorremos el bucle
         * 2. si encuentra un guion, lo aumentamos a +1
         * 3. si el contador esta en 1 y la siguiente letra del isbn es un guion, devuelve false
         */
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == guion) {
                contador++;
            }
            if (contador == 1 && chars[i + 1] == guion) {
                return false;
            }
            contador = 0;
        }
        return true;
    }

    /**
     * funcion para comprobar que el isbn tiene más de 1 guión
     *
     * @param isbn el isbn proporcioando
     * @return true o false dependiendo del isbn que introdujeras
     */
    public boolean checkIsbnHasMoreThan2TimeGuion(String isbn) {

        //variable con el guion
        char guion = '-';
        //array con las letras del isbn
        char[] chars = isbn.toCharArray();

        //contador para las veces que se repite el guion
        int contador = 0;

        //bucle para recorrer el array, si encuentra el guion, se incrementa el contador
        for (char c : chars) {
            if (c == guion)
                contador++;
        }
        //si el contador es igual o mayor que 2, es válido
        return contador >= 3;
    }

    /**
     * funcion para comprobar que todos los caraceteres introducidos en el isbn son numeros o guiones
     *
     * @param isbn el isbn proporcionado
     * @return true o false dependiendo del caracter a encontrar
     */
    public boolean checkIsbnHasOnlyNumbersAndGuion(String isbn) {

        //creamos un array con las letras del isbn
        char[] chars = isbn.toCharArray();

        //recorremos el array
        for (char c : chars) {
            //si no es un numero y no es un guion, devuelve false
            if (!Character.isDigit(c) && c != '-') {
                return false;
            }
        }


        return true;

    }

    //--------------------------------Metodos autenticacion autor libro-----------------------------------//

    /**
     * Metodo para comprobar si un el nombre de un autor tiene 2 o más letras (existen nombres con 2 letras, por ejemplo, Ed)
     *
     * @param autor el nombre que le vamos a pasar
     * @return True o False en caso de tener menos o mas letras
     */
    public boolean lengthAutorName(String autor) {

        return autor.length() >= 2;
    }

    /**
     * funcion para comprobar que no se introducen numeros en el nombre del autor de un libro
     * @param autor el nombre a introducir
     * @return True o False dependiendo del nombre que introdujeras
     */
    public boolean isDigitAutor(String autor) {

        //se realiza un array de chars con los numeros y un array de chars con el string
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chars = autor.toCharArray();
        //con un bucle recorremos el array de letras y con otro anidado el de numeros
        for (char letra : chars) {

            //si alguna letra coincide con un numero, el metodo devuelve false
            for(char numero:numeros){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    /**
     * funcion para comprobar que no se introducen carácteres extraños en los nombres de autores
     * @param autor el nombre que vas a introducir
     * @return True o False dependiendo del nombre introducido
     */
    public boolean strangeCharactersAutor(String autor){
        //mismo procedimiento que en la funcion anterior pero con caracteres extraños
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
                ,'¡','º','ª','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};
        char[] chars = autor.toCharArray();
        for (char letra : chars) {

            for(char numero:caracteres){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    /**
     * Metodo global que comprueba la autenticacion del nombre del autor
     * @param autor el autor del libro
     * @return true o false dependiendo de lo que introduzcas
     */
    public boolean authenticationAutorLibro(String autor){
        return lengthAutorName(autor) && isDigitAutor(autor) && strangeCharactersAutor(autor);
    }

    //--------------------------------Metodos autenticacion nombre del libro-----------------------------------//

    /**
     * Metodo para comprobar si un el nombre del libro tiene 2 o más letras (existen nombres de libros con 2 letras, por ejemplo, IT)
     *
     * @param name el nombre que le vamos a pasar
     * @return True o False en caso de tener menos o mas letras
     */
    public boolean lengthLibroName(String name) {

        return name.length() >= 2;
    }
    /**
     * funcion para comprobar que no se introducen carácteres extraños en los nombres de los libros
     * @param name el nombre que vas a introducir
     * @return True o False dependiendo del nombre introducido
     */
    public boolean strangeCharactersLibroName(String name){
        //mismo procedimiento que en la funcion anterior pero con caracteres extraños
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
                ,'¡','º','ª','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};
        char[] chars = name.toCharArray();
        for (char letra : chars) {

            for(char numero:caracteres){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    /**
     * funcion que comprueba si el titulo de un libro tiene al menos 1 letra
     * @param name el nombre del libro
     * @return true o false dependiendo de lo que escribas
     */
    public boolean checkNotLettersInBookName(String name){

        //array de letras con el nombre del libro
        char [] chars = name.toCharArray();
        //bucle que recorre el array de letras del libro
        for(char c: chars){
            //si hay coincidencia, devuelve true
            if(Character.isLetter(c)){
                return true;
            }
        }
        return false;
    }

    /**
     * función global para comprobar si el nombre del libro cumple todos los estándares
     * @param name el nombre del libro
     * @return true o false dependiendo del nombre introducido
     */
    public boolean authenticationBookName(String name){
        return lengthLibroName(name) && strangeCharactersLibroName(name) && checkNotLettersInBookName(name);
    }

    public boolean authenticacionDuplicateIsbn(List<String> isbnList ,String isbn){
        for(String isbnCheck : isbnList){
            if(isbnCheck.equals(isbn)){
                return false;
            }
        }
        return true;
    }


}
