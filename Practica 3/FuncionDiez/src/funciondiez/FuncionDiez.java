/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciondiez;

import java.util.Scanner;

public class FuncionDiez {

    public static void main(String[] args) {
      int[] numGoles = new int[10];
      Scanner sc = new Scanner(System.in);
      float goalAverage = 0.0f;
      
      System.out.println("Introduzca los datos de los goles por partdio:\n");
      
      for(int i=0;i<numGoles.length;i++){
          System.out.println("Goles del Partido "+ (i+1) +":");
          numGoles[i] = sc.nextInt();
      }
      
      for(int i=0;i<numGoles.length;i++){
          goalAverage+=numGoles[i];
      }
      
      goal.Average /= numGoles.length;
      
      System.out.println("La media de los "+numGoles.length+" partdios es "+goalAverage);
    }
    
}
