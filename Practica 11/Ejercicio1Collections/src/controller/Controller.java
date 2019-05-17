/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Factura;
import data.Model;
/**
 *
 * @author pgina27
 */
public class Controller {

    private final Model m = new Model();
    
    public void darValores() {
        m.giveRandomValuesToList();
    }

    public int getNumValores() {
        return m.getLista().length;
    }

    public String[] obtenerListado() {
        if(null == m.getLista()){
            return null;
        }
        
        String[] temp = new String[m.getLista().length];
        for (int i = 0; i < temp.length; i++) {
            Factura[] listaFacturas = m.getLista();
            temp[i] = listaFacturas[i].exportStateAsColumns();
        }
        return temp;
    }
    
}
