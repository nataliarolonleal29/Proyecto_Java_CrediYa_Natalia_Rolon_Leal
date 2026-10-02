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
public class Pago {
    
    private int id;
    private Prestamo prestamo;
    private LocalDate fecha_pago;
    private double monto;

    public Pago(int id, Prestamo prestamo, LocalDate fecha_pago, double monto) {
        this.id = id;
        this.prestamo = prestamo;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public Pago(Prestamo prestamo, LocalDate fecha_pago, double monto) {
        this.prestamo = prestamo;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public LocalDate getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(LocalDate fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Pago{" + "id=" + id + ", prestamo=" + prestamo + ", fecha_pago=" + fecha_pago + ", monto=" + monto + '}';
    }
}
