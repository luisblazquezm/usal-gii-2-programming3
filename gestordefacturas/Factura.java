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
public class Factura {
    Item[] i;

    public Item[] getI() {
        return i;
    }

    public Factura(Item[] i){
    this.i=i;
    }
}
