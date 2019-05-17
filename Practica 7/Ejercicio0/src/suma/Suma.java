package suma;

import view.View;

public class Suma {

    public static void main(String[] args) {
	     View v = new View();
	     v.runMenu("\n1.- Leer los numeros "
	    		    + "\n2.- Calcular la suma"
	                + "\n3.- Mostrar el resultado"
	                + "\nq.- Salir");   
	}
	
}
