/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1mvc;

import view.View;

public class Ejercicio1MVC {

    public static void main(String[] args) {
        View v = new View();
        v.runMenu("\n1.- Importar archivo de Personas "
                + "\n2.- Mostrar datos"
                + "\nq.- Salir");
    
    }
}
