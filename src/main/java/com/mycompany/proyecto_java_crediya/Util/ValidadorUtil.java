/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto_java_crediya.Util;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Natalia Rolon Leal
 */
public class ValidadorUtil {
    
    private static final Scanner scanner = new Scanner(System.in);
    
    public static int leerEntero(String mensaje){
        while (true) {            
            try{
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch(NumberFormatException e){
                System.err.println("Entrada invalida. Debe ingresar un numero entero.");
            }
        }
    }
    
    public static double leerDouble(String mensaje){
        while (true) {            
            try {
                System.out.println(mensaje);
                double valor = Double.parseDouble(scanner.nextLine().trim());
                if(valor < 0){
                    System.out.println("El valor no puede ser negativo");
                    continue;
                }
                return valor;
            } catch (NumberFormatException e) {
                System.err.println("Entrada invalida. Debe ingresar un valor numerico decimal valido");
            }
        }
    }
    
    public static String leerTexto(String mensaje){
        while (true) {            
            System.out.println(mensaje);
            String entrada = scanner.nextLine().trim();
            if(!entrada.isEmpty()){
                return entrada;
            }
            System.err.println("El campo no puede estar vacio");
        }
    }
    
    public static LocalDate leerFecha(String mensaje){
        while (true) {            
            try {
                System.out.println(mensaje + " (AAAA-MM-DD): ");
                String fechaTexto = scanner.nextLine().trim();
                return LocalDate.parse(fechaTexto);
            } catch (DateTimeParseException e) {
                System.err.println("Formato de fecha invalido. Utilice el formato AAAA-MM-DD (ej: 2026-10-15)");
            }
        }
    }
    
    
    
    
    
}
