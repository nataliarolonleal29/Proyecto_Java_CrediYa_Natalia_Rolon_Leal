/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ClienteDAO;
import com.mycompany.proyecto_java_crediya.Util.ArchivoUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ClienteController {
    
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public boolean registrarCliente(Cliente cliente){
        return clienteDAO.guardar(cliente);
    }
    
    public List<Cliente> listarClientes(){
        return clienteDAO.listar();
    }
    
    public Cliente buscarCliente(int id){
        return clienteDAO.buscarPorId(id);
    }
    
    public boolean actualizarCliente(Cliente cliente){
        return clienteDAO.actualizar(cliente);
    }
    
    public boolean eliminarCliente(int id){
        return clienteDAO.eliminar(id);
    }
    
    public boolean respaldarEnArchivo() {
        return ArchivoUtil.guardarEnArchivo("clientes.txt", listarClientes());
    }
    
    
    
}
