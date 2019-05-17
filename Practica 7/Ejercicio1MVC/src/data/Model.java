/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.List;


public class Model {
    
	private final String nombreDelArchivo = "personas.txt";
	private final String nombreDeLaCarpeta = "datos";
	private List<Persona> personasImportadas;
	
	public String getNombreDelArchivo(){
		return nombreDelArchivo;
	}
	
    public String getNombreDeLaCarpeta() {
    	return nombreDeLaCarpeta;
    }

    public void setPersonasImportadas(ArrayList<Persona> personasImportadas)  {
    	this.personasImportadas = personasImportadas;
    }
    
    public List<Persona> getPersonasImportadas() {
    	return this.getPersonasImportadas();
    }
    
}
