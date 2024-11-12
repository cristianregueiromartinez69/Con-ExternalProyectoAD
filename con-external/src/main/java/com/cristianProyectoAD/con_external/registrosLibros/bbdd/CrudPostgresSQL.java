package com.cristianProyectoAD.con_external.registrosLibros.bbdd;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudPostgresSQL {

    private Connection connection;
    private ResultSet resultSet;

    public List<String> getAllIsbnLibros(){
        String consulta = "select isbn from libros";
        List<String> isbnLibros = new ArrayList<>();
        try{
            connection = EstablecerConexionPostgresSQL.conectar();
            Statement statement = connection.createStatement();

            resultSet = statement.executeQuery(consulta);

            while(resultSet.next()){
                isbnLibros.add(resultSet.getString("isbn"));
            }
        } catch (SQLException e) {
            System.out.println("Ups, no se pudo conectar a la base de datos");
        }
        return isbnLibros;
    }

}
