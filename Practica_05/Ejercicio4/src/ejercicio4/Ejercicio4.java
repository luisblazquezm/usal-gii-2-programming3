/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        int num,j = 0;
        int suma = 0;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Introduzca un numero mayor que 12 para mostrar su tabla de multiplicar: ");
        num = Integer.parseInt(sc.nextLine());
        
        int[] tabla = new int[num+1];
        
        if(num<12){
            System.err.printf("Error, introduzca numero mayor que 12%n");
            System.exit(0);
        }
        else{
            for(int i=0; i<num ; i++){
                tabla[i] = num * (i+1);
            }
            
            System.out.printf("Tabla de multiplicar del %d: %n",num);
            for (int i = 0; i < num; i++) {
                 System.out.printf(tabla[i] + "\n");
            }
            
        }//End of if-else
    }
    
}
