/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajofinal;

import java.io.FileNotFoundException;
import view.View;
/**
 *
 * @author Luis
 */
public class TrabajoFinal {

    public static void main(String[] args) throws FileNotFoundException {
        View v = new View();
        v.runMenu("\n1.- Archivos"
                + "\n2.- Clientes"
                + "\n3.- Resultados"
                + "\n4.- Listados"
                + "\n5.- Ventas"
                + "\nq.- Salir"
                + "\nSELECCION");
    }
    
}
