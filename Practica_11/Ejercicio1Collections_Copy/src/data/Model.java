/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author pgina27
 */
public class Model {
    private final int NUM_FACTURAS = 10;
    private final ArrayList<Factura> lista = new ArrayList<>();
    
    public void giveRandomValuesToList() {
        for (int i = 0; i < this.NUM_FACTURAS; i++) {
            lista.add(Factura.instanceWithRandomAttributes());
        }
    }

    public ArrayList<Factura> getLista() {
        return this.lista;
    }

    
}
