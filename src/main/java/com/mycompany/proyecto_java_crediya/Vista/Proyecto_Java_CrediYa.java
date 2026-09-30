/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Proyecto_Java_CrediYa {

    public static void main(String[] args) {
        
        // Prueba conexion SQL
        
        String url = "jdbc:mysql://localhost:3306/crediya_db";
        String usuario = "root";
        String contrasena = "Natalita29";

        try {
            Connection connection = ConexionDB.MySQLConnection();
            if(connection != null){
                System.out.println("CONEXION EXITOSA");
                System.out.println("Controlador: " + connection.getMetaData().getDriverName()
                        + " " + connection.getMetaData().getDriverVersion());
                System.out.println("Base de datos: " + connection.getCatalog());
                connection.close();
            } else{
                System.out.println("NO SE PUDO CONECTAR");
            }
            
        } catch (SQLException e) {
            System.out.println("NO SE PUDO CONECTAR: " + e.getMessage());
        }
    }
}
