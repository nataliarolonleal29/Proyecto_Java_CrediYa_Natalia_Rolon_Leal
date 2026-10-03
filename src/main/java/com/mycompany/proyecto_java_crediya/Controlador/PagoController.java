/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Pago;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PagoDAO;
import com.mycompany.proyecto_java_crediya.Util.ArchivoUtil;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PagoController {
    
    private final PagoDAO pagoDAO = new PagoDAO();
    
    public boolean registrarPago(Pago pago){
        return pagoDAO.guardar(pago);
    }
    
    public List<Pago> listarPagos(){
        return pagoDAO.listar();
    }
    
    public Pago buscarPago(int id){
        return pagoDAO.buscarPorId(id);
    }
    
    public boolean actualizarPago(Pago pago){
        return pagoDAO.actualizar(pago);
    }
    
    public boolean eliminarPago(int id){
        return pagoDAO.eliminar(id);
    }
    
    public boolean respaldarEnArchivo(){
        return ArchivoUtil.guardarEnArchivo("pagos.txt", listarPagos());
    }
    
}
