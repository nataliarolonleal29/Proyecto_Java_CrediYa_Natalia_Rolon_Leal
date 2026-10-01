/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Persistencia;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.EstadoPrestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
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
public class PrestamoDAO {
    
    public boolean guardarPrestamo(Prestamo prestamo){
        String sql = "INSERT INTO prestamos (cliente_id, empleado_id, monto, interes, cuotas, fecha_inicio, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, prestamo.getCliente().getId());
            ps.setInt(2, prestamo.getEmpleado().getId());
            ps.setDouble(3, prestamo.getMonto());
            ps.setDouble(4, prestamo.getInteres());
            ps.setDouble(5, prestamo.getCuotas());
            ps.setDate(6, java.sql.Date.valueOf(prestamo.getFecha_inicio()));
            ps.setString(7, prestamo.getEstado().name());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al guardar empleado: " + e.getMessage());
            return false;
        }    
    }
    
    
    public List<Prestamo> listarPrestamo(){
        List<Prestamo> prestamos = new ArrayList<>();
        
        String sql = "SELECT id, cliente_id, empleado_id, monto, interes, cuotas, fecha_inicio, estado FROM prestamos";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Cliente cliente = new Cliente(
                    rs.getInt("cliente_id"),
                    "",
                    "",
                    "",
                    ""
                );
                
                Empleado empleado = new Empleado(
                    rs.getInt("empleado_id"),
                    "",
                    "",
                    "",
                    "",
                    0
                );
                
                Prestamo prestamo = new Prestamo(
                    rs.getInt("id"),
                    cliente,
                    empleado,
                    rs.getDouble("monto"),
                    rs.getDouble("interes"),
                    rs.getInt("cuotas"),
                    rs.getDate("fecha_inicio").toLocalDate(),
                    EstadoPrestamo.valueOf(rs.getString("estado")));
                
                prestamos.add(prestamo);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar prestamos: " + e.getMessage());
        }
        
        return prestamos;        
    }
    
    
    public Prestamo buscarPrestamoPorId(int id){
        
        String sql = "SELECT id, cliente_id, empleado_id, monto, interes, cuotas, fecha_inicio, estado FROM prestamos WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                
                if(rs.next()){
                    
                    Cliente cliente = new Cliente(
                        rs.getInt("cliente_id"),
                        "",
                        "",
                        "",
                        ""
                    );

                    Empleado empleado = new Empleado(
                        rs.getInt("empleado_id"),
                        "",
                        "",
                        "",
                        "",
                        0
                    );
                    
                    return new Prestamo(
                        rs.getInt("id"),
                        cliente,
                        empleado,
                        rs.getDouble("monto"),
                        rs.getDouble("interes"),
                        rs.getInt("cuotas"),
                        rs.getDate("fecha_inicio").toLocalDate(),
                        EstadoPrestamo.valueOf(rs.getString("estado")));
                }

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar prestamo por Id: " + e.getMessage());
        }

        return null;
        
    }
    
    
    public boolean actualizarPrestamo(Prestamo prestamo){
        
        String sql = "UPDATE prestamos SET cliente_id = ?, empleado_id = ?, monto = ?, interes = ?, cuotas = ?, fecha_inicio = ?, estado = ? WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setInt(1, prestamo.getCliente().getId());
                ps.setInt(2, prestamo.getEmpleado().getId());
                ps.setDouble(3, prestamo.getMonto());
                ps.setDouble(4, prestamo.getInteres());
                ps.setInt(5, prestamo.getCuotas());
                ps.setDate(6, java.sql.Date.valueOf(prestamo.getFecha_inicio()));
                ps.setString(7, prestamo.getEstado().name());
                ps.setInt(8, prestamo.getId());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
        } catch (SQLException e) {
            System.out.println("Error al actualizar prestamo: " + e.getMessage());
            return false;
        }
        
    }
    
    
    public boolean eliminarPrestamo(int id){
        
        String sql = "DELETE FROM prestamos WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setInt(1, id);
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
                
        } catch (SQLException e) {
            System.out.println("Error al eliminar prestamo: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
    
}
