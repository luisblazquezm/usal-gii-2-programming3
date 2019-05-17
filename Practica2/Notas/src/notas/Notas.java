/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notas;

import java.util.Scanner;

public class Notas {

    public static void main(String[] args) {
        float nota_1_p1, nota_1_p2, nota_1_p3;
        float nota_2_p1, nota_2_p2, nota_2_p3;
        float nota_3_p1, nota_3_p2, nota_3_p3;
        float media_1, media_2, media_3;
       
        Scanner sc = new Scanner(System.in);
        
        System.out.printf("%nCalculo de Nota Media%n");
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",1,1);
        String temp;
        temp =  sc.nextLine();
        nota_1_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",1,2);
        temp =  sc.nextLine();
        nota_1_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",1,3);
        temp =  sc.nextLine();
        nota_1_p3 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",2,1);
        temp =  sc.nextLine();
        nota_2_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",2,2);
        temp =  sc.nextLine();
        nota_2_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",2,3);
        temp =  sc.nextLine();
        nota_2_p3 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",3,1);
        temp =  sc.nextLine();
        nota_3_p1 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",3,2);
        temp =  sc.nextLine();
        nota_3_p2 = Float.parseFloat(temp);
        
        System.out.printf("Escriba la nota del alumno %d, parcial %d : ",3,3);
        temp =  sc.nextLine();
        nota_3_p3 = Float.parseFloat(temp);
        
        media_1 = (nota_1_p1 + nota_1_p2 + nota_1_p3)/3 ;
        media_2 = (nota_2_p1 + nota_2_p2 + nota_2_p3)/3 ;
        media_3 = (nota_3_p1 + nota_3_p2 + nota_3_p3)/3 ;
        
        System.out.printf("%nDatos Introducidos%n%n");
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", nota_1_p1, nota_1_p2, nota_1_p3);
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", nota_2_p1, nota_2_p2, nota_2_p3);
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", nota_3_p1, nota_3_p2, nota_3_p3);
        
        System.out.printf("%nMedia%n%n");
        System.out.printf("|%8.2f|%8.2f|%8.2f|%n", media_1, media_2, media_3);
    }
    
}
