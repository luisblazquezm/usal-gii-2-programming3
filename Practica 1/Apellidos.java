/*
 * Para compilar e interpretar copias la ruta con cd; luego javac 
 * "carpeta en minusculas"\"archivo.java".java; luego java 
 * "carpeta en minusculas"\"archivo.java" o lo mismo pero java -cp . "lo mismo"
 */
package apellidos;

import java.io.Console;

public class Apellidos {
    
    public static void main(String[] args) {
      String nombre;
      String apellido_1;
      String apellido_2;
      
      Console c = System.console();
      c.printf("Escriba su nombre: ");
      nombre = c.readLine();
      
      c.printf("Escriba el primer apellido: ");
      apellido_1 = c.readLine();
      
      c.printf("Escriba el segundo apellido: ");
      apellido_2 = c.readLine();
      
      c.printf("%nSu nombre es %s %s %s%n",
              nombre, apellido_1, apellido_2);
      
      c.printf("La longitud de %s es %d%n",
              apellido_1, apellido_1.length());
      
      c.printf("La longitud de %s es %d%n",
              apellido_2, apellido_2.length());
      
      
    }
    
}
