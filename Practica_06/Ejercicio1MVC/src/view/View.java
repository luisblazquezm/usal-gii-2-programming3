/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.Scanner;

public class View {
    
    Scanner sc = new Scanner(System.in);
    Controller c = new Controller();

    public void runMenu(String menu) {
        /*
        Importar,Mostrar,Salir
        */
        boolean salir = false;
        do{
            System.out.printf("%s:",menu);
            String opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.importarArchivo();
                    break;
                case "2":
                    this.mostrarDatos();
                    break;
                case "3":
                    salir = this.preguntarSiSalimos();
                    break;
                default:
                    System.out.printf("%n%nOpcion Incorrecta%n%n");
                    break;
            }//End of switch
        }while(!salir);
    }//End of runMenu()
    
    private boolean preguntarSiSalimos(){
        String opcion;
        do{
            System.out.printf("%nDesea realmente salir" 
                    + " de la aplicacion? [s/N]");
            opcion = sc.nextLine();
        } while(!"sSnN".contains(opcion));//Mientras la opcion s/S o n/N no sea igual que la opcion
        System.out.println();
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }//End of preguntarSiSalimos
    
    private void importarArchivo(){
        c.importarArchivo();
        int numPersonas = c.getNumPersonas();
        System.out.printf("%n%nSe han encontrado %d" 
                + " personas.%n%n", numPersonas);
    }//End of importarArchivo
    
    private void mostrarDatos(){
        String tmp = c.getPersonasImportadasComoTabla();
        System.out.printf("%n%nLista de Personas" 
                + " Importadas%n%n%s%n%n", tmp);
    }//End of mostrarDatos

}//End of class
