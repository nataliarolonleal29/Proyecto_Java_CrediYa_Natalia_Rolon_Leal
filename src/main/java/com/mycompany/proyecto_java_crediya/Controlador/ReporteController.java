/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Controlador;

import com.mycompany.proyecto_java_crediya.Modelo.Clases.EstadoPrestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Pago;
import com.mycompany.proyecto_java_crediya.Modelo.Clases.Prestamo;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PagoDAO;
import com.mycompany.proyecto_java_crediya.Modelo.Persistencia.PrestamoDAO;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ReporteController {
    
    private final PrestamoDAO prestamoDAO = new PrestamoDAO();
    private final PagoDAO pagoDAO = new PagoDAO();
    
    // Filtrar prestamos con estado PENDIENTE usando lambdas y streams
    public List<Prestamo> obtenerPrestamosActivos(){
        return prestamoDAO.listar().stream().filter(p -> p.getEstado() == EstadoPrestamo.PENDIENTE).collect(Collectors.toList());
    }
    
    // Filtrar prestamos pagados
    public List<Prestamo> obtenerPrestamosPagados(){
        return prestamoDAO.listar().stream().filter(p -> p.getEstado() == EstadoPrestamo.PAGADO).collect(Collectors.toList());
    }
    
    // Clientes con morosidad(saldo pendiente mayor a cero)
    public List<Prestamo> obtenerClientesConSaldoPendiente(){
        return prestamoDAO.listar().stream().filter(p -> p.getSaldoPendiente() > 0).collect(Collectors.toList());
    }
    
    // Calcular total de dinero prestado por la empresa
    public double calcularTotalDineroPrestado(){
        return prestamoDAO.listar().stream().mapToDouble(Prestamo::getMontoTotal).sum();
    }
    
    // Calcular total de dinero cobrado y reunido mediante pagos
    public double calcularTotalDineroRecaudado(){
        return pagoDAO.listar().stream().mapToDouble(Pago::getMonto).sum();
    }
    
    // Consultar los prestamos dados a un cliente por ID
    public List<Prestamo> obtenerPrestamoPorCliente(int idCliente){
        return prestamoDAO.listar().stream().filter(p -> p.getCliente() != null && p.getCliente().getId() == idCliente).collect(Collectors.toList());
    }
    
    
    
    
    
}
