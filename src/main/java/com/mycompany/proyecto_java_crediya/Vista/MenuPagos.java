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
import com.mycompany.proyecto_java_crediya.Util.ValidadorUtil;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuPagos {
    
    private static final PagoController pagoController = new PagoController();
    private static final PrestamoController prestamoController = new PrestamoController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE PAGOS");
            System.out.println("1. Registrar pago / abono");
            System.out.println("2. Listar historial de pagos");
            System.out.println("3. Buscar pago por ID");
            System.out.println("4. Respaldar en archivo pagos.txt");
            System.out.println("5. Volver al menu principal");

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
                    respaldar();
                    break;
                case 5:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }           
        } while(opcion != 7);
    }
    
    
    private static void registrar(){
        
            System.out.println("REGISTRAR PAGO");
            
            int idPrestamo = ValidadorUtil.leerEntero("Ingrese el ID del prestamo a abonar: ");
            
            Prestamo prestamo = prestamoController.buscarPrestamo(idPrestamo);
            
            if(prestamo == null){
                System.out.println("Prestamo no encontrado");
                return;
            }
            
            System.out.println("Informacion del prestamo: ");
            System.out.println("Cliente: " + prestamo.getCliente().getId());
            System.out.println("Monto total: " + prestamo.getMontoTotal());
            System.out.println("Saldo pendiente actual: $" + prestamo.getSaldoPendiente());
            
            if(prestamo.getSaldoPendiente() <= 0){
                System.out.println("Este prestamo ya se encuentra totalmente PAGADO");
                return;
            }
            
            double montoPago = ValidadorUtil.leerDouble("Monto del pago: $");
            LocalDate fechaPago = ValidadorUtil.leerFecha("Fecha del pago");
            
            try {
                
                prestamo.aplicarPago(montoPago);                
                Pago pago = new Pago(prestamo, fechaPago, montoPago);
            
                if(pagoController.registrarPago(pago)){
                    System.out.println("Pago registrado correctamente");
                    System.out.println("Nuevo saldo pendiente: $" + prestamo.getSaldoPendiente());
                    System.out.println("Estado del prestamo: " + prestamo.getEstado());
                }

            } catch (IllegalArgumentException e) {
                System.out.println("Error en la transaccion: " + e.getMessage());
            }
    }

    private static void listar(){
        
            System.out.println("HISTORIAL DE PAGOS");
            
            List<Pago> pagos = pagoController.listarPagos();
            
            if(pagos.isEmpty()){
                System.out.println("No hay pagos registrados");
            } else{
                pagos.forEach(System.out::println);
            }
    }
    
    
    private static void buscar(){
        
            System.out.println("BUSCAR PAGO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del pago: ");
            
            Pago p = pagoController.buscarPago(id);
            
            if(p != null){
                System.out.println("Pago encontrado: " + p);
            } else{
                System.out.println("Pago no encontrado");
            }    
    }   
    
    
    private static void respaldar(){
        if(pagoController.respaldarEnArchivo()){
            System.out.println("Pagos guardados en archivo 'pagos.txt'");
        }
    }
    
    
}
