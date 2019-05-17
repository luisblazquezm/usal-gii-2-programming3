/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perasmanzanasvector;

import java.util.Scanner;

public class PerasManzanasVector {

    public static void main(String[] args) {
      final float IVA = 0.04f;
      
      String[] frutas = {"manzanas","peras"};
      
      float[] numeroDeKilos = new float[frutas.length];
      float[] precioPorKilo = new float[frutas.length];
      float totalSinIVA = 0.0f, valorDelIVA, totalConIVA;
      Scanner sc = new Scanner(System.in);
      
      for(int i=0;i<frutas.length;i++){
          System.out.println("Nº de kilos de "+frutas[i]+" :");
          numeroDeKilos[i] = sc.nextFloat();
          System.out.println("Precio de "+frutas[i]+" :");
          precioPorKilo[i] = sc.nextFloat();
          System.out.println("\n");
      }
      
      for(int i=0; i<frutas.length; i++){
          totalSinIVA += numeroDeKilos[i] * precioPorKilo[i];
      }
      valorDelIVA = totalSinIVA * IVA;
      totalConIVA = totalSinIVA + valorDelIVA;
      
      System.out.println("RESULTADOS");
      System.out.println("==========");
      System.out.println("Coste sin IVA : "+totalSinIVA);
      System.out.println("Importe del IVA : "+valorDelIVA);
      System.out.println("Importe total : "+totalConIVA);

    }
    
}
