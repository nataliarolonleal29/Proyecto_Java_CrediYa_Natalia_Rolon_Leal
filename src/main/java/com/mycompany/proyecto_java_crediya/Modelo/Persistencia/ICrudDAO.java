/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Persistencia;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public interface ICrudDAO<T> {
    
    boolean guardar(T entidad) throws SQLException;
    List<T> listar() throws SQLException;
    T buscarPorId(int id) throws SQLException;
    boolean actualizar(T entidad) throws SQLException;
    boolean eliminar(int id) throws SQLException;
    
}
