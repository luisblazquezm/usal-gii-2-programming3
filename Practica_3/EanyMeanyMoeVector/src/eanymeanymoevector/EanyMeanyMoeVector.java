/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eanymeanymoevector;

import java.util.Scanner;

public class EanyMeanyMoeVector {

    public static void main(String[] args) {
        String[] Nombres = new String[3];
        float[] Tallas = new float[3];
        int[] Edades = new int[3];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("EANY,MEANIE,MOE\n");
        System.out.println("Introduzca los nombres de: \n");
        for(int i=0;i<Nombres.length;i++){
            System.out.println("Escriba el nombre: ");
            Nombres[i] = sc.nextLine();
            System.out.println("Escriba la edad: ");
            Edades[i] = sc.nextInt();
            System.out.println("Escriba la talla: ");
            Tallas[i] = sc.nextFloat();
            sc.nextLine();//Elimina el ultimo retorno de carro
            System.out.println();
        }
        
        System.out.printf("|%15s|%8s|%8s|\n","NOMBRE","EDAD","TALLA");
        for(int i=0;i<Nombres.length;i++){
            System.out.printf("|%15s|%8d|%8.2f|%n",Nombres[i], Edades[i], Tallas[i]);
        }
        
        
    }
    
}
