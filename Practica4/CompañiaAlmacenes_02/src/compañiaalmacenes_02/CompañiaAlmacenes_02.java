
package compañiaalmacenes_02;

import java.util.Scanner;

public class CompañiaAlmacenes_02 { //Lo primero Clic derecho Clase(taza)/Propiedades/Ejecutar o RUn/Poner 10 (1) y 10 (2) separados por espacios en blanco
final static int NUM_ALMACENES = 5;
final static int NUM_PRODUCTOS = 2;
                                            //No meter cadenas en nºs
    public static void main(String[] args) {//El vector de argumentos tiene 10 1 y 10 2 que he metido
       float [][] ventas = new float [NUM_ALMACENES][NUM_PRODUCTOS];
       float [][] precios = new float [NUM_ALMACENES][NUM_PRODUCTOS];
       float [] b = new float[NUM_ALMACENES];
       float bTotal = 0;
       Scanner sc = new Scanner(System.in);
       
       if (NUM_ALMACENES * NUM_PRODUCTOS * 2 != args.length){//Args.length = 20 que son 10 1 y 10 2
           System.err.printf(("Se necesitan %d datos pero se han recibido %d%n"),
                   NUM_ALMACENES * NUM_PRODUCTOS * 2 ,args.length);
           System.err.printf("%n%nSaliendo...%n%n");
           System.exit(0);//Como el return 0 para acabar la ejecucion
       }
       
       int n = 0;
       for(int i=0; i<NUM_ALMACENES; i++){ 
           for(int j=0; j<NUM_PRODUCTOS; j++){
               ventas[i][j]= Float.parseFloat(args[n++]);//args[0] es el primer 1 hasta el ultimo 1 en args[9]
           }
       }
       
       for(int i=0; i<NUM_ALMACENES; i++){ 
           for(int j=0; j<NUM_PRODUCTOS; j++){
               precios[i][j]= Float.parseFloat(args[n++]);//args[10] es el primer 2 hasta el ultimo 2 en args[19]
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
