package ejercicio5;

import java.util.Random;

public class Ejercicio5 {

    public static boolean esPrimo(int numero){
       int contador = 2;
       boolean primo=true;
       while ((primo) && (contador!=numero)){
           if (numero % contador == 0)
              primo = false;
              contador++;
           }
       return primo;
    }
    
    public static void main(String[] args) {
        Random rnd = new Random();
        int aleatorio = (int)(rnd.nextInt(2000)+1);
        
        System.out.println("Vamos a imprimir todos los numeros primos de 1 a " + aleatorio + ":");
        for(int i=1; i < aleatorio; i++){
            if(esPrimo(i)){
                System.out.printf(i + "\n");
            }
        }
           
    }
    
}
