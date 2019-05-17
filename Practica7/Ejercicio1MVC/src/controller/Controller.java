/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import com.coti.tools.Rutas;
import java.util.ArrayList;
import data.Model;
import data.Persona;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;


public class Controller {
    
    Model m = new Model();
    private ArrayList<Persona> personasImportadas;
    
    public void importarArchivo() {
        String nombreDelArchivo = m.getNombreDelArchivo();
        String nombreDeLaCarpeta = m.getNombreDeLaCarpeta();
        //
        //Se supone que el archivo esta en el Escritorio, lo comprobamos
        //
//PARCHEADO       Path p = Rutas.pathToFileInFolderOnDesktop(nombreDeLaCarpeta, nombreDelArchivo); PARCHEADO
        
        String ss = System.getProperty("user.home")
        		+ File.separator
        		+ "Escritorio" 
        		+ File.separator 
        		+ nombreDeLaCarpeta
        		+ File.separator
        		+ nombreDelArchivo;
        System.out.println(ss);
        File f = new File(ss);
        Path p = f.toPath();      		
        
        //
        //Si el archivo no existe se le notifica al usuario
        //
        if(!Files.exists(p)){
            System.err.printf("%n%nFATAL: %s no existe" 
                    + " en el escritorio. Saliendo...%n%n",
                    nombreDelArchivo);
            System.err.printf("%n%nCOPIE datos EN EL ESCRITORIO%n%n");
            System.exit(1);
        }
        //
        //Si existe se leen todas las lineas
        //
        List<String> tmp;
        try{
            tmp = Files.readAllLines(p);
        } catch(IOException e){
            System.err.printf("%n%nFATAL: could not import person%n%n");
            tmp = null;
        }
        //
        //Si el cjto de lineas no esta vacio se convierte cada linea no vacia en un ejemplar de Persona
        //
        if(null != tmp && !tmp.isEmpty()){
            this.personasImportadas = new ArrayList<>();
            for(String s : tmp){
                if(!s.isEmpty()){
                    Persona x = Persona.instanceFromString(s);
                    if(null != x){
                        this.personasImportadas.add(x); //Pregunta metodos de factoria en los examenes!!!!!!!!!!!!!!
                    }//End of if(3)                                             
                }//End of if(2)
            }//End of for
        }//End of if(1)
        
        m.setPersonasImportadas(this.personasImportadas);
        
    }//End of importarArchivo

    public String getPersonasImportadasComoTabla() {
        List<Persona> tmp = m.getPersonasImportadas();
        StringBuilder sb = new StringBuilder();
        for(Persona p : tmp){
            sb.append(p.asPlainTableRow()).append("\n");
        }
        return sb.toString();
    }//End of getPersonasImportadasComoTabla
    
    public int getNumPersonas() {
        return m.getPersonasImportadas().size();
    }//End of getNumPersonas
 
}//End of Controller
