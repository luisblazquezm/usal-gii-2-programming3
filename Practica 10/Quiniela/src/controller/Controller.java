/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Model;
import data.Partido;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 *
 * @author pgina27
 */
public class Controller {//EL controlador solo puede pedir informacion al modelo. Vista->Controlador->Modelo
    Model m = new Model();
    
    public int getNumPartidos(){
        return m.getNUM_PARTIDOS();
    }
    
    public void storeIntoModelTeams(String[][] tempEquipos){//Metodo invocado por la vista para meter los equipos en el modelo
        for(int numPartido=0; numPartido<this.getNumPartidos(); numPartido++){
            m.setNameOfLocalTeam(numPartido, tempEquipos[numPartido][0]);
            m.setNameOfVisitorTeam(numPartido, tempEquipos[numPartido][1]);
        }
    }
    
    public void storeIntoModelTeamScores(int[][] tempGoles){//En la vista esta almacenado en tablas y en el modelo en un vector
        for(int numPartido=0; numPartido<this.getNumPartidos(); numPartido++){
            m.setScoreOfLocalTeam(numPartido,tempGoles[numPartido][0]);
            m.setScoreOfVisitorTeam(numPartido,tempGoles[numPartido][1]);
        }
    }
    
    public void calculateResults(){
        m.calculateResults();
    }
    
    public String[][] getNameOfTeams(){
        return m.getNamesOfTeam();
    }
    
    public String[] getResultsOfMatches(){
        return m.getResultsOfMatches();
    }
    
    public void importarEquiposDeDisco(){//Tengo un fichero equipos.txt Quiero leerlo y colocar los equipos locales y visitantes
        //
        String nombreDelArchivo = m.getNombreDelArchivo();
        String nombreDeLaCarpeta = m.getNombreDeLaCarpeta();
        Path pathOfTeamFile = Rutas.pathToFileFolderOnDesktop(nombreDeLaCarpeta, nombreDelArchivo);
        
        //Si el archivo no existe notificar al usuario
        
        if(!Files.exists(pathOfTeamFile)){
            System.out.printf("%nNO EXISTE %s EN *Desktop/%s%n%n!!", nombreDelArchivo, nombreDeLaCarpeta);
            System.out.printf("\n\nCOPIE DATOS EN EL ESCRITORIO\n\n");
            return;
        }
        
        //Si el archivo no se puede leer, notificar al usuario
        
        List<String> tmp;
        try{
            tmp = Files.readAllLines(pathOfTeamFile);
        } catch(IOException ex){
            System.err.printf("%n%nERROR: No fue posible importar" + "los nombres de los equipos%n%n");
            return;
        }
        
        //Si el numero de equipos locales y visitantes no son el mismo, notificar al usuario
        
        if(tmp.size() != m.getNUM_PARTIDOS()){
            System.err.printf("%n%nERROR: el numero de parejas de equipos" + "no coincide con el numero de partidos (%d)%n", 
                    tmp.size(), m.getNUM_PARTIDOS());
            return;
        }
        
        //Asignar nombres de equipo local y visitante a cada partido
        
        Partido[] p = m.getPartidos();
        for(int i=0; i<tmp.size(); i++){
            String [] nombres = tmp.get(i).split("-");
            p[i].setEquipoLocal(nombres[0]);
            p[i].setEquipoVisitante(nombres[1]);
        }
    }//End of importarEquipoDeDisco()
}//End of Controller
