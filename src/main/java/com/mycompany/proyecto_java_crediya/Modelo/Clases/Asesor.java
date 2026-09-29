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

    public Asesor(int id, String nombre, String documento, String rol, String correo, double salario) {
        super(id, nombre, documento, rol, correo, salario);
        this.comision = comision;
    }

    public Asesor(String nombre, String documento, String rol, String correo, double salario) {
        super(nombre, documento, rol, correo, salario);
        this.comision = comision;
    }

    public double getComision() {
        return comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }
    
    
    
    
    
    
}
