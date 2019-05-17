/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sucesiondenumeros;

import java.util.Scanner;

public class SucesionDeNumeros {
    
    public static void main(String[] args){
        int n,j = 0;
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
            for(int i=n; i>0 ; i--){
                suc[i] = i;
            }
            
            System.out.printf("Numeros de 1 a %d: %n",n);
            for (int i = 1; i < n+1; i++) {
                 System.out.printf(suc[i] + "\t");
            }
         
            for (int i = 1; i < n+1; i++) {
                suma += suc[i];
            }
        
            System.out.printf("%nLa suma es %d%n",suma);
        }//End of if-else
 
    }  
}
