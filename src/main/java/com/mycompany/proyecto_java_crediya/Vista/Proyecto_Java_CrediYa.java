/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_java_crediya.Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Proyecto_Java_CrediYa {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/DatabaseSQL";
        String usuario = "root";
        String contrasena = "Natalita29";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contrasena);
            System.out.println("CONEXION EXITOSA");
            System.out.println("Controlador: " + connection.getMetaData().getDriverName()
                    + " " + connection.getMetaData().getDriverVersion());
            System.out.println("Base de datos: " + connection.getCatalog());
            connection.close();
        } catch (SQLException e) {
            System.out.println("NO SE PUDO CONECTAR: " + e.getMessage());
        }
    }
}
