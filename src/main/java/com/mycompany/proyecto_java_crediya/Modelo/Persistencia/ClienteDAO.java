/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Persistencia;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ClienteDAO {
    
    public boolean guardarCliente(Cliente cliente){
        String sql = "INSERT INTO clientes (nombre, documento, correo, telefono) VALUES (?, ?, ?, ?)";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getDocumento());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getTelefono());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e.getMessage());
            return false;
        }    
    }
    
    
    public List<Cliente> listarClientes(){
        List<Cliente> clientes = new ArrayList<>();
        
        String sql = "SELECT id, nombre, documento, correo, telefono FROM clientes";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Cliente cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("correo"),
                    rs.getString("telefono"));
                
                clientes.add(cliente);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar los clientes: " + e.getMessage());
        }
        
        return clientes;        
    }
    
    
    public Cliente buscarClientePorId(int id){
        
        String sql = "SELECT id, nombre, documento, correo, telefono FROM clientes WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                
                if(rs.next()){
                    
                    return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("correo"),
                    rs.getString("telefono"));
                }

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el cliente por Id: " + e.getMessage());
        }

        return null;
        
    }
    
    
    public boolean actualizarCliente(Cliente cliente){
        
        String sql = "UPDATE clientes SET nombre = ?, documento = ?, correo = ?, telefono = ? WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setString(1, cliente.getNombre());
                ps.setString(2, cliente.getDocumento());
                ps.setString(3, cliente.getCorreo());
                ps.setString(4, cliente.getTelefono());
                ps.setInt(5, cliente.getId());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false;
        }
        
    }
    
    
    public boolean eliminarCliente(int id){
        
        String sql = "DELETE FROM clientes WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setInt(1, id);
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
                
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false;
        }        
    }
    
    
    
    
    
}
