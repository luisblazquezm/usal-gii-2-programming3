/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import data.Model;
/**
 *
 * @author pgina27
 */
public class Controller {
    private final Model m = new Model();
    
    public void darValores(int numValores) {
        m.giveRandomValuesToList(numValores);
    }
    
    public List<String> obtenerListado() {
        
        return m.getListOfItemsAsColumns();
        
    }

    public void ordenarPor(String opcion) {
        m.sortBy(opcion);
    }  
}//End of Controller
