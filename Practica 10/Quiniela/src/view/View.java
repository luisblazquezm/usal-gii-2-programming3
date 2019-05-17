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
    Scanner sc = new Scanner (System.in);
    Controller c = new Controller();
    
/*    public void runMenu(String menu){
        boolean salir = false;
        do{
            System.out.printf("%s: ", menu);
            String opcion = sc.nextLine();
            switch (opcion) {
                System.out.printf("%s:", menu);
                String opcion = sc.nextLine();
                switch (opcion){
                    case "1" this.leerEquipos();
                    case "2" this.LeerResultados();
                    case "3"
            }
            
        }
    }while(!salir);
}*/

/*private boolean preguntarSiSalimos(){
    String opcion;
    do{
        System.out.printf("%nDesea realmente salir" + "de la aplicaicon? [s/n]")
    }
}*/

private void LeerEquipos(){
    final int NUM_PARTIDOS = c.getNumPartido();
    final int NUM_EQUIPOS = 2;
    String[][] tempEquipos = new String [NUM_PARTIDOS][NUM_EQUIPOS];
    System.out.printf("%n%nLectura de Equipos%n%n");
    for(int numPartido=0; numPartido<NUM_PARTIDOS; numPartido++){
        System.out.printf("%n%nEscriba los equipos correspondiientes al partido nº%2d:%n", numPartido+1);
    }
    for(int numEquipo=0; numEquipo<NUM_EQUIPOS; numEquipo++){
        System.out.printf(numEquipo==0? "Equipo local: " : "Equipo Visitante: ");
        tempEquipos[numPartido][numEquipo] = sc.nextLine();
    }
    c.storeIntoModelTeams(tempEquipos);
}

c.storeIntoModelTeams(tempEquipos);

private void leerMarcadores(){
    final int NUM_PARTIDOS = c.getNumPartidos();
    final int NUM_EQUIPOS = 2;
    int[][] tempGoles = new int [NUM_PARTIDOS][NUM_EQUIPOS];
    String[][] equipos = c.getNameOfTeams();
    System.out.printf("%n%nLectura de Goles%n%n");
    for (int numPartido=0; numPartido<NUM_PARTIDOS; numPartido++){
        System.out.printf("%nEscriba los goles del partido nº %2d: (%s)", numPartido+1, equipos[numPartido][0] + "-" + equipos[numPartido][1]);
        for(int numEquipo=0; numEquipo<NUM_EQUIPOS; numEquipo++){
            System.out.printf("%nEscriba los goles del " + (numPartido == 0 ? "Equipo local: " : "Equipo vistitante: "), numPartido);
            tempGoles[numPartido][numEquipo] = Integer.parseInt(sc.nextLine());
        }
    }
    
c.storeIntoModelTeamScores(tempGoles);

}

private void calcularResultados(){
    System.out.printf("%n%nSe han calculado" + "los resultados de los partidos%n%n");
    
}
}

