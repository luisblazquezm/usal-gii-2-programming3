/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordefacturas;

/**
 *
 * @author Miguel
 */
public class Item {
    String concepto;
    float precio;
    int cantidad;
    public Item(String concepto,float precio,int cantidad){
    this.concepto=concepto;
    this.cantidad=cantidad;
    this.precio=precio;
    }

    public String getConcepto() {
        return concepto;
    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
    
}
