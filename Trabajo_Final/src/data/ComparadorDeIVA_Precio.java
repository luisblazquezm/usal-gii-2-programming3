/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;

/**
 *
 * @author Luis
 */
public class ComparadorDeIVA_Precio implements Comparator<Producto> {

    @Override
    public int compare(Producto p1, Producto p2) {
        int resultado =  Float.compare(p1.getIVA(), p2.getIVA());
        if (resultado != 0 ) {
            return resultado;
        } else {
            return Float.compare(p1.getPrecio(), p2.getPrecio());
        }
    }
    
}
