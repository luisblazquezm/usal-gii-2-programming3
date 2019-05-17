/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pgina27
 */
public class Model {

    private final Factura[] lista = new Factura[10];
    
    public void giveRandomValuesToList() {
        for (int i = 0; i < this.lista.length; i++) {
            lista[i] = Factura.instanceWithRandomAttributes();
        }
    }

    public Factura[] getLista() {
        return this.lista;
    }

    
}
