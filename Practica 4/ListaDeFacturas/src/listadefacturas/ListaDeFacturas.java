/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listadefacturas;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaDeFacturas {

    public static void main(String[] args) {
        File f = new File("datos.txt");
        Path p = f.toPath();                 //Ruta del fichero f
        List<String> datos = null;
        Scanner sc = new Scanner(System.in);
        
        //Lectura de datos
        
        try{
            datos = Files.readAllLines(p);   //Lee entero el fichero cuya ruta es p
        } catch (IOException ex) {
            Logger.getLogger(
                    ListaDeFacturas.class.getName()).log(Level.SEVERE,
                    null, ex);
            System.err.println("Fatal: no fue"
                    + " posible leer las facturas");
            System.exit(1);                 //Sale del programa
        }
        
        int numeroDeFacturas = datos.size();
        String[] nombre = new String[numeroDeFacturas];
        String[] apellidos = new String[numeroDeFacturas];
        String[] DNI = new String[numeroDeFacturas];
        String[] telefono = new String[numeroDeFacturas];
        
        float[] importe = new float[numeroDeFacturas];
        float[] IVA = new float[numeroDeFacturas];
        float[] descuento = new float[numeroDeFacturas];
        
        //String fragmentos = lista.get(1).split("\t")
        //Cada fragmento es algo de un archivo de texto a leer y separado
        //fragmentos[0] = "Jose"
        //fragmentos[1] = "Garcia"
        //fragmentos
        
        String[] fragmentos;
        for(int i=0; i<numeroDeFacturas; i++){
            if(datos.get(i).isEmpty()){        //Si no hay nada en el archivo (esta vacio) se sale del progrma
                continue;
            }
            fragmentos = datos.get(i).split("\t"); //Split pide que se ignore el \t en el fichero y no se meta dentro de la lista de datos
            nombre[i] = fragmentos[0];
            apellidos[i] = fragmentos[1] + " " + fragmentos[2];
            DNI[i] = fragmentos[3];
            telefono[i] = fragmentos[4];
            importe[i] = Float.parseFloat(fragmentos[5]);
            IVA[i] = Float.parseFloat(fragmentos[6]);
            descuento[i] = Float.parseFloat(fragmentos[6]);
        }//End of for
     
        
        System.out.printf("¿Por encima de que importe "
                + " deben mostrarse las facturas? ");
        float importeMin = sc.nextFloat();
        
        System.out.printf("%n%nTABLA GENERAL%n%n");
        String formato = "| %20s | %25s | %10s | %10s | %8.2f |%n";
        
        for (int i = 0; i < numeroDeFacturas; i++) {
            System.out.printf(formato,
                    nombre[i],
                    apellidos[i],
                    DNI[i],
                    telefono[i],
                    importe[i],
                    IVA[i],
                    descuento[i]);
        }//End of for
    }//End of main
    
}//End of class
