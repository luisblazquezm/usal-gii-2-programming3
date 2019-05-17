
package ejercicio6;

import java.util.Random;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        int numero1,numero2;
        int tries=1;
        Random rnd = new Random();
        int secreto = (int)(rnd.nextInt(200)+1);
        Scanner sc = new Scanner(System.in);
        
        
        System.out.println("!!ADIVINA EL NUMERO!!");
        System.out.printf("Introduzca un numero... a lo random: ");
        numero1 = Integer.parseInt(sc.nextLine());
        
        while(numero1 != secreto){
            if(numero1 > secreto){
               System.out.printf("Ummm demasiado grande, el numero %d es más grande que el que debes adivinar%n", numero1);
            }
            else if (numero1 < secreto){
                System.out.printf("Ummm demasiado pequeño, el numero %d es más pequeño que el que debes adivinar%n", numero1);
            }
            System.out.printf("Intento[%d]... a lo random: ",tries);
            numero2 = Integer.parseInt(sc.nextLine());
            if(numero1 != numero2){
                tries++;
            }
            numero1 = numero2;
            
        }//End of while
        
        System.out.printf("Bravo!!!!! el numero secreto era %d%n", numero1);
        System.out.printf("Nº de intentos: %d%n",tries);
    }
    
}
