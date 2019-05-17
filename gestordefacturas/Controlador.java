/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordefacturas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Controlador {
    Modelo m=new Modelo();
    Scanner sc=new Scanner(System.in);
    public void leer() throws IOException{
    Path ruta=Paths.get("E:\\ProgramacionIII\\MVC\\GestorDeFacturas\\facturas.txt");
    List<String>lineas=Files.readAllLines(ruta);
    String[]fragmentos;
    Factura[]facturas=new Factura[3];
    int j=0;
    Item[]it=new Item[lineas.size()];
    for(int i=0;i<facturas.length;i++){
        j=0;
        for(String s:lineas){
            fragmentos=s.split("@");
            it[j]=new Item(fragmentos[0],Float.parseFloat(fragmentos[2]),Integer.parseInt(fragmentos[1]));
            j++;
        }
            facturas[i]=new Factura(it);
    }
    m.setFacturas(facturas);
    }
   
    public Factura[]mostrar(){
    return m.getFacturas();
    }
    
}
