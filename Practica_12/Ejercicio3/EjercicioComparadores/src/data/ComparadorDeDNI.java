/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Comparator;

/**
 *
 * @author pgina27
 */
public class ComparadorDeDNI implements Comparator<Ficha> {

    @Override
    public int compare(Ficha o1, Ficha o2) {
        return o1.getDni().compareTo(o2.getDni());
    }
    
}
