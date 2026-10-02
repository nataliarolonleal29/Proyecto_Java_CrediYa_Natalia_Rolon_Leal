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
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuPrestamos {
    
    private static Scanner scanner = new Scanner(System.in);
    
    private static PrestamoController prestamoController = new PrestamoController();
    private static ClienteController clienteController = new ClienteController();
    private static EmpleadoController empleadoController = new EmpleadoController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE PRESTAMOS");
            System.out.println("1. Registrar prestamo");
            System.out.println("2. Listar prestamos");
            System.out.println("3. Buscar prestamo");
            System.out.println("4. Actualizar prestamo");
            System.out.println("5. Eliminar prestamo");
            System.out.println("6. Volver al menu principal");
            System.out.println("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    registrarPrestamo();
                    break;
                case 2:
                    listarPrestamos();
                    break;
                case 3:
                    buscarPrestamo();
                    break;
                case 4:
                    actualizarPrestamo();
                    break;
                case 5:
                    eliminarPrestamo();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }           
        } while(opcion != 6);
    }
    
    
    public static void registrarPrestamo(){
        
            System.out.println("REGISTRAR PRESTAMO");
            
            System.out.println("ID del cliente: ");
            int idCliente = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = clienteController.buscarCliente(idCliente);
            
            if(cliente == null){
                System.out.println("No se encontró un cliente con ese ID");
                return;
            }
            
            System.out.println("ID del empleado: ");
            int idEmpleado = scanner.nextInt();
            scanner.nextLine();
            
            Empleado empleado = empleadoController.buscarEmpleado(idEmpleado);
            
            if(empleado == null){
                System.out.println("No se encontró un empleado con ese ID");
                return;
            }
            
            System.out.println("Monto del prestamo: ");
            double monto = scanner.nextDouble();
            
            System.out.println("Interes (%): ");
            double interes = scanner.nextDouble();
            
            System.out.println("Numero de cuotas: ");
            int cuotas = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Fecha de inicio (AAAA-MM-DD): ");
            String fechaTexto = scanner.nextLine();
            
            LocalDate fechaInicio = LocalDate.parse(fechaTexto);
            
            Prestamo prestamo = new Prestamo(cliente, empleado, monto, interes, cuotas, fechaInicio, EstadoPrestamo.PENDIENTE);
            
            boolean resultado = prestamoController.registrarPrestamo(prestamo);
            
            if(resultado){
                System.out.println("Prestamo registrado correctamente");
                System.out.println("Monto total: " + prestamo.getMontoTotal());
                System.out.println("Valor de cuota: " + prestamo.getValorCuota());
                System.out.println("Saldo pendiente: " + prestamo.getSaldoPendiente());
            } else{
                System.out.println("No se pudo registrar el prestamo");
            }
        
    }

    public static void listarPrestamos(){
        
            System.out.println("LISTA DE PRESTAMOS");
            
            List<Prestamo> prestamos = prestamoController.listarPrestamo();
            
            if(prestamos.isEmpty()){
                System.out.println("No hay prestamos registrados");
                return;
            }            
            
            for (Prestamo prestamo : prestamos) {
                System.out.println("ID: " + prestamo.getId());
                System.out.println("Cliente ID: " + prestamo.getCliente().getId());
                System.out.println("Empleado ID: " + prestamo.getEmpleado().getId());
                System.out.println("Monto: " + prestamo.getMonto());
                System.out.println("Interes: " + prestamo.getInteres() + "%");
                System.out.println("Cuotas: " + prestamo.getCuotas());
                System.out.println("Fecha de inicio: " + prestamo.getFecha_inicio());
                System.out.println("Estado: " + prestamo.getEstado());
                System.out.println("Monto total: " + prestamo.getMontoTotal());
                System.out.println("Valor cuota: " + prestamo.getValorCuota());
                System.out.println("Saldo pendiente: " + prestamo.getSaldoPendiente());
            }
    }
    
    
    public static void buscarPrestamo(){
        
            System.out.println("BUSCAR PRESTAMO");
            
            System.out.println("Ingrese el ID del prestamo: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Prestamo prestamo = prestamoController.buscarPrestamo(id);
            
            if(prestamo == null){
                System.out.println("No se encontro un prestamo con ese ID");
                return;
            }
            
            System.out.println("Prestamo encontrado: ");
            System.out.println("ID: " + prestamo.getId());
            System.out.println("Cliente ID: " + prestamo.getCliente().getId());
            System.out.println("Empleado ID: " + prestamo.getEmpleado().getId());
            System.out.println("Monto: " + prestamo.getMonto());
            System.out.println("Interes: " + prestamo.getInteres() + "%");
            System.out.println("Cuotas: " + prestamo.getCuotas());
            System.out.println("Fecha de inicio: " + prestamo.getFecha_inicio());
            System.out.println("Estado: " + prestamo.getEstado());
            System.out.println("Monto total: " + prestamo.getMontoTotal());
            System.out.println("Valor cuota: " + prestamo.getValorCuota());
            System.out.println("Saldo pendiente: " + prestamo.getSaldoPendiente());
            
    }
    
    
    public static void actualizarPrestamo(){
        
            System.out.println("ACTUALIZAR PRESTAMO");
            
            System.out.println("Ingrese el ID del prestamo: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Prestamo prestamo = prestamoController.buscarPrestamo(id);
            
            if(prestamo == null){
                System.out.println("No se encontro un prestamo con ese ID");
                return;
            }
            
            System.out.println("Nuevo monto: ");
            double monto = scanner.nextDouble();
            
            System.out.println("Nuevo interes (%): ");
            double interes = scanner.nextDouble();
            
            System.out.println("Nuevas cuotas: ");
            int cuotas = scanner.nextInt();
            scanner.nextLine();
            
            System.out.println("Fecha de inicio (AAAA-MM-DD): ");
            String fechaTexto = scanner.nextLine();
            
            LocalDate fechaInicio = LocalDate.parse(fechaTexto);
            
            prestamo.setMonto(monto);
            prestamo.setInteres(interes);
            prestamo.setCuotas(cuotas);
            prestamo.setFecha_inicio(fechaInicio);
            
            boolean resultado = prestamoController.actualizarPrestamo(prestamo);
            
            if(resultado){
                System.out.println("Prestamo actulizado correctamente");
            } else{
                System.out.println("No se pudo actualizar el prestamo");
            }   
    }
    
    
    public static void eliminarPrestamo(){
        
            System.out.println("ELIMINAR PRESTAMO");
            
            System.out.println("Ingrese el ID del prestamo: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Prestamo prestamo = prestamoController.buscarPrestamo(id);
            
            if(prestamo == null){
                System.out.println("No se encontro un prestamo con ese ID");
                return;
            }
            
            System.out.println("¿Está seguro de eliminarlo? (Si/No): ");
            String confirmacion = scanner.nextLine();
            
            if(confirmacion.equalsIgnoreCase("Si")){
                boolean resultado = prestamoController.eliminarPrestamo(id);
            
                if(resultado){
                    System.out.println("Prestamo eliminado correctamente");
                } else{
                    System.out.println("No se pudo eliminar el prestamo");
                }
            } else{
                System.out.println("Operacion cancelada");
            }
    }
    
}
