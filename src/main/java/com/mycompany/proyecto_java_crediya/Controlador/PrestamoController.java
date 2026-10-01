/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ClienteDAO;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PrestamoDAO;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PrestamoController {
    
    private PrestamoDAO prestamoDAO;

    public PrestamoController(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }
    
    public boolean registrarPrestamo(Prestamo prestamo){
        return prestamoDAO.guardarPrestamo(prestamo);
    }
    
    public List<Prestamo> listarPrestamo(){
        return prestamoDAO.listarPrestamo();
    }
    
    public Prestamo buscarPrestamo(int id){
        return prestamoDAO.buscarPrestamoPorId(id);
    }
    
    public boolean actualizarPrestamo(Prestamo prestamo){
        return prestamoDAO.actualizarPrestamo(prestamo);
    }
    
    public boolean eliminarPrestamo(int id){
        return prestamoDAO.eliminarPrestamo(id);
    }
    
}
