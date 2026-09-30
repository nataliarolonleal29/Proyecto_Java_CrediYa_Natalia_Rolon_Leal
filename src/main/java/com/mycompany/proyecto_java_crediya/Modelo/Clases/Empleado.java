/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Clases;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Empleado extends Persona{
    
    private int id;
    private String rol;
    private double salario;

    public Empleado(int id, String nombre, String documento, String correo, String rol, double salario) {
        super(nombre, documento, correo);
        this.id = id;
        this.rol = rol;
        this.salario = salario;
    }

    public Empleado(String nombre, String documento, String correo, String rol, double salario) {
        super(nombre, documento, correo);
        this.rol = rol;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", rol=" + rol + ", salario=" + salario + '}';
    }
    
}
