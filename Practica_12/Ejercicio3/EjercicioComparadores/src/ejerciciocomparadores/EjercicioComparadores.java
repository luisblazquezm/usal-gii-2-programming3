/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciocomparadores;

import view.View;
/**
 *
 * @author pgina27
 */
public class EjercicioComparadores {

    public static void main(String[] args) {
        if(args.length < 2){
            System.out.println("Usage: java ficheroNB #fichas");
            System.out.println("o bien");
            System.out.println("Usage: java -jar program.jar #fichas.");
        }
        try{
            int m = Integer.parseInt(args[0]);
        }catch(Exception e){
            System.out.printf("%n%nERROR: numero de elementos incorrecto%n%n");
            System.out.println("Usage: java ficheroNB #fichas");
            System.out.println("o bien");
            System.out.println("Usage: java -jar program.jar #dichas");
            return;
        }
        
        System.out.printf("Fichas de Alumno%n%n");
        View v = new View();
        v.runMenu("\n1.- Dar valores" 
                + "\n2.- Mostrar lista" 
                + "\n3,- Mostrar listado ordenado" 
                + "\n4.- Salir",args);//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<OJO
    }
    
}
