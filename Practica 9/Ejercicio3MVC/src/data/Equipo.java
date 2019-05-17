/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Equipo {
    private String nombre;
    private int goles;
    
    public Equipo(String n,int g){
        this.nombre = n;
        this.goles = g;
    }
    
    public String getName(){
        return this.nombre;
    }
    
    public int getScores(){
        return this.goles;
    }
    
    
    
}
