/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiniela;

/**
 *
 * @author pgina27
 */
public class Quiniela {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View v = new View() {};
        v.runMenu("\n1.-Leer equipos"
                + "\n2.-Leer goles de cada equipo"
                + "\n3.-Calcular resultados"
                + "\n4.-Mostrar resultados"
                + "\n5.-Importar equipos (disco)"
                + "\nq.-Salir")
                
    }
    
}
