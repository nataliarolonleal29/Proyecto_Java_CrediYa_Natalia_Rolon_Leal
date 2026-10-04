/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.ReporteController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import com.mycompany.proyecto_java_crediya.Util.ValidadorUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuReportes {
    
    private static final ReporteController reporteController = new ReporteController();
    
    public static void mostrarMenu(){
        
        int opcion;
        do{
            System.out.println("SECCION DE REPORTES Y ESTADISTICAS");
            System.out.println("1. Consultar prestamos activos (Pendientes)");
            System.out.println("2. Consultar prestamos finalizados (Pagados)");
            System.out.println("3. Consultar clientes morosos / con saldo pendiente");
            System.out.println("4. Ver total acumulado prestado vs. recaudado");
            System.out.println("5. Consultar prestamos por cliente");
            System.out.println("6. Volver al menu principal");
            
            opcion = ValidadorUtil.leerEntero("Seleccione una opcion: ");
            
            switch(opcion){
                case 1:
                    verPrestamosActivos();
                    break;
                case 2:
                    verPrestamosPagados();
                    break;
                case 3:
                    verClientesMorosos();
                    break;
                case 4:
                    verTotales();
                    break;
                case 5:
                    verPrestamosPorCliente();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while(opcion != 6);     
    }
    
    
    private static void verPrestamosActivos(){
        System.out.println("PRESTAMOS ACTIVOS (PENDIENTES)");
        List<Prestamo> activos = reporteController.obtenerPrestamosActivos();
        if(activos.isEmpty()){
            System.out.println("No hay prestamos activos");
        } else{
            activos.forEach(System.out::println);
        }
    }
    
    private static void verPrestamosPagados(){
        System.out.println("PRESTAMOS PAGADOS");
        List<Prestamo> pagados = reporteController.obtenerPrestamosPagados();
        if(pagados.isEmpty()){
            System.out.println("No hay prestamos pagados");
        } else{
            pagados.forEach(System.out::println);
        }
    }
    
    private static void verClientesMorosos(){
        System.out.println("CLIENTES CON SALDO PENDIENTE");
        List<Prestamo> morosos = reporteController.obtenerClientesConSaldoPendiente();
        if(morosos.isEmpty()){
            System.out.println("¡Excelente! No hay clientes morosos");
        } else{
            morosos.forEach(p -> System.out.println("Cliente: " + p.getCliente().getNombre() + " | Telefono: " + p.getCliente().getTelefono() + " | Deuda pendiente: $" + p.getSaldoPendiente()));
        }
    }
    
    private static void verTotales(){
        System.out.println("INDICADORES FINANCIEROS GENERALES");
        double totalPrestado = reporteController.calcularTotalDineroPrestado();
        double totalRecaudado = reporteController.calcularTotalDineroRecaudado();
        
        System.out.println("Total dinero colocado en prestamos: $" + totalPrestado);
        System.out.println("Total dinero recaudado mediante bonos: $" + totalRecaudado);
        System.out.println("Capital por cobrar: $" + (totalPrestado - totalRecaudado));
        
    }
    
    private static void verPrestamosPorCliente(){
        int idCliente = ValidadorUtil.leerEntero("Ingrese el ID del cliente a consultar: ");
        List<Prestamo> lista = reporteController.obtenerPrestamoPorCliente(idCliente);
        if(lista.isEmpty()){
            System.out.println("No se encontraron prestamos asociados a ese cliente");
        } else{
            lista.forEach(System.out::println);
        }
    }
    
    
    
    
    
}
