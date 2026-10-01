/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.Cliente;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Pago;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.ClienteDAO;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PagoDAO;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class PagoController {
    
    private PagoDAO pagoDAO;

    public PagoController(PagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }    
    
    public boolean registrarPago(Pago pago){
        return pagoDAO.guardarPago(pago);
    }
    
    public List<Pago> listarPago(){
        return pagoDAO.listarPago();
    }
    
    public Pago buscarPago(int id){
        return pagoDAO.buscarPagoPorId(id);
    }
    
    public boolean actualizarPago(Pago pago){
        return pagoDAO.actualizarPago(pago);
    }
    
    public boolean eliminarPago(int id){
        return pagoDAO.eliminarPago(id);
    }
    
}
