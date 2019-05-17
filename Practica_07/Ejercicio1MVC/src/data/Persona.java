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
public class Persona {
	
	private String nombre;
	private int telefono;
	private float peso;

	public Persona(String n,
			int t,
			float p){
		this.nombre = n;
		this.telefono = t;
		this.peso = p;
	}
	
    public static Persona instanceFromString(String s) {
    	String[] fragmentos = s.split("\t");
    	Persona tmp;
    	try{
    		String n = fragmentos[0];
    		int t = Integer.parseInt(fragmentos[1]);
    		float p = Float.parseFloat(fragmentos[2]);
    		tmp = new Persona(n, t, p);
    	} catch (Exception e){
    		System.err.printf("%n%nERROR: se ha" 
    	             + " descartado la cadena %s%n%n", s);
    		tmp = null;
    	}
    	return tmp;
    }//End of Persona instranceFromString

    public String asPlainTableRow() {
    	
    	return String.format("| %20s | %9d | %5.2f |",
    		this.nombre,
    		this.telefono,
    		this.peso);
    }//End of asPlainTableRow
    
}
