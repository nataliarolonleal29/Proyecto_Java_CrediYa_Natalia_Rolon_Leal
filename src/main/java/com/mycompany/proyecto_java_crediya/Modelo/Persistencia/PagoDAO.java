/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Persistencia;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.EstadoPrestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Pago;
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
public class PagoDAO {
    
    public boolean guardarPago(Pago pago){
        String sql = "INSERT INTO pagos (prestamo_id, fecha_pago, monto) VALUES (?, ?, ?)";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, pago.getPrestamo().getId());
            ps.setDate(2, java.sql.Date.valueOf(pago.getFecha_pago()));
            ps.setDouble(3, pago.getMonto());
            
            ps.executeUpdate();
            
            return true;
            
        } catch (SQLException e) {
            System.out.println("Error al guardar empleado: " + e.getMessage());
            return false;
        }    
    }
    
    
    public List<Pago> listarPago(){
        List<Pago> pagos = new ArrayList<>();
        
        String sql = "SELECT id, prestamo_id, fecha_pago, monto FROM pagos";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()){
            
            while(rs.next()){
                
                Prestamo prestamo = new Prestamo(
                    rs.getInt("prestamo_id"),
                    null,
                    null,
                    0,
                    0,
                    0,
                    null, 
                    null
                );
                
                Pago pago = new Pago(
                    rs.getInt("id"),
                    prestamo,
                    rs.getDate("fecha_pago").toLocalDate(),
                    rs.getDouble("monto")
                );
                
                pagos.add(pago);
            }
            
        } catch (SQLException e) {
            System.out.println("Error al listar pagos: " + e.getMessage());
        }
        
        return pagos;        
    }
    
    
    public Pago buscarPagoPorId(int id){
        
        String sql = "SELECT id, prestamo_id, fecha_pago, monto FROM pagos WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            
            ps.setInt(1, id);
            
            try (ResultSet rs = ps.executeQuery()){
                
                if(rs.next()){
                    
                    Prestamo prestamo = new Prestamo(
                        rs.getInt("prestamo_id"),
                        null,
                        null,
                        0,
                        0,
                        0,
                        null,
                        null
                    );

                    return new Pago(
                        rs.getInt("id"),
                        prestamo,
                        rs.getDate("fecha_pago").toLocalDate(),
                        rs.getDouble("monto")
                    );
                    
                }

            }
        } catch (SQLException e) {
            System.out.println("Error al buscar pago por Id: " + e.getMessage());
        }

        return null;
        
    }
    
    
    public boolean actualizarPago(Pago pago){
        
        String sql = "UPDATE pagos SET prestamo_id = ?, fecha_pago = ?, monto = ? WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){

                ps.setInt(1, pago.getPrestamo().getId());
                ps.setDate(2, java.sql.Date.valueOf(pago.getFecha_pago()));
                ps.setDouble(3, pago.getMonto());
                ps.setInt(4, pago.getId());
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
        } catch (SQLException e) {
            System.out.println("Error al actualizar pago: " + e.getMessage());
            return false;
        }
        
    }
    
    
    public boolean eliminarPago(int id){
        
        String sql = "DELETE FROM pagos WHERE id = ?";
        
        try (Connection con = ConexionDB.MySQLConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
                
                ps.setInt(1, id);
                
                int filasAfectadas = ps.executeUpdate();
                
                return filasAfectadas > 0;
                
                
        } catch (SQLException e) {
            System.out.println("Error al eliminar pago: " + e.getMessage());
            return false;
        }
    }
    
    
    
    
}
