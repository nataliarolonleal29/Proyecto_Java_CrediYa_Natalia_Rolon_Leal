/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Modelo.Clases;

/**
 *
 * @author Natalia Rolon Leal
 */
public class Cliente extends Persona{
    
    private int id;
    private String telefono;

    public Cliente(int id, String telefono, String nombre, String documento, String correo) {
        super(nombre, documento, correo);
        this.id = id;
        this.telefono = telefono;
    }

    public Cliente(String telefono, String nombre, String documento, String correo) {
        super(nombre, documento, correo);
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", telefono=" + telefono + '}';
    }

}
