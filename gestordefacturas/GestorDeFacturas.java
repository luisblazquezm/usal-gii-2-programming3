/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordefacturas;

import java.io.IOException;

/**
 *
 * @author Miguel
 */
public class GestorDeFacturas {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Vista v=new Vista();
        v.Menu("1)Leer items"+"2)Mostrar factura"+"S)Salir");
    }
    
}
