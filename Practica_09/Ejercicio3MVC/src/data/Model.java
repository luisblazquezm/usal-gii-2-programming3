/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;



public class Model {
    
    //private final int NUM_PARTIDOS=3
    //private Partido[] partidos = new Partido[NUM_PARTIDOS]
    //private final String nombreDelArchivo = "equipos.txt"e
    //private final String nombreDeLaCarpeta = "datos"
    //
    //public Model(){
    // for(int i =0, i<NUM_PARTIDOS;i++)
    //   this.partidos[i] = new Partido();
    //}
    //
    
    int partidos = 3;
    Partido [] match = new Partido[partidos];
    
    public int getNUMMatch() {
        return this.partidos;
    }
    
    public void setNumMATCH(int partidos){
        this.partidos = partidos; 
    }

    public Partido[] getMatches() {
        return this.match;
    }
    
    public void setMatches(Partido[] match){
        this.match = match;     
    }

    
}
