package com.cristianProyectoAD.con_external.registrosLibros.bbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase para establecer la conexion a la base de datos
 * @author cristian
 * @version 1.0
 */
public class EstablecerConexionPostgresSQL {

    /**
     * Metodo para establecer una conexion con la base de datos
     * @return el objeto de tipo Conexion
     */
    public static Connection conectar(){



        /**
         * Aqui tenemos todas las especificaciones que requiere nuestra conexion
         * 1. driver
         * 2. el host
         * 3. el puerto, por defecto es el 5432
         * el sid
         * el usuario
         * La contraseña
         * juntamos todo en la url
         */
        String driver = "jdbc:postgresql:";
        String host = "//140.238.65.12:";
        String porto = "5432";
        String sid = "bookmanage";
        String usuario = "cristian";
        String password = "cristian";
        String url = driver + host + porto + "/" + sid;
        Connection conn = null;

        try{
            //usamos el objeto Connection para establecer la conexion
            System.out.println("conexion exitosa");
            conn = DriverManager.getConnection(url,usuario,password);

        }catch(SQLException e){
            System.out.println("Ups, ha ocurrido un error a la hora de conectarse a la base");
        }



        return conn;

    }
}

