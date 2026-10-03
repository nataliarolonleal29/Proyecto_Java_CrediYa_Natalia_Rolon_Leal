/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.ClienteController;
import com.mycompany.proyecto_java_crediya.Controlador.EmpleadoController;
import com.mycompany.proyecto_java_crediya.Controlador.PrestamoController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.EstadoPrestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import com.mycompany.proyecto_java_crediya.Util.ValidadorUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuPrestamos {
    
    private static final PrestamoController prestamoController = new PrestamoController();
    private static final ClienteController clienteController = new ClienteController();
    private static final EmpleadoController empleadoController = new EmpleadoController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE PRESTAMOS");
            System.out.println("1. Registrar prestamo");
            System.out.println("2. Listar prestamos");
            System.out.println("3. Buscar prestamo");
            System.out.println("4. Actualizar prestamo");
            System.out.println("5. Eliminar prestamo");
            System.out.println("6. Respaldar en archivo prestamos.txt");
            System.out.println("7. Volver al menu principal");
            
            opcion = ValidadorUtil.leerEntero("Seleccione una opcion: ");
            
            switch(opcion){
                case 1:
                    registrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    actualizar();
                    break;
                case 5:
                    eliminar();
                    break;
                case 6:
                    respaldar();
                    break;
                case 7:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }           
        } while(opcion != 7);
    }
    
    
    private static void registrar(){
        
            System.out.println("REGISTRAR PRESTAMO");
            
            int idCliente = ValidadorUtil.leerEntero("ID del cliente: ");
            
            Cliente cliente = clienteController.buscarCliente(idCliente);
            
            if(cliente == null){
                System.out.println("Error: No existe un cliente con el ID " + idCliente);
                return;
            }
            
            int idEmpleado = ValidadorUtil.leerEntero("ID del empleado: ");
            
            Empleado empleado = empleadoController.buscarEmpleado(idEmpleado);
            
            if(empleado == null){
                System.out.println("Error: No existe un empleado con el ID " + idEmpleado);
                return;
            }
            
            double monto = ValidadorUtil.leerDouble("Monto del prestamo: $");
            double interes = ValidadorUtil.leerDouble("Tasa de interes (%): ");
            int cuotas = ValidadorUtil.leerEntero("Numero de cuotas: ");
            LocalDate fechaInicio = ValidadorUtil.leerFecha("Fecha de inicio: ");
            
            Prestamo p = new Prestamo(cliente, empleado, monto, interes, cuotas, fechaInicio, EstadoPrestamo.PENDIENTE);
            
            if(prestamoController.registrarPrestamo(p)){
                System.out.println("Prestamo registrado correctamente");
                System.out.println("Total a pagar (con interes): $" + p.getMontoTotal());
                System.out.println("Valor de cuota: " + p.getValorCuota());
                System.out.println("Saldo pendiente: " + p.getSaldoPendiente());
            } else{
                System.out.println("No se pudo registrar el prestamo");
            }
        
    }

    private static void listar(){
        
            System.out.println("LISTA DE PRESTAMOS");
            
            List<Prestamo> lista = prestamoController.listarPrestamos();
            
            if(lista.isEmpty()){
                System.out.println("No hay prestamos registrados");
            } else{
                lista.forEach(System.out::println);
            }
    }
    
    
    private static void buscar(){
        
            System.out.println("BUSCAR PRESTAMO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del prestamo: ");
            
            Prestamo p = prestamoController.buscarPrestamo(id);
            
            if(p != null){
                System.out.println("Prestamo encontrado");
            } else{
                System.out.println("Prestamo no encontrado");
            }            
    }
    
    
    private static void actualizar(){
        
            System.out.println("ACTUALIZAR PRESTAMO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del prestamo: ");
            
            Prestamo p = prestamoController.buscarPrestamo(id);
            
            if(p == null){
                System.out.println("No se encontro un prestamo con ese ID");
                return;
            }
            
            p.setMonto(ValidadorUtil.leerDouble("Nuevo monto: $"));
            p.setInteres(ValidadorUtil.leerDouble("Nuevo interes (%): "));
            p.setCuotas(ValidadorUtil.leerEntero("Nuevas cuotas: "));
            p.setFecha_inicio(ValidadorUtil.leerFecha("Nueva fecha de inicio: "));
            
            if(prestamoController.actualizarPrestamo(p)){
                System.out.println("Prestamo actualizado con exito");
            }
    }
    
    
    private static void eliminar(){
        
            System.out.println("ELIMINAR PRESTAMO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del prestamo: ");
            
            String confirmacion = ValidadorUtil.leerTexto("¿Esta seguro? (Si/No)");
            
            if(confirmacion.equalsIgnoreCase("Si")){
                if(prestamoController.eliminarPrestamo(id)){
                    System.out.println("Prestamo eliminado correctamente");
                }
            } else{
                System.out.println("Operacion cancelada");  
            }
    }
    
    private static void respaldar(){
        if(prestamoController.respaldarEnArchivo()){
            System.out.println("Prestamos guardados en 'prestamos.txt'");
        }
    }
    
}
