/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pgina27
 */
public class Model {
    private int NUM_PARTIDOS = 3;
    private Partido[] partidos = new Partido[NUM_PARTIDOS];
    private String nombreDelArchivo = "equipos.txt";
    private String nombreDeLaCarpeta = "datos";
    
    public Model(){
        for(int i=0; i<NUM_PARTIDOS; i++){
            this.partidos[i]=new Partido();
        }
    }
    
    public int getNUM_PARTIDOS(){
        return NUM_PARTIDOS;
    }

    /**
     * @param NUM_PARTIDOS the NUM_PARTIDOS to set
     */
    public void setNUM_PARTIDOS(int NUM_PARTIDOS) {
        this.NUM_PARTIDOS = NUM_PARTIDOS;
    }

    /**
     * @return the partidos
     */
    public Partido[] getPartidos() {
        return partidos;
    }

    /**
     * @param partidos the partidos to set
     */
    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }

    /**
     * @return the nombreDelArchivo
     */
    public String getNombreDelArchivo() {
        return nombreDelArchivo;
    }

    /**
     * @param nombreDelArchivo the nombreDelArchivo to set
     */
    public void setNombreDelArchivo(String nombreDelArchivo) {
        this.nombreDelArchivo = nombreDelArchivo;
    }

    /**
     * @return the nombreDeLaCarpeta
     */
    public String getNombreDeLaCarpeta() {
        return nombreDeLaCarpeta;
    }

    /**
     * @param nombreDeLaCarpeta the nombreDeLaCarpeta to set
     */
    public void setNombreDeLaCarpeta(String nombreDeLaCarpeta) {
        this.nombreDeLaCarpeta = nombreDeLaCarpeta;
    }
    
    public void setNameOfLocalTeam(int numPartido, String nombreDelEquipoLocal){
        this.partidos[numPartido].setEquipoLocal(nombreDelEquipoLocal);
    }
    
    public void setNameOfVisitorTeam(int numPartido, String nombreDelEquipoVisitante){
        this.partidos[numPartido].setEquipoVisitante(nombreDelEquipoVisitante);
    }
    
    public void setScoreOfLocalTeam (int numPartido, int golesDelEquipoLocal){
        this.partidos[numPartido].setGolesLocal(golesDelEquipoLocal);
    }
    
    public void setScoreOfVisitorTeam (int numPartido, int golesDelEquipoVisitante){
        this.partidos[numPartido].setGolesVisitante(golesDelEquipoVisitante);
    }  
    
    public void calculateResults(){
        for (Partido p : this.partidos){
            p.calcularResultado();
        }
    }
    
    public String[][] getNamesOfTeam(){ //Devolvemos en forma de tabla los nombres de los equipos Locales y Visitantes
        String[][] tmp = new String [this.NUM_PARTIDOS][2];
        
        for(int i=0; i<this.NUM_PARTIDOS;i++){
            tmp[i][0] = this.partidos[i].getEquipoLocal();
            tmp[i][1] = this.partidos[i].getEquipoVisitante();
        }
        return tmp;
    }
    //Se podrian devolver tambien los goles con un metodo getGoalsOfTeam
    public String [] getResultsOfMatches(){
        String[] tmp = new String [this.NUM_PARTIDOS];
        for(int i=0; i<this.NUM_PARTIDOS; i++){
            tmp[i] = partidos[i].getResultado();
        }
        return tmp;
    }

}