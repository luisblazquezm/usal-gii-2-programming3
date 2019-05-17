/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pgina27
 */
public class View {
    private Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);

    public void runMenu(String menu, String[] args) {
        String opcion;
        boolean salir = false;
        
        do{
            System.out.printf("%s:",menu);
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.darValores(Integer.parseInt(args[0]));
                    System.out.printf("%n%nLa lista tiene datos%n%n");
                    break;
                case "2":
                    this.verListado();
                    break;
                case "3":
                    this.mostrarListadoOrdenado();
                    break;
                case "q":
                    salir = this.preguntarSiSalimos("Desea" 
                            + "realmente salir de la aplicacion?[s/N]");
                    break;
                default:
                    System.out.printf("%n%nOpcion incorrecta%n%n");
            }
        }while(!salir);
    }
    
    private boolean preguntarSiSalimos(String prompt) {
        String opcion;
        do{
            System.out.println(prompt);
            opcion = sc.nextLine();
        }while("sSnN".contains(opcion));
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void verListado() {
        List<String> listado = c.obtenerListado();
        if(listado == null){
            System.err.printf("%n%nLista vacia " 
                    + " Por favor, de valores a la lista%n%n");
            return;
        }
        System.out.println();
        for (String s : listado) {
            System.out.println(s);
        }
        System.out.println();
    }//End of preguntarSiSalimos
    
    private void mostrarListadoOrdenado() {
        boolean fin = false;
        do{
            System.out.printf(//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Submenu de ordenacion
                    "%n%nORDENAR por:" 
                            + "%n1.- DNI" 
                            + "%n2.- Nombre"
                            + "%n3.- Apellidos"
                            + "%n4.- Curso"
                            + "%n5.- Grupo de Practicas" 
                            + "%n6.- Calificacion" 
                            + "%nq.- FIN ORDENAR : --->");
            String opcion = sc.nextLine().toLowerCase();//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
            switch(opcion){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6": c.ordenarPor(opcion); break;
                case "q": fin = true;           break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
            verListado();
        }while(!fin);
    }//End of mostrarListadoOrdenado
    
    private void darValores(int numValores) {
        c.darValores(numValores);
        System.out.printf("%nSe ha creado una lista con %d elementos%n%n",numValores);
    }//End of darValores

    

    
}
