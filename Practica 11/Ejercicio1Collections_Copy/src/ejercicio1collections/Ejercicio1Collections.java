/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio1collections;

import view.View;
//import static com.coti.tools.DiaUtil.*;
/**
 *
 * @author pgina27
 */
public class Ejercicio1Collections {

    public static void main(String[] args) {

        //clear();
        System.out.printf("FACTURAS%n%n");
        View v = new View();
        v.runMenu("\n1.- Dar valores" 
                + "\n2.- Mostrar lista" 
                + "\nq.- Salir" 
                + "\nSeleccion");
    }
    
}
