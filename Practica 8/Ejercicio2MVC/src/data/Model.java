/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


public class Model {
    
    final int NUMBER_OF_STORES = 5;
    final int NUMBER_OF_PRODUCTS = 4;
    float[][] sales;
    float[][] prices;
    private float results;
    
    public int getNUMBER_OF_STORES(){
        return this.NUMBER_OF_STORES;
    }//End of getNumberOfStores
    
    public int getNUMBER_OF_PRODUCTS(){
        return this.NUMBER_OF_PRODUCTS;
    }//End of getNumberOFProducts
    
    public void setSales(float[][] tempVentas){
        this.sales = tempVentas;
    }//End of setSales
    
    public void setPrices(float[][] tempPrecios){
        this.prices = tempPrecios;
    }//End of setPrices
    
    public float[][] getTableOfPrices(){
        return this.prices;
    }//End of getTableOfPrices
    
    public void setResults(float accumulator){
        this.results = accumulator;
    }//End of setResults
    
    public float[][] getTableOfSales(){
        return this.sales;
    }//End of getTableOfSales
    
    public float getResults(){
        return this.results;
    }//End of getResults
}
