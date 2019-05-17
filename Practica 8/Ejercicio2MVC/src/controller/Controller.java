/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Model;

public class Controller {
    
    Model m = new Model();
    
    public void calcularResults(){
        int NUM_ALM = this.getNumAlmacenes();
        int NUM_PRODS = this.getNumProductos();
        float[][] ventas = this.getTableOfSales();
        float[][] precios = this.getTableOfPrices();
        float [] tmp = new float[NUM_ALM];
        float beneficios = 0;
        
        for (int i = 0; i < NUM_ALM; i++) {
            for (int j = 0; j < NUM_PRODS; j++) {
                tmp[i] = ventas[i][j] * precios[i][j];
                beneficios+=tmp[i];
            }
        }
        
        m.setResults(beneficios);  
    }//End of calcularResults
    
    public int getNumAlmacenes(){
        return m.getNUMBER_OF_STORES();
    }//End of getNumAlmacenes
      
    public int getNumProductos(){
        return m.getNUMBER_OF_PRODUCTS();
    }//End of getNumProductos
    
    public void storeIntoModelSales(float[][] tempVentas){
        m.setSales(tempVentas);
    }//End of storeIntoModelSales
    
    public void storeIntoModelUnitPrices(float[][] tempPrecios){
        m.setPrices(tempPrecios);
    }//End of storeIntoModelUnitPrices
    
    public float[][] getTableOfPrices(){
        return m.getTableOfPrices();
    }//End of getTableOfPrices
    
    public float[][] getTableOfSales(){
        return m.getTableOfSales();
    }//End of getTableOfSales
    
    public float getResults(){
        return m.getResults();
    }//End of getResults
}
