package com.cristianProyectoAD.con_external;

import com.cristianProyectoAD.con_external.registrosLibros.servicio.LibroService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TestLibroService {

    @Autowired
    private LibroService libroServicio;

    @Test
    void checkIfAIsbnStartsWithCorrectPrefixesTrue(){
        boolean prefixe = libroServicio.checkStartIsbn("979-");
        Assertions.assertTrue(prefixe);
    }
    @Test
    void checkIfAIsbnStartsWithCorrectPrefixesFalse(){
        boolean prefixe = libroServicio.checkStartIsbn("971-");
        Assertions.assertFalse(prefixe);
    }

    @Test
    void checkIfAIsbnWEndsWithGuionTrue(){
        boolean isbn = libroServicio.checkIsbnEndGuion("978-123-987-00");
        Assertions.assertTrue(isbn);
    }
    @Test
    void checkIfAIsbnWEndsWithGuionFalse(){
        boolean isbn = libroServicio.checkIsbnEndGuion("978-123-987-");
        Assertions.assertFalse(isbn);
    }

    @Test
    void checkIfAIsbnHasMoreThan2TimeAGuionTrue(){
        boolean guion = libroServicio.checkIsbnHasMoreThan2TimeGuion("978-123-90-21");
        Assertions.assertTrue(guion);
    }
    @Test
    void checkIfAIsbnHasMoreThan2TimeAGuionFalse(){
        boolean guion = libroServicio.checkIsbnHasMoreThan2TimeGuion("978-12");
        Assertions.assertFalse(guion);
    }

    @Test
    void checkIfAIsbnHasOnlyNumbersAndGionesTrue(){
        boolean isbn = libroServicio.checkIsbnHasOnlyNumbersAndGuion("978-123-123-00");
        Assertions.assertTrue(isbn);
    }

    @Test
    void checkIfAIsbnHasOnlyNumbersAndGionesFalse(){
        boolean isbn = libroServicio.checkIsbnHasOnlyNumbersAndGuion("9frfrf78-123-12kj-0");
        Assertions.assertFalse(isbn);
    }

    @Test
    void checkIfAIsbnHasGuionesTogetherTrue(){
        boolean isbn = libroServicio.checkNoGuionesTogether("987-123-123-123");
        Assertions.assertTrue(isbn);

    }
    @Test
    void checkIfAIsbnHasGuionesTogetherFalse(){
        boolean isbn = libroServicio.checkNoGuionesTogether("987--123-123-123");
        Assertions.assertFalse(isbn);
    }

    @Test
    void checkAuthenticacionIsbnTrue(){
        boolean isbn = libroServicio.authenticationIsbn("978-123-123-00");
        Assertions.assertTrue(isbn);
    }
    @Test
    void checkAuthenticacionIsbnFalse(){
        boolean isbn = libroServicio.authenticationIsbn("978-123-1200--23");
        Assertions.assertFalse(isbn);
    }

    @Test
    void checkLengthAutorTrueComprobation() {

        boolean length = libroServicio.lengthAutorName("carlos");

        Assertions.assertTrue(length);

    }
    @Test
    void checkLengthAutorFalseComprobation() {

        boolean length = libroServicio.lengthAutorName("a");

        Assertions.assertFalse(length);

    }

    @Test
    void CheckIfANameOfAutorHasNumbersTrue(){
        boolean number = libroServicio.isDigitAutor("Javier mancillo rodriguez");
        Assertions.assertTrue(number);
    }

    @Test
    void CheckIfANameOfAutorHasNumbersFalse(){
        boolean number = libroServicio.isDigitAutor("J123avier mancillo rodriguez");
        Assertions.assertFalse(number);
    }

    @Test
    void checkIfANameOfAutorHasStrangerCharactersTrue(){
        boolean thing = libroServicio.strangeCharactersAutor("Camión");
        Assertions.assertTrue(thing);
    }
    @Test
    void checkIfANameOfAutorHasStrangerCharactersFalse(){
        boolean thing = libroServicio.strangeCharactersAutor("Pepe de los %monte´s");
        Assertions.assertFalse(thing);
    }
    @Test
    void checkAuthenticacionAutorNameTrue(){
        boolean autor = libroServicio.authenticationAutorLibro("Don Enrique de los puentes");
        Assertions.assertTrue(autor);
    }
    @Test
    void checkAuthenticacionAutorNameFalse(){
        boolean autor = libroServicio.authenticationAutorLibro("Don Enrique d//e los puentes");
        Assertions.assertFalse(autor);
    }

    @Test
    void checkLengthBookNameTrueComprobation() {

        boolean length = libroServicio.lengthLibroName("Serpientes de cascabel");

        Assertions.assertTrue(length);

    }
    @Test
    void checkLengthBookNameFalseComprobation() {

        boolean length = libroServicio.lengthLibroName("a");

        Assertions.assertFalse(length);

    }
    @Test
    void checkIfANameOfBookHasStrangerCharactersTrue(){
        boolean thing = libroServicio.strangeCharactersAutor("serpientes de cascabel");
        Assertions.assertTrue(thing);
    }
    @Test
    void checkIfANameOfBookHasStrangerCharactersFalse(){
        boolean thing = libroServicio.strangeCharactersAutor("serpientes de cascabe&&l");
        Assertions.assertFalse(thing);
    }

    @Test
    void checkIfABookNameHasAlmost1LetterTrue(){
        boolean name = libroServicio.checkNotLettersInBookName("101 dalmatas");
        Assertions.assertTrue(name);
    }
    @Test
    void checkIfABookNameHasAlmost1LetterFalse(){
        boolean name = libroServicio.checkNotLettersInBookName("101");
        Assertions.assertFalse(name);
    }

    @Test
    void checkAuthenticationBookNameTrue(){
        boolean name = libroServicio.authenticationBookName("Los clérigos del monte");
        Assertions.assertTrue(name);
    }
    @Test
    void checkAuthenticationBookNameFalse(){
        boolean name = libroServicio.authenticationBookName("Los clérigos del// monte");
        Assertions.assertFalse(name);
    }

    @Test
    public void testAuthenticacionDuplicateIsbnTrue() {


        List<String> isbnList = new ArrayList<>();
        isbnList.add("978-1234567890");
        isbnList.add("979-9876543210");
        isbnList.add("978-1111111111");


        String isbnUnico = "978-2222222222";
        Assertions.assertTrue(libroServicio.authenticacionDuplicateIsbn(isbnList, isbnUnico),
                "El método debería devolver true para un ISBN único.");
    }

    @Test
    public void testAuthenticacionDuplicateIsbnFalse() {


        List<String> isbnList = new ArrayList<>();
        isbnList.add("978-1234567890");
        isbnList.add("979-9876543210");
        isbnList.add("978-1111111111");

        String isbnDuplicado = "978-1234567890";
        Assertions.assertFalse(libroServicio.authenticacionDuplicateIsbn(isbnList, isbnDuplicado),
                "El método debería devolver false para un ISBN duplicado.");


    }


}
