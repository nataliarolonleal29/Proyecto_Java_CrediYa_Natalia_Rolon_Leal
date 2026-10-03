/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PrestamoDAO;
import com.mycompany.proyecto_java_crediya.Util.ArchivoUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PrestamoController {
    
    private final PrestamoDAO prestamoDAO = new PrestamoDAO();

    public boolean registrarPrestamo(Prestamo prestamo){
        return prestamoDAO.guardar(prestamo);
    }
    
    public List<Prestamo> listarPrestamos(){
        return prestamoDAO.listar();
    }
    
    public Prestamo buscarPrestamo(int id){
        return prestamoDAO.buscarPorId(id);
    }
    
    public boolean actualizarPrestamo(Prestamo prestamo){
        return prestamoDAO.actualizar(prestamo);
    }
    
    public boolean eliminarPrestamo(int id){
        return prestamoDAO.eliminar(id);
    }
    
    public boolean respaldarEnArchivo(){
        return ArchivoUtil.guardarEnArchivo("prestamos.txt", listarPrestamos());
    }
    
}
