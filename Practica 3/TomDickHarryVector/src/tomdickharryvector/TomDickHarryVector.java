/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tomdickharryvector;

import java.util.Scanner;

public class TomDickHarryVector {

    public static void main(String[] args) {
        final String[] nombres = {"Tom", "Dick", "Harry"};
        float[] pesos = new float[nombres.length];
        double[] tallas = new double[nombres.length];
        Scanner sc = new Scanner(System.in);
        int indicePesoMax, indiceTallaMax;
        float pesoMax;
        double tallaMax;
        
        System.out.println("TOM, DICK, HARRY");
        for(int i=0; i<pesos.length;i++){
            System.out.println("Escriba los datos de "+nombres[i]+": ");
            System.out.printf("Peso: ");
            pesos[i]= sc.nextFloat();
            System.out.printf("Talla: ");
            tallas[i]= sc.nextDouble();
            System.out.println("\n");
        }
        
        pesoMax = pesos[0];
        tallaMax = tallas[0];
        indicePesoMax = 0;
        indiceTallaMax = 0;
        
        for(int i=0;i<pesos.length;i++){
            if(pesoMax < pesos[i]){
                indicePesoMax = i;
                pesoMax = pesos[i];
            }
            if(tallaMax < tallas[i]){
                indiceTallaMax = i;
                tallaMax = tallas[i];
            }
        }
        
        System.out.println(nombres[indicePesoMax]+" es el que más pesa, con "+pesoMax+" kilos");
        System.out.println(nombres[indiceTallaMax]+" es el mas alto, midiendo "+tallaMax+" metros");
    }
    
}
