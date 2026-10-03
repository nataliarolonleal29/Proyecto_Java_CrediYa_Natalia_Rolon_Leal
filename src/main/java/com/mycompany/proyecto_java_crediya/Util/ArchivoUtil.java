/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ArchivoUtil {
    
    public static boolean guardarEnArchivo(String nombreArchivo, List<?> lista) {
        if(lista == null || lista.isEmpty()){
            System.out.println("La lista está vacia. No hay datos para guardar");
            return false;
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Object elemento : lista) {
                writer.write(elemento.toString());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }
    
}
