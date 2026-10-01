/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ClienteDAO;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.EmpleadoDAO;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ClienteController {
    
    private ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    public boolean registrarCliente(Cliente cliente){
        return clienteDAO.guardarCliente(cliente);
    }
    
    public List<Cliente> listarCliente(){
        return clienteDAO.listarClientes();
    }
    
    public Cliente buscarCliente(int id){
        return clienteDAO.buscarClientePorId(id);
    }
    
    public boolean actualizarCliente(Cliente cliente){
        return clienteDAO.actualizarCliente(cliente);
    }
    
    public boolean eliminarCliente(int id){
        return clienteDAO.eliminarCliente(id);
    }
    
    
}
