/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ClienteDAO;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ConexionDB;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.EmpleadoDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Proyecto_Java_CrediYa {

    public static void main(String[] args) {
        
        // PRUEBAS CONEXIÓN SQL
        
        /*String url = "jdbc:mysql://localhost:3306/crediya_db";
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
        }*/
        
        // Prueba de que las clases quedan bien conectadas y se pueden actualizar en la base de datos
        
        /*Empleado empleado = new Empleado("Aura María Fuentes", "1023456789", "qtalmija@gmail.com", "Asesor", 2500000);
        
        EmpleadoDAO dao = new EmpleadoDAO();
        
        boolean resultado = dao.guardarEmpleado(empleado);
        
        if(resultado){
            System.out.println("Empleado guardado correctamente");
        } else{
            System.out.println("No se pudo guardar el empleado");
        }*/
        
        // Prueba de que las clases quedan bien conectadas y se pueden actualizar en la base de datos
        
        /*Cliente cliente = new Cliente("Patricia Fernández", "1095224689", "patsypatdesgraciado@gmail.com", "3164567892");
        
        ClienteDAO dao = new ClienteDAO();
        
        boolean resultado = dao.guardarCliente(cliente);
        
        if(resultado){
            System.out.println("Cliente guardado correctamente");
        } else{
            System.out.println("No se pudo guardar el cliente");
        }*/
        
        
        // MENÚ PRINCIPAL
        Scanner scanner = new Scanner(System.in);
        
        int opcion;
        
        do{
            System.out.println("CREDIYA");
            System.out.println("Menu principal");
            System.out.println("1. Gestionar empleados");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Gestionar prestamos");
            System.out.println("4. Gestionar pagos");
            System.out.println("5. Salir");
            System.out.println("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            
            switch(opcion){
                case 1:
                    System.out.println("Menu de empleados seleccionado");
                    MenuEmpleados.mostrarMenu();
                    break;
                case 2:
                    System.out.println("Menu de clientes seleccionado");
                    break;
                case 3:
                    System.out.println("Menu de prestamos seleccionado");
                    break;
                case 4:
                    System.out.println("Menu de pagos seleccionado");
                    break;
                case 5:
                    System.out.println("Gracias por utilizar CrediYa. Vuelve pronto.");
                    break;
                default:
                    System.out.println("Opcion no válida");
            }           
        } while(opcion != 5);
        scanner.close();
    }
}
