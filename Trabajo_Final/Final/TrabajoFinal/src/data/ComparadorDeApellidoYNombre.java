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
public class ComparadorDeApellidoYNombre implements Comparator<Cliente> {

    @Override
    public int compare(Cliente c1, Cliente c2) {
        int resultado =  c1.getApellido().compareTo(c2.getApellido());
        if (resultado != 0 ) {
            return resultado;
        } else {
            return c1.getNombre().compareTo(c2.getNombre());
        }
    }
    
}
