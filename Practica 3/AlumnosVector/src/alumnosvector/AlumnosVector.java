/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnosvector;

import java.util.Scanner;

public class AlumnosVector {

    public static void main(String[] args) {
        final int NUM_ALUMNOS = 4;
        final int NUM_PARCIALES = 3;
        final Scanner sc = new Scanner(System.in);
        
        float[][] notas = new float[NUM_ALUMNOS][NUM_PARCIALES];
        float[] medias = new float[NUM_ALUMNOS];
        
        float acumuladorDeParciales;
        
        for(int alumno = 0; alumno < NUM_ALUMNOS; alumno++){
            System.out.printf("%nAlumno nº %d: %n%n",alumno+1);
            for(int parcial = 0; parcial <NUM_PARCIALES;parcial++){
                System.out.printf("Nota del parcial %d: ",parcial+1);
                notas[alumno][parcial] = sc.nextFloat();
            }
        }
        
        for(int alumno = 0; alumno < NUM_ALUMNOS; alumno++){
            acumuladorDeParciales = 0.0f;
            for(int parcial = 0;parcial < NUM_PARCIALES;parcial++){
                acumuladorDeParciales += notas[alumno][parcial];
            }
            medias[alumno] = acumuladorDeParciales / NUM_PARCIALES;
        }
        
        System.out.printf("|%18s|%6s|", "NOTAS", "MEDIA");
        for(int i=0;i < NUM_ALUMNOS;i++){
            for(int j=0;j < NUM_PARCIALES; j++){
                System.out.printf("|%6.2f|", notas[i][j]);
            }
            System.out.printf("|%6.2f|%n", medias[i]);
        }
    }
    
}
