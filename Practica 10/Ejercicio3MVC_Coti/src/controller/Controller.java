/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Partido;
import data.Model;

public class Controller {
    
    Model m = new Model();

    public int getNumPartidos() {
        return m.getNUMMatch();
    }

    public Partido[] getPartidos() {
        return m.getMatches();
    }

    public void storeResultadoIntoModel(String resultado) {
        m.setResultado(resultado);
    }
    
}
