/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goles;

import java.io.Console;

public class Goles {

    public static void main(String[] args) {
        float g1, g2, g3, g4, g5 ,g6, g7, g8, g9, g10;
        Console c = System.console();
        c.printf("Goal Average%n");
        c.printf("Escriba el nº de tantos del partido 1: ");
        g1 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 2: ");
        g2 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 3: ");
        g3 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 4: ");
        g4 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 5: ");
        g5 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 6: ");
        g6 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 7: ");
        g7 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 8: ");
        g8 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 9: ");
        g9 = Float.parseFloat(c.readLine());
        c.printf("Escriba el nº de tantos del partido 10: ");
        g10 = Float.parseFloat(c.readLine());
        
        float goalAverage = (g1 + g2 + g3 + g4 + g5 + g6 + g7 + g8 + g9 + g10) / 10.0f;
        c.printf("El goal average del equipo es%6.2f%n", goalAverage);
    
    }//End of main
    
}//End of Goles
