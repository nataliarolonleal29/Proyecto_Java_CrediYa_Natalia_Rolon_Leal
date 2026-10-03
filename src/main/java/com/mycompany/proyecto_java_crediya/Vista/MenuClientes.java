/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Vista;

import com.mycompany.proyecto_java_crediya.Controlador.ClienteController;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Util.ValidadorUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class MenuClientes {
    
    private static final ClienteController controller = new ClienteController();
    

    public static void mostrarMenu(){
        int opcion;
        
        do{
            System.out.println("GESTION DE CLIENTES");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Actualizar cliente");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Respaldar en archivo clientes.txt");
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
        
            System.out.println("REGISTRAR CLIENTE");
            
            String nombre = ValidadorUtil.leerTexto("Nombre: ");
            String documento = ValidadorUtil.leerTexto("Documento: ");
            String correo = ValidadorUtil.leerTexto("Correo: ");
            String telefono = ValidadorUtil.leerTexto("Telefono: ");
            
            if(controller.registrarCliente(new Cliente(nombre, documento, correo, telefono))){
                System.out.println("Cliente registrado con exito");
            }        
    }
    
    
    private static void listar(){
        
            System.out.println("LISTA DE CLIENTES");
            
            List<Cliente> clientes = controller.listarClientes();
            
            if(clientes.isEmpty()){
                System.out.println("No hay clientes registrados");
            } else{
                clientes.forEach(System.out::println);
            }
    }
    
    
    private static void buscar(){
        
            System.out.println("BUSCAR CLIENTE");
            
            int id = ValidadorUtil.leerEntero("Ingrese el ID del cliente: ");
            Cliente cliente = controller.buscarCliente(id);
            
            if(cliente != null){
                System.out.println("Cliente encontrado: " + cliente);
            } else{
                System.out.println("No se encontro un cliente con ese ID");
            }            
    }
    
    
    private static void actualizar(){
        
            System.out.println("ACTUALIZAR CLIENTE");
            
            int id = ValidadorUtil.leerEntero("Ingrese el ID del cliente: ");
            Cliente cliente = controller.buscarCliente(id);
            
            if(cliente == null){
                System.out.println("No se encontro a ningun cliente con ese ID");
                return;
            }
            
            cliente.setNombre(ValidadorUtil.leerTexto("Nuevo nombre: "));
            cliente.setDocumento(ValidadorUtil.leerTexto("Nuevo documento: "));
            cliente.setCorreo(ValidadorUtil.leerTexto("Nuevo correo: "));
            cliente.setTelefono(ValidadorUtil.leerTexto("Nuevo telefono: "));
            
            if(controller.actualizarCliente(cliente)){
                System.out.println("Cliente actualizado con exito");
            }
    }
    
    
    private static void eliminar(){
        
            System.out.println("ELIMINAR CLIENTE");
            
            int id = ValidadorUtil.leerEntero("Ingrese el ID del cliente: ");
            String confirmacion = ValidadorUtil.leerTexto("¿Esta seguro? (Si/No)");
            
            if(confirmacion.equalsIgnoreCase("Si")){
                if(controller.eliminarCliente(id)){
                    System.out.println("Cliente eliminado correctamente");
                }
            } else{
                System.out.println("Operacion cancelada");  
            }
    }
    
    private static void respaldar(){
        if(controller.respaldarEnArchivo()){
            System.out.println("Datos de clientes exportados a 'clientes.txt'");
        }
    }
    
    
    
}
