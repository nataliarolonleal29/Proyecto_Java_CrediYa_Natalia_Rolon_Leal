/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.EmpleadoDAO;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class EmpleadoController {
    
    private EmpleadoDAO empleadoDAO;

    public EmpleadoController() {
        empleadoDAO = new EmpleadoDAO();
    }
    
    public boolean registrarEmpleado(Empleado empleado){
        return empleadoDAO.guardarEmpleado(empleado);
    }
    
    public List<Empleado> listarEmpleados(){
        return empleadoDAO.listarEmpleados();
    }
    
    public Empleado buscarEmpleado(int id){
        return empleadoDAO.buscarEmpleadoPorId(id);
    }
    
    public boolean actualizarEmpleado(Empleado empleado){
        return empleadoDAO.actualizarEmpleado(empleado);
    }
    
    public boolean eliminarEmpleado(int id){
        return empleadoDAO.eliminarEmpleado(id);
    }
    
}
