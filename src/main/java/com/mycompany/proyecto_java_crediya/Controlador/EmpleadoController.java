/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Empleado;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.EmpleadoDAO;
import com.mycompany.proyecto_java_crediya.Util.ArchivoUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class EmpleadoController {
    
    private final EmpleadoDAO empleadoDAO = new EmpleadoDAO();
    
    public boolean registrarEmpleado(Empleado empleado){
        return empleadoDAO.guardar(empleado);
    }
    
    public List<Empleado> listarEmpleados(){
        return empleadoDAO.listar();
    }
    
    public Empleado buscarEmpleado(int id){
        return empleadoDAO.buscarPorId(id);
    }
    
    public boolean actualizarEmpleado(Empleado empleado){
        return empleadoDAO.actualizar(empleado);
    }
    
    public boolean eliminarEmpleado(int id){
        return empleadoDAO.eliminar(id);
    }
    
    public boolean respaldarEnArchivo(){
        return ArchivoUtil.guardarEnArchivo("empleado.txt", listarEmpleados());
    }
    
}
