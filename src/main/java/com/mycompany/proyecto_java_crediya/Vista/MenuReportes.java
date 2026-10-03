/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

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
    
    
    
    
    
    
    
    
}
