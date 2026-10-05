/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Clases;

import java.time.LocalDate;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Prestamo {
    
    private int id;
    private Cliente cliente;
    private Empleado empleado;
    private double monto;
    private double interes;
    private int cuotas;
    private LocalDate fecha_inicio;
    private EstadoPrestamo estado;
    private double montoTotal;
    private double valorCuota;
    private double saldoPendiente;

    public Prestamo(int id, Cliente cliente, Empleado empleado, double monto, double interes, int cuotas, LocalDate fecha_inicio, EstadoPrestamo estado) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.fecha_inicio = fecha_inicio;
        this.estado = EstadoPrestamo.PENDIENTE;
        
        calcularValores();
    }

    public Prestamo(Cliente cliente, Empleado empleado, double monto, double interes, int cuotas, LocalDate fecha_inicio, EstadoPrestamo estado) {
        this.cliente = cliente;
        this.empleado = empleado;
        this.monto = monto;
        this.interes = interes;
        this.cuotas = cuotas;
        this.fecha_inicio = fecha_inicio;
        this.estado = estado;
        this.montoTotal = montoTotal;
        this.valorCuota = valorCuota;
        this.saldoPendiente = saldoPendiente;
        
        calcularValores();
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public EstadoPrestamo getEstado() {
        return estado;
    }

    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

    public double getSaldoPendiente() {
        return saldoPendiente;
    }

    public void setSaldoPendiente(double saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", cliente=" + cliente + ", empleado=" + empleado + ", monto=" + monto + ", interes=" + interes + ", cuotas=" + cuotas + ", fecha_inicio=" + fecha_inicio + ", estado=" + estado + ", montoTotal=" + montoTotal + ", valorCuota=" + valorCuota + ", saldoPendiente=" + saldoPendiente + '}';
    }

    
    
    
    public double calcularValores(){
        
        double valorInteres = monto * (interes / 100.0);
        
        this.montoTotal = monto + valorInteres;
        
        this.valorCuota = cuotas > 0 ? (montoTotal / cuotas) : montoTotal;
        
        if(this.saldoPendiente == 0 && this.estado == EstadoPrestamo.PENDIENTE){
            this.saldoPendiente = this.montoTotal;
        }
        return this.montoTotal;
    }

    public double aplicarPago(double montoPago){
        
        if(montoPago <= 0){
            throw new IllegalArgumentException("El valor a pagar debe ser mayor a cero.");
        }
        
        if(montoPago > saldoPendiente){
            throw new IllegalArgumentException("El pago ($" + montoPago + ") no puede ser superior al saldo pendiente ($" + saldoPendiente + ")");
        }
        
        this.saldoPendiente -= montoPago;
        
        if(this.saldoPendiente == 0){
            // this.saldoPendiente = 0;
            this.estado = EstadoPrestamo.PAGADO;
        }
        return this.saldoPendiente;
    }
    
}
