/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Clases;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Supervisor extends Empleado{
    
    private double bono;

    public Supervisor(int id, String nombre, String documento, String correo, String rol, double salario, double bono) {
        super(id, nombre, documento, correo, rol, salario);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    @Override
    public String toString() {
        return "Supervisor{" + "bono=" + bono + '}';
    }
}
