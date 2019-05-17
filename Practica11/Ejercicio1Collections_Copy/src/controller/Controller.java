/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Factura;
import data.Model;
import java.util.ArrayList;
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
        return m.getLista().size();
    }

    public String[] obtenerListado() {
        if(m.getLista().isEmpty()){
            return null;
        }
        
        String[] temp = new String[this.getNumValores()];
        for (int i = 0; i< temp.length ; i++) {
            ArrayList<Factura> lista = m.getLista();
            temp[i] = m.getLista().get(i).exportStateAsColumns();
        }
        return temp;
    }
    
}
