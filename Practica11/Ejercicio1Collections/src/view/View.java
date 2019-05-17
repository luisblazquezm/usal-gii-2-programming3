/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.Scanner;
/**
 *
 * @author pgina27
 */
public class View {

    private final Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in);
    
    public void runMenu(String menu) {
        boolean salir = false;
        do{
            System.out.printf("%s:",menu);
            //opcion = readString_ne(menu).toLowerCase();
            String opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.darValores();
                    break;
                case "2":
                    this.mostrarListado();
                    break;
                case "3":
                    salir = this.preguntarSiSalimos();
                    break;
                default:
                    System.out.printf("%n%nOpcion incorrecta%n%n");
                    break;
                        
            }
        }while(!salir);
    }

    private boolean preguntarSiSalimos() {
        String opcion;
        do{
            System.out.printf("%nDesea salir de la aplicacion [s/N]?: ");
            opcion = sc.nextLine();
        }while(!"sSnN".contains(opcion));
        
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }

    private void darValores() {
        
        c.darValores();
        System.out.printf("%nSe han almacenado %d valores en la lista%n",c.getNumValores());
    }

    private void mostrarListado() {
        String[] listado = c.obtenerListado();
        if(null == listado){
            System.err.printf("ERROR, no fue posible obtener el listado");
            return;
        }
        else{
            System.out.printf("%nListado de Facturas%n%n");
            for(String s : listado){
                System.out.printf("%s%n", s);
            }
            System.out.printf("%n");
        }
    }
    
}
