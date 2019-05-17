/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compañiaalmacenes;

import java.util.Scanner;


public class CompañiaAlmacenes {
final static int NUM_ALMACENES = 5;
final static int NUM_PRODUCTOS = 2;

    public static void main(String[] args) {
       float [][] ventas = new float [NUM_ALMACENES][NUM_PRODUCTOS];
       float [][] precios = new float [NUM_ALMACENES][NUM_PRODUCTOS];
       float [] b = new float[NUM_ALMACENES];
       float bTotal = 0;
       Scanner sc = new Scanner(System.in);
       
       System.out.println("Escriba los datos de ventas por"
               + " almacenes y productos\n");
       for(int i=0; i<NUM_ALMACENES; i++){ //Si pones for y le das a tabulador por detras te hace un for
           for(int j=0; j<NUM_PRODUCTOS; j++){
               System.out.println("Unidades vendidas"
                       + " en el almacen " +i
                       + " del producto "+ j +": ");
               ventas[i][j]= sc.nextFloat();
           }
       }
       
       System.out.println();
       System.out.println("Escriba los precios"
               + " por unidad en almacenes"
               + " y productos\n\n");
       for(int i=0; i<NUM_ALMACENES; i++){ //Si pones for y le das a tabulador por detras te hace un for
           for(int j=0; j<NUM_PRODUCTOS; j++){
               System.out.println("Precio unitario en "
                       + " en el almacen " +i
                       + " del producto "+ j +": ");
               precios[i][j]= sc.nextFloat();
           }
       }
       
        for (int j = 0; j < NUM_ALMACENES; j++) {
            for (int k = 0; k < NUM_PRODUCTOS; k++) {
                    b[j] += ventas[j][k] * precios[j][k];
            }
        }
        
        for (int i = 0; i < NUM_ALMACENES; i++) {
            bTotal += b[i];
        }
        
        System.out.println("\nPrecios por almacenes y productos: ");
        for (int i = 0; i < NUM_ALMACENES; i++) {
            for (int j = 0; j < NUM_PRODUCTOS; j++) {
                System.out.printf("| %8.2f ",precios[i][j]);
            }
            System.out.printf("|%n");
        }
        
        
        System.out.println("\nVentas por almacenes y productos con ingresos: ");
        for (int i = 0; i < NUM_ALMACENES; i++) {
            for (int j = 0; j < NUM_PRODUCTOS; j++) {
                System.out.printf("| %8.2f ",ventas[i][j]);
            }
            System.out.printf("| %12.2f |%n ",b[i]);
        }
        
        System.out.println("\nEl beneficio total es "+ bTotal +" €");
     
    }
    
}
