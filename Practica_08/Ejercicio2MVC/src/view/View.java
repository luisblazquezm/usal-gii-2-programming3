/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.Scanner;

public class View {

    Scanner sc = new Scanner(System.in);
    Controller c = new Controller();
 
    public void runMenu(String menu) {
        
        boolean salir = false;
        
        do{
            System.out.printf("%s:", menu);
            String opcion = sc.nextLine();
            switch(opcion){
                case "1":
                   this.leerTablaDeVentas();
                   break;
                case "2":
                   this.leerTablaDePrecios();
                   break;
                case "3":
                   this.calcularIngresos();
                   break;
                case "4":
                   this.mostrarResultados();
                   break;
                case "5":
                    this.preguntarSiSalimos();
                    break;
                default:
                   System.out.printf("%n%nOpcion Incorrecta%n%n");
                   break;
            }       
        }while(!salir); 
    }//End of runMenu
    
    private boolean preguntarSiSalimos(){
        String opcion;
        do{
            System.out.printf("%nDesea realmente salir" 
                    + " de la aplicacion? [s/N]");
            opcion = sc.nextLine();
        } while(!"sSnN".contains(opcion));//Mientras la opcion s/S o n/N no sea igual que la opcion
        System.out.println();
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }//End of preguntarSiSalimos

    private void leerTablaDeVentas(){
        int NUM_ALM = c.getNumAlmacenes();
        int NUM_PROD = c.getNumProductos();
        float[][] ventas = new float[NUM_ALM][NUM_PROD];
        
        for (int i = 0; i < NUM_ALM; i++) {
            for (int j = 0; j < NUM_PROD; j++) {
                System.out.printf("VENTAS " +
                                  " Almacen[%d]-->Producto[%d]: ",i+1,j+1);
                ventas[i][j]=sc.nextFloat();
            }
        }
        
        c.storeIntoModelSales(ventas);
    }//End of leerTablaDeVentas

    private void leerTablaDePrecios(){
        int NUM_ALM = c.getNumAlmacenes();
        int NUM_PROD = c.getNumProductos();
        float[][] precios = new float[NUM_ALM][NUM_PROD];
        
        for (int i = 0; i < NUM_ALM; i++) {
            for (int j = 0; j < NUM_PROD; j++) {
                System.out.printf("PRECIOS " +
                                  " Almacen[%d]-->Producto[%d]: ",i+1,j+1);
                precios[i][j]=sc.nextFloat();
            }
        }
        
        c.storeIntoModelUnitPrices(precios);
    }//End of leerTablaDePrecios

    private void calcularIngresos(){        
        c.calcularResults();
        
        System.out.printf("%n%nIngresos totales calculados%n%n");
        
    }//End of calcularIngresos

    private void auxShowTable(float[][] t){
        
    }//End of auxShowTable
    
    private void mostrarResultados(){
       int NUM_ALM = c.getNumAlmacenes();
       int NUM_PROD = c.getNumProductos();
       float[][] precios = c.getTableOfPrices();
       float[][] ventas = c.getTableOfSales();
       float resultado = c.getResults();
       
       System.out.printf("| %12s | %12s | %8s | %8s |%n","NUM_ALMACEN","NUM_PRODUCTO",
               "PRECIOS","VENTAS");
       for (int i = 0; i < NUM_ALM; i++) {
            for (int j = 0; j < NUM_PROD; j++) {
               System.out.printf("| %12d | %12d | %8.2f | %8.2f |%n", i+1,j+1,
                       precios[i][j],ventas[i][j]);
           }
        }
       
       System.out.printf("%n%nEl beneficio total es de %.2f%n%n",resultado);
    }//End of mostrarResultados
        
}//End of View Class
