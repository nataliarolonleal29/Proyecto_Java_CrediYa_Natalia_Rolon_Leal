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
        
            System.out.println("LISTA DE CLIENTES");
            
            List<Cliente> clientes = clienteController.listarCliente();
            
            if(clientes.isEmpty()){
                System.out.println("No hay clientes registrados");
                return;
            }            
            
            for (Cliente cliente : clientes) {
                System.out.println("ID: " + cliente.getId());
                System.out.println("Nombre: " + cliente.getNombre());
                System.out.println("Documento: " + cliente.getDocumento());
                System.out.println("Correo: " + cliente.getCorreo());
                System.out.println("Telefono: " + cliente.getTelefono());
            }
    }
    
    
    public static void buscarCliente(){
        
            System.out.println("BUSCAR CLIENTE");
            
            System.out.println("Ingrese el ID del cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = clienteController.buscarCliente(id);
            
            if(cliente == null){
                System.out.println("No se encontro un cliente con ese ID");
                return;
            }
            
            System.out.println("Cliente encontrado: ");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nombre: " + cliente.getNombre());
            System.out.println("Documento: " + cliente.getDocumento());
            System.out.println("Correo: " + cliente.getCorreo());
            System.out.println("Telefono: " + cliente.getTelefono());
            
    }
    
    
    public static void actualizarCliente(){
        
            System.out.println("ACTUALIZAR CLIENTE");
            
            System.out.println("Ingrese el ID del cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = clienteController.buscarCliente(id);
            
            if(cliente == null){
                System.out.println("No se encontro un cliente con ese ID");
                return;
            }
            
            System.out.println("Cliente encontrado: " + cliente.getNombre());
            
            System.out.println("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.println("Nuevo documento: ");
            String documento = scanner.nextLine();
            
            System.out.println("Nuevo correo: ");
            String correo = scanner.nextLine();
            
            System.out.println("Nuevo telefono: ");
            String telefono = scanner.nextLine();
            
            cliente.setNombre(nombre);
            cliente.setDocumento(documento);
            cliente.setCorreo(correo);
            cliente.setTelefono(telefono);
            
            boolean resultado = clienteController.actualizarCliente(cliente);
            
            if(resultado){
                System.out.println("Cliente actulizado correctamente");
            } else{
                System.out.println("No se pudo actualizar el cliente");
            }   
    }
    
    
    public static void eliminarCliente(){
        
            System.out.println("ELIMINAR CLIENTE");
            
            System.out.println("Ingrese el ID del cliente: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = clienteController.buscarCliente(id);
            
            if(cliente == null){
                System.out.println("No se encontro un cliente con ese ID");
                return;
            }
            
            System.out.println("Cliente encontrado: " + cliente.getNombre());
            
            System.out.println("¿Está seguro de eliminarlo? (Si/No): ");
            String confirmacion = scanner.nextLine();
            
            if(confirmacion.equalsIgnoreCase("Si")){
                boolean resultado = clienteController.eliminarCliente(id);
            
                if(resultado){
                    System.out.println("Cliente eliminado correctamente");
                } else{
                    System.out.println("No se pudo eliminar el cliente");
                }
            } else{
                System.out.println("Operacion cancelada");  
            }
    }
    
    
    
}
