/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        int n,i,j;
        int suma = 0;
        Scanner sc = new Scanner(System.in);
    
        System.out.println("Introduzca un numero aleatorio n para mostrar su sucesión (1...n): ");
        n = Integer.parseInt(sc.nextLine());
        
        int[] suc = new int[n+1];
        
        if(n<=1){
            System.err.printf("Error, introduzca numero positivo%n");
            System.exit(0);
        }
        else{
            j=0;
            for(i=1; i<n ; i++){
                if((i%3)==0 || (i%5)==0){
                    suc[j] = i;
                    j++;
                } 
            }
           System.out.printf("Numeros de 1 a %d: %n",n);
           for (i = 0; i < j ; i++) {
                System.out.printf(suc[i] + "\t");
           } 
           
           for (i = 0; i < j ; i++) {
                suma += suc[i];
           }
        
           System.out.printf("%nLa suma es %d%n",suma);
        }//End of if-else
        
        
    }
    
}
