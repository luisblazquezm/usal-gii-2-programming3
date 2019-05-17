/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discosdurosnb;

import view.View;
/**
 *
 * @author pgina27
 */
public class DiscosDurosNB {

    public static void main(String[] args) {
        
        String menu = "\n0.- Dar valores"
                + "\n1.- Importar"
                + "\n2.- Ordenar"
                + "\n3.- Ver Listado"
                + "\n4.- Exportar"
                + "\nq.- Salir\n"
                + "\nSELECCION:";
        
        View v = new View();
        v.runMenu(menu);
    }
    
}
