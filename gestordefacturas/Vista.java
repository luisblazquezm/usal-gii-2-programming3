/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordefacturas;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Miguel
 */
public class Vista {
    Controlador c=new Controlador();
    Scanner sc=new Scanner(System.in);
    public void Menu(String menu) throws IOException{
    String opcion;
    int salir=0;
    while(salir!=1){
    System.out.println(menu);
    opcion=sc.nextLine();
    switch(opcion){
        case "1":
            System.out.println("Leyendo items...");
            c.leer();
            break;
        case "2":
            this.mostrar();
            break;
        case "S":
        case "s":
            salir=this.salir();
            break;
        default:
            System.out.println("Opcion incorrecta");
    }
    }
    }
    public void mostrar(){
    Factura[]facturas=c.mostrar();
    String concepto="CONCEPTO";
    String cantidad="CANTIDAD";
    String precio="PRECIO/UNIDAD";
    String total="PRECIO";
    String li=String.format("%-20s%-10s%-20s%-10s",concepto,cantidad,precio,total);
    System.out.println(li);
    for(Factura f:facturas){
        for(Item ite:f.getI()){
            System.out.printf("%-20s%-10d%-20.2f%-10.2f%n",ite.getConcepto(),ite.getCantidad(),ite.getPrecio(),(float)ite.getCantidad()*ite.getPrecio());
        }
    System.out.println();
    }
    
    }
    
    public int salir(){
    String op;
    System.out.printf("¿Desea realmente salir?: ");
    op=sc.nextLine();
    if(op.contains("S")||op.contains("s")){
    return 1;
    }
    return 0;
    }
    
    
}
