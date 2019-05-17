/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import java.util.Scanner;
import data.Partido;
import data.Equipo;

public class View {
    
    Controller c = new Controller();
    Scanner sc = new Scanner(System.in);
    
    public void runMenu(String menu) {
        boolean salir = false;
        do{
            System.out.printf("%s:",menu);
            String opcion = sc.nextLine();            
            switch(opcion){
                case "1":
                    this.leerEquipos();
                    break;
                case "2":
                    this.mostrarResultados();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void leerEquipos() {
        int NUM_PARTIDOS = c.getNumPartidos();
        Partido[] p = c.getPartidos();
        String nombre1,nombre2;
        int goles1,goles2;
                
        for (int i = 0; i < NUM_PARTIDOS; i++) {

            System.out.printf("%n%n-------PARTIDO(%d)-------%n",i+1);
            System.out.printf("Nombre Equipo 1>> ");
            nombre1=sc.nextLine();
            System.out.printf("Goles Equipo 1>> ");
            goles1 = sc.nextInt();
            System.out.printf("Nombre Equipo 2>> ");
            nombre2=sc.nextLine();
            System.out.printf("Goles Equipo 2>> ");
            goles2 = sc.nextInt();
            
            String resultado =(goles1 + "-" + goles2);
            
            p[i] = new Partido(new Equipo(nombre1,goles1),new Equipo(nombre2,goles2),resultado);
            c.storeResultadoIntoModel(resultado);
        }
    }


    private void mostrarResultados() {
        Partido[] p = c.getPartidos();
        
        
        
    }

    
    
}
