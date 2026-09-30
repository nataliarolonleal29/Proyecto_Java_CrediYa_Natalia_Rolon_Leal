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
            
        } catch (Exception e) {
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
                
                Cliente clientes = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("rol"),
                    rs.getString("correo"),
                    rs.getDouble("salario"));
                
                clientes.add(clientes);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar los empleados: " + e.getMessage());
        }
        
        return empleados;        
    }
    
    
    public Empleado buscarEmpleadoPorId(int id){
        
        String sql = "SELECT id, nombre, documento, rol, correo, salario FROM empleados WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                
                if(rs.next()){
                    
                    return new Empleado(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("documento"),
                    rs.getString("rol"),
                    rs.getString("correo"),
                    rs.getDouble("salario"));
                }

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar el empleado por Id: " + e.getMessage());
        }

        return null;
        
    }
    
    
    public boolean actualizarEmpleado(Empleado empleado){
        
        String sql = "UPDATE empleados SET nombre = ?, documento = ?, rol = ?, correo = ?, salario = ? WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setString(1, empleado.getNombre());
                ps.setString(2, empleado.getDocumento());
                ps.setString(3, empleado.getRol());
                ps.setString(4, empleado.getCorreo());
                ps.setDouble(5, empleado.getSalario());
                ps.setInt(6, empleado.getId());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false;
        }
        
    }
    
    
    public boolean eliminarEmpleado(int id){
        
        String sql = "DELETE FROM empleados WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setInt(1, id);
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
                
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false;
        }        
    }
    
    
    
    
    
}
