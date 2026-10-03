/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.EmpleadoController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Util.ValidadorUtil;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuEmpleados {
    
    private static final EmpleadoController controller = new EmpleadoController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE EMPLEADOS");
            System.out.println("1. Registrar empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Actualizar empleado");
            System.out.println("5. Eliminar empleado");
            System.out.println("6. Respaldar en archivo empleados.txt");
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
        
            System.out.println("REGISTRAR EMPLEADO");
            
            String nombre = ValidadorUtil.leerTexto("Nombre: ");
            String documento = ValidadorUtil.leerTexto("Documento: ");
            String correo = ValidadorUtil.leerTexto("Correo: ");
            String rol = ValidadorUtil.leerTexto("Rol (Asesor/Supervisor): ");
            double salario = ValidadorUtil.leerDouble("Salario: $");
            
            if(controller.registrarEmpleado(new Empleado(nombre, documento, correo, rol, salario))){
                System.out.println("Empleado registrado con exito");
            }
        
    }
    
    
    private static void listar(){
        
            System.out.println("LISTA DE EMPLEADOS");
            
            List<Empleado> empleados = controller.listarEmpleados();
            
            if(empleados.isEmpty()){
                System.out.println("No hay empleados registrados");
            } else{
                empleados.forEach(System.out::println);
            }
    }
    
    
    private static void buscar(){
        
            System.out.println("BUSCAR EMPLEADO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del empleado: ");

            Empleado e = controller.buscarEmpleado(id);
            
            if(e != null){
                System.out.println("Empleado encontrado: " + e);
            } else{
                System.out.println("Empleado no encontrado");
            }
    }
    
    
    private static void actualizar(){
        
            System.out.println("ACTUALIZAR EMPLEADO");
            
            int id = ValidadorUtil.leerEntero("Ingrese el ID del empleado: ");
            
            Empleado e = controller.buscarEmpleado(id);
            
            if(e == null){
                System.out.println("Empleado no encontrado");
                return;
            }
            
            e.setNombre(ValidadorUtil.leerTexto("Nuevo nombre: "));
            e.setDocumento(ValidadorUtil.leerTexto("Nuevo documento: "));
            e.setCorreo(ValidadorUtil.leerTexto("Nuevo correo: "));
            e.setRol(ValidadorUtil.leerTexto("Nuevo rol: "));
            e.setSalario(ValidadorUtil.leerDouble("Nuevo salario: $"));
            
            if(controller.actualizarEmpleado(e)){
                System.out.println("Empleado actualizado con exito");
            }
    }
    
    
    private static void eliminar(){
        
            System.out.println("ELIMINAR EMPLEADO");

            int id = ValidadorUtil.leerEntero("Ingrese el ID del empleado: ");
            String confirmacion = ValidadorUtil.leerTexto("¿Esta seguro? (Si/No)");
            
            if(confirmacion.equalsIgnoreCase("Si")){
                if(controller.eliminarEmpleado(id)){
                    System.out.println("Empleado eliminado con exito");
                }
            } else{
                System.out.println("Operacion cancelada");  
            }
    }
    
    
    private static void respaldar(){
        if(controller.respaldarEnArchivo()){
            System.out.println("Empleados guardados en 'empleados.txt'");
        }
    }
}  
    
    
    
