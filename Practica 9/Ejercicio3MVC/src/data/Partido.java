/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;


public class Partido {
    private String resultadoPartido;
    private Equipo team1;
    private Equipo team2;

    public Partido(Equipo equipo1,Equipo equipo2,String result) {
        this.team1 = equipo1;
        this.team2 = equipo2;
        this.resultadoPartido = result;
    }    

    public Partido() {
    }
    public Equipo getTeam1(){
        return this.team1 ;
    }
    
    public Equipo getTeam2(){
        return this.team2;
    }
    
    public String getResultMatch(){
        return this.resultadoPartido;
    }

    
    
}
