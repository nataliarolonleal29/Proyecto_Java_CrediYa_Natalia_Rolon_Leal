/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.ClienteController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuClientes {
    
    private static Scanner scanner = new Scanner(System.in);
    private static ClienteController clienteController = new ClienteController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE CLIENTES");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Volver al menu principal");
            System.out.println("Seleccione una opcion: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion){
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarCliente();
                    break;
                case 4:
                    actualizarCliente();
                    break;
                case 5:
                    eliminarCliente();
                    break;
                case 6:
                    System.out.println("Regresando al menu principal...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }           
        } while(opcion != 6);
    }
    
    
    public static void registrarCliente(){
        
            System.out.println("REGISTRAR CLIENTE");
            
            System.out.println("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.println("Documento: ");
            String documento = scanner.nextLine();
            
            System.out.println("Correo: ");
            String correo = scanner.nextLine();
            
            System.out.println("Telefono: ");
            String telefono = scanner.nextLine();
            scanner.nextLine();
            
            Cliente cliente = new Cliente(nombre, documento, correo, telefono);
            
            boolean resultado = clienteController.registrarCliente(cliente);
            
            if(resultado){
                System.out.println("Cliente registrado correctamente");
            } else{
                System.out.println("No se pudo registrar el cliente");
            }
        
    }
    
    
    public static void listarClientes(){
        
            System.out.println("LISTA DE EMPLEADOS");
            
            List<Empleado> empleados = empleadoController.listarEmpleados();
            
            if(empleados.isEmpty()){
                System.out.println("No hay empleados registrados");
                return;
            }            
            
            for (Empleado empleado : empleados) {
                System.out.println("ID: " + empleado.getId());
                System.out.println("Nombre: " + empleado.getNombre());
                System.out.println("Documento: " + empleado.getDocumento());
                System.out.println("Correo: " + empleado.getCorreo());
                System.out.println("Rol: " + empleado.getRol());
                System.out.println("Salario: " + empleado.getSalario());
            }
    }
    
    
    public static void buscarEmpleado(){
        
            System.out.println("BUSCAR EMPLEADO");
            
            System.out.println("Ingrese el ID del empleado: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Empleado empleado = empleadoController.buscarEmpleado(id);
            
            if(empleado == null){
                System.out.println("No se encontro un empleado con ese ID");
                return;
            }
            
            System.out.println("Empleado encontrado: ");
            System.out.println("ID: " + empleado.getId());
            System.out.println("Nombre: " + empleado.getNombre());
            System.out.println("Documento: " + empleado.getDocumento());
            System.out.println("Correo: " + empleado.getCorreo());
            System.out.println("Rol: " + empleado.getRol());
            System.out.println("Salario: " + empleado.getSalario());
            
    }
    
    
    public static void actualizarEmpleado(){
        
            System.out.println("ACTUALIZAR EMPLEADO");
            
            System.out.println("Ingrese el ID del empleado: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Empleado empleado = empleadoController.buscarEmpleado(id);
            
            if(empleado == null){
                System.out.println("No se encontro un empleado con ese ID");
                return;
            }
            
            System.out.println("Empleado encontrado: " + empleado.getNombre());
            
            System.out.println("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.println("Nuevo documento: ");
            String documento = scanner.nextLine();
            
            System.out.println("Nuevo correo: ");
            String correo = scanner.nextLine();
            
            System.out.println("Nuevo rol: ");
            String rol = scanner.nextLine();
            
            System.out.println("Nuevo salario: ");
            double salario = scanner.nextDouble();
            scanner.nextLine();
            
            empleado.setNombre(nombre);
            empleado.setDocumento(documento);
            empleado.setCorreo(correo);
            empleado.setRol(rol);
            empleado.setSalario(salario);
            
            boolean resultado = empleadoController.actualizarEmpleado(empleado);
            
            if(resultado){
                System.out.println("Empleado actulizado correctamente");
            } else{
                System.out.println("No se pudo actualizar el empleado");
            }   
    }
    
    
    public static void eliminarEmpleado(){
        
            System.out.println("ELIMINAR EMPLEADO");
            
            System.out.println("Ingrese el ID del empleado: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Empleado empleado = empleadoController.buscarEmpleado(id);
            
            if(empleado == null){
                System.out.println("No se encontro un empleado con ese ID");
                return;
            }
            
            System.out.println("Empleado encontrado: " + empleado.getNombre());
            
            System.out.println("¿Está seguro de eliminarlo? (Si/No): ");
            String confirmacion = scanner.nextLine();
            
            if(confirmacion.equalsIgnoreCase("Si")){
                boolean resultado = empleadoController.eliminarEmpleado(id);
            
                if(resultado){
                    System.out.println("Empleado eliminado correctamente");
                } else{
                    System.out.println("No se pudo eliminar el empleado");
                }
            } else{
                System.out.println("Operacion cancelada");  
            }
    }
    
    
    
}
