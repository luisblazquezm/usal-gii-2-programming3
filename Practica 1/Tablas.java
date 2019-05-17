/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablas;

import java.io.Console;

public class Tablas {
    
    public static void main(String[] args) {
        String nameOfEany, nameOfMeany, nameOfMoe;
        int ageOfEany, ageOfMeany, ageOfMoe;
        float weightOfEany, weightOfMeany, weightOfMoe;
        Console c = System.console();
        
        c.printf("Escriba el nombre de Eany: ");
        nameOfEany = c.readLine();
        c.printf("Escriba el nombre de Meany: ");
        nameOfMeany = c.readLine();
        c.printf("Escriba el nombre de Moe: ");
        nameOfMoe = c.readLine();
       
        c.printf("Escriba la edad de Eany: ");
        ageOfEany = Integer.parseInt(c.readLine());
        c.printf("Escriba la edad de Meany: ");
        ageOfMeany = Integer.parseInt(c.readLine());
        c.printf("Escriba la edad de Moe: ");
        ageOfMoe = Integer.parseInt(c.readLine());
        
        c.printf("Escriba el peso de Eany: ");
        weightOfEany = Float.parseFloat(c.readLine());
        c.printf("Escriba el peso de Meany: ");
        weightOfMeany = Float.parseFloat(c.readLine());
        c.printf("Escriba el peso de Moe: ");
        weightOfMoe = Float.parseFloat(c.readLine());
        
        c.printf("%n|%-15s|%-6s|%-7s|%n",
                "Nombre", "Edad", "Talla");
        
        c.printf("|%15s|%6d|%7.2f|%n",
                nameOfEany, ageOfEany, weightOfEany);
        c.printf("|%15s|%6d|%7.2f|%n",
                nameOfMeany, ageOfMeany, weightOfMeany);
        c.printf("|%15s|%6d|%7.2f|%n",
                nameOfMoe, ageOfMoe, weightOfMoe);
        
    }
    
}
