package view;

import controller.Controller;
import java.util.Scanner;

public class View {

	Scanner sc = new Scanner(System.in);
    Controller c = new Controller();

    public void runMenu(String menu) {
        /*
        Importar,Mostrar,Salir
        */
        boolean salir = false;
        do{
            System.out.printf("%s:",menu);
            String opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.leerNumeros();
                    break;
                case "2":
                	this.calcularSuma();
                	break;
                case "3":
                    this.mostrarSuma();
                    break;
                case "4":
                    salir = this.preguntarSiSalimos();
                    break;
                default:
                    System.out.printf("%n%nOpcion Incorrecta%n%n");
                    break;
            }//End of switch
        }while(!salir);
    }//End of runMenu()
    
    private boolean preguntarSiSalimos(){
        String opcion;
        do{
            System.out.printf("%nDesea realmente salir" 
                    + " de la aplicacion? [s/N]");
            opcion = sc.nextLine();
        } while(!"sSnN".contains(opcion));//Mientras la opcion s/S o n/N no sea igual que la opcion
        System.out.println();
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }//End of preguntarSiSalimos
    
    private void leerNumeros(){
        int num1,num2;
        
        System.out.printf("%n%nEscriba el 1er numero: ");
        num1 = sc.nextInt();
        System.out.printf("%n%nEscriba el 2do numero: ");
        num2 = sc.nextInt();

        System.out.printf("%n%nSe han leido " 
                + " los dos numeros enteros.%n%n");
        
        c.storeIntoModel(num1, num2);
    }//End of importarArchivo
    
    private void calcularSuma(){
    	System.out.printf("%n%nSe ha calculado el resultado%n%n");
    	
    	c.getSuma();
    }
    
    private void mostrarSuma(){
        int num1 = c.getInfo_1();
        int num2 = c.getInfo_2();
        int resultado = c.getInfo_Resultado();
        System.out.printf("%n%nLa suma de "
        		+ num1 + " + " + num2 + " = " + resultado);
    }//End of mostrarDatos
}
