/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plenoalquince;

import java.util.Scanner;

public class PlenoAlQuince {

    public static void main(String[] args) {
        final int NUM_PARTIDOS = 3;
        String[] equipoLocal = new String[NUM_PARTIDOS];
        String[] equipoVisitante = new String[NUM_PARTIDOS];
        int[] golesEquipoLocal = new int[NUM_PARTIDOS];
        int[] golesEquipoVisitante = new int[NUM_PARTIDOS];
        Scanner sc = new Scanner(System.in);
        
        
        for(int i=0; i<NUM_PARTIDOS; i++){
            System.out.printf("----Partido nº %2d----%n", i);
            System.out.println("Nombre del equipo local: ");
            equipoLocal[i] = sc.nextLine();
            System.out.println("Nombre del equipo visitante: ");
            equipoVisitante[i] = sc.nextLine();
            System.out.println("Goles del equipo local: ");
            golesEquipoLocal[i] = Integer.parseInt(sc.nextLine());
            System.out.println("Goles del equipo visitante: ");
            golesEquipoVisitante[i] = Integer.parseInt(sc.nextLine());
        }
        
        
        //Impresion de resultados
        
        String formato = "| %2d| %-30s | %3s |%n";
        String resultado;
        int local, visitante;
        String equipos;
        System.out.println();
        for (int i = 0; i < NUM_PARTIDOS; i++) {
            local = golesEquipoLocal[i];
            visitante = golesEquipoVisitante[i];
            equipos = equipoLocal[i] + " - " + equipoVisitante[i];
            resultado = local > visitante ? "1" :
                    (local < visitante ? "2" : "X");
            System.out.printf(formato, i+1, equipos, resultado);
        }
    } 
}
