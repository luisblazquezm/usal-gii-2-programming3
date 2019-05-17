/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import controller.Controller;
import java.io.IOException;
/**
 *
 * @author pgina27
 */
public class View {
    
    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);

    public void runMenu(String menu) {
        String opcion;
        boolean salir = false;
        do{
            System.out.printf("%s:", menu);
            opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "0": this.darValores();   break;
                case "1": this.importar();     break;
                case "2": this.mostrarListadoOriginal();   break;
                case "3": this.verListado();               break;
                case "4": this.exportar();                 break;
                case "q": salir = this.preguntarSiSalimos(
                        "Desea realmente salir de la aplicacion?");  
                        break;
                default:  
                    System.out.printf("%n%nOpcion incorrecta%n%n");
                
            }
        }while(!salir);
    }

    private boolean preguntarSiSalimos(String prompt) {
        String opcion;
        do{
            System.out.printf(prompt);
            opcion = sc.nextLine();
        }while("sSnN".contains(opcion));
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void darValores() {
        c.darValores();
        System.out.printf("%n%nSe ha construido una lista formada por %d elementos.%n%n",c.getNumeroDeElementos());
    }

    private void importar() {
        try{
            c.importar();
        }catch(IOException ex){
            System.out.printf("%nERROR no fue posible importar datos%n");
            System.err.printf("%nERROR: %s",ex.toString());
            return;
        }
        
        System.out.printf("%n%nSe ha importado una lista formada por %d elementos.%n%n",c.getNumeroDeElementos());
    }

    private void exportar() {
        try{
            c.exportar();
        } catch(IOException ex){
            System.out.printf("%nERROR no fue posible importar datos%n");
            System.err.printf("%nERROR: %s",ex.toString());
        }
    }
    
    private void verListado() {
        String[] listado = c.obtenerListado();
        
        if(null == listado){
            System.err.printf("%n%nLista vacia - Por favor de valores a la lista%n%n");
            return;
        }
        System.out.println();
        System.out.printf("%nListado de discos durso%n");
        
        for(String s : listado){
            System.out.println(s);
        }
    }
    
    private void mostrarListadoOriginal() {
        boolean salir = false;
        
        do{
            System.out.printf(
                    "%n%nORDENAR por:" 
                            + "%n1.- Fabricante" 
                            + "%n2.- Megabytes" 
                            + "%n3.- Modelo" 
                            + "%n4.- Numero de serie" 
                            + "%n5.- Tasa de transmision"
                            + "%n6.- Tecnologia"
                            + "%n7.- Tipo de Interface"
                            + "%n8.- Velocidad de Rotación"
                            + "%nq.- FIN ORDENAR"
                            + "%nSELECCION:");
            
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                case "7":
                case "8":
                    c.ordenarPor(opcion);
                    verListado();
                    break;
                case "q":
                    salir = preguntarSiSalimos("Desea realmente volver al menu principal?");
                    break;
                default:
                    System.out.printf("%n%nNo es posible ordenar por ese campo%n%n");
                    break;
            }
        }while(!salir);
    }
    
}
