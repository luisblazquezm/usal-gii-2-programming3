/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2mvc;

import view.View;

public class Ejercicio2MVC {

    public static void main(String[] args) {
        View v = new View();
        v.runMenu("\n1.- Leer tabla de ventas " 
                + "\n2.- Leer tabla de precios " 
                + "\n3.- Calcular beneficios " 
                + "\n4.- Mostrar resultados " 
                + "\nq.- Salir ");
    }
    
}
