/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edad;

import java.io.Console;

public class Edad {

    public static void main(String[] args) {
        Console c = System.console();
        
        c.printf("En qué año estamos ? ");
        String temp = c.readLine();
        int actualYear = Integer.parseInt(temp);
        
        c.printf("Escriba el año en que nació : ");
        temp = c.readLine();
        int birthYear =  Integer.parseInt(temp);
        
        int age = actualYear - birthYear;
        
        c.printf("Su edad es de %d años%n", age);
     
    }//End of main
    
}//End of Edad
