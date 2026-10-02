/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.ClienteController;
import com.mycompany.proyecto_java_crediya.Controlador.EmpleadoController;
import com.mycompany.proyecto_java_crediya.Controlador.PagoController;
import com.mycompany.proyecto_java_crediya.Controlador.PrestamoController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.EstadoPrestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Pago;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuPagos {
    
    private static Scanner scanner = new Scanner(System.in);
    
    private static PagoController pagoController = new PagoController();
    private static PrestamoController prestamoController = new PrestamoController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE PAGOS");
            System.out.println("1. Registrar pago");
            System.out.println("2. Listar pagos");
            System.out.println("3. Buscar pago");
            System.out.println("4. Actualizar pago");
            System.out.println("5. Eliminar pago");
            System.out.println("6. Volver al menu principal");
            System.out.println("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    registrarPago();
                    break;
                case 2:
                    listarPagos();
                    break;
                case 3:
                    buscarPago();
                    break;
                case 4:
                    actualizarPago();
                    break;
                case 5:
                    eliminarPago();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }           
        } while(opcion != 6);
    }
    
    
    public static void registrarPago(){
        
            System.out.println("REGISTRAR PAGO");
            
            System.out.println("ID del prestamo: ");
            int idPrestamo = scanner.nextInt();
            scanner.nextLine();
            
            Prestamo prestamo = prestamoController.buscarPrestamo(idPrestamo);
            
            if(prestamo == null){
                System.out.println("No se encontró un prestamo con ese ID");
                return;
            }
            
            System.out.println("Prestamo encontrado");
            System.out.println("Saldo pendiente: " + prestamo.getSaldoPendiente());
            
            System.out.println("Monto del pago: ");
            double monto = scanner.nextDouble();
            scanner.nextLine();
            
            try {
                
                prestamo.aplicarPago(monto);
            
                System.out.println("Fecha del pago (AAAA-MM-DD): ");
                String fechaTexto = scanner.nextLine();
                
                LocalDate fechaPago = LocalDate.parse(fechaTexto);
                
                Pago pago = new Pago(prestamo, fechaPago, monto);
                
                boolean resultado = pagoController.registrarPago(pago);
            
                if(resultado){
                    System.out.println("Pago registrado correctamente");
                    System.out.println("Nuevo saldo pendiente: " + prestamo.getSaldoPendiente());
                    System.out.println("Estado del prestamo: " + prestamo.getEstado());
                } else{
                    System.out.println("No se pudo registrar el pago");
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
    }

    public static void listarPagos(){
        
            System.out.println("LISTA DE PAGOS");
            
            List<Pago> pagos = pagoController.listarPago();
            
            if(pagos.isEmpty()){
                System.out.println("No hay pagos registrados");
                return;
            }            
            
            for (Pago pago : pagos) {
                System.out.println("ID del pago: " + pago.getId());
                System.out.println("ID del prestamo: " + pago.getPrestamo().getId());
                System.out.println("Fecha del pago: " + pago.getFecha_pago());
                System.out.println("Monto: " + pago.getMonto());
            }
    }
    
    
    public static void buscarPago(){
        
            System.out.println("BUSCAR PAGO");
            
            System.out.println("Ingrese el ID del pago: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Pago pago = pagoController.buscarPago(id);
            
            if(pago == null){
                System.out.println("No se encontro un pago con ese ID");
                return;
            }
            
            System.out.println("Pago encontrado: ");
            System.out.println("ID del pago: " + pago.getId());
            System.out.println("ID del prestamo: " + pago.getPrestamo().getId());
            System.out.println("Fecha del pago: " + pago.getFecha_pago());
            System.out.println("Monto: " + pago.getMonto());       
    }
    
    
    public static void actualizarPago(){
        
            System.out.println("ACTUALIZAR PAGO");
            
            System.out.println("Ingrese el ID del pago: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Pago pago = pagoController.buscarPago(id);
            
            if(pago == null){
                System.out.println("No se encontro un pago con ese ID");
                return;
            }
            
            System.out.println("Nuevo monto: ");
            double monto = scanner.nextDouble();
            scanner.nextLine();
            
            System.out.println("Nueva fecha (AAAA-MM-DD): ");
            String fechaTexto = scanner.nextLine();

            LocalDate fechaPago = LocalDate.parse(fechaTexto);
            
            pago.setMonto(monto);
            pago.setFecha_pago(fechaPago);
            
            boolean resultado = pagoController.actualizarPago(pago);
            
            if(resultado){
                System.out.println("Pago actulizado correctamente");
            } else{
                System.out.println("No se pudo actualizar el pago");
            }   
    }
    
    
    public static void eliminarPago(){
        
            System.out.println("ELIMINAR PAGO");
            
            System.out.println("Ingrese el ID del pago: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Pago pago = pagoController.buscarPago(id);
            
            if(pago == null){
                System.out.println("No se encontro un pago con ese ID");
                return;
            }
            
            System.out.println("¿Está seguro de eliminarlo? (Si/No): ");
            String confirmacion = scanner.nextLine();
            
            if(confirmacion.equalsIgnoreCase("Si")){
                boolean resultado = pagoController.eliminarPago(id);
            
                if(resultado){
                    System.out.println("Pago eliminado correctamente");
                } else{
                    System.out.println("No se pudo eliminar el pago");
                }
            } else{
                System.out.println("Operacion cancelada");
            }
    }
    
    
}
