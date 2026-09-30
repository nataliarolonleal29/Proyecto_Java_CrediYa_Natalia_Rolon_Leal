/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Clases;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Asesor extends Empleado{
    
    private double comision;

    public Asesor(double comision, int id, String rol, double salario, String nombre, String documento, String correo) {
        super(id, nombre, documento, correo, rol, salario);
        this.comision = comision;
    }

    public Asesor(double comision, String rol, double salario, String nombre, String documento, String correo) {
        super(nombre, documento, correo, rol, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    
    
    
    
    
}
