/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;
import controller.Controller;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Luis
 */
public class View {

    private Controller c = new Controller();
    private final Scanner sc = new Scanner(System.in); 
    
    public void runMenu(String menu) throws FileNotFoundException {
        String opcion;
        boolean salir = false;
        c.importarArranque();
        do{
            System.out.printf("====SUPERMERCADO====\n");
            System.out.printf("%s:", menu);
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    this.archivos();
                    break;
                case "2":
                    this.clientes();
                    break;
                case "3":
                    this.resultados();
                    break;
                case "4":
                    this.listados();
                    break;
                case "5":
                    this.ventas();
                    break;
                case "q":
                    salir = this.preguntarSiSalimos("Desea realmente "
                            + " de la aplicacion[s/N]?");
                    break;
                default:
                    System.out.printf("%n%nOpcion incorrecta%n%n");
                    break;
            }
        }while(!salir);
        c.exportarSalida();
    }//End of runMenu

    private boolean preguntarSiSalimos(String prompt) {
        String opcion;
        do{
            System.out.printf("%n%s: ",prompt);
            opcion = sc.nextLine();
        }while(!"sSnN".contains(opcion));
        System.out.println();
        
        return(!opcion.isEmpty() && "sS".contains(opcion));
    }//End of preguntarSiSalimos
    
    private void archivos() throws FileNotFoundException {
        boolean fin = false;
        do{
            System.out.printf(
                    "%n%nEXPORTAR EN:"
                            +"%n1.- Formato de Columnas"
                            +"%n2.- Formato de Tabla"
                            +"%n%nq.- FIN"
                            +"%nSeleccion: -->");
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1": 
                case "2": 
                    String ruta = c.exportarEn(opcion); // Devuelve la ruta a la que se ha exportado bien el archivo HTML o encolumnado
                    System.out.printf("%n%nFichero creado con exito en %s %n",ruta);
                    break;
                case "q": fin = preguntarSiSalimos("Desea volver al menu principal?[s/N]");                 break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
        }while(!fin);
    }//End of archivos

    private void clientes() {
        List<String> cl = new ArrayList<>();
        boolean fin = false;
        do{
            System.out.printf(
                    "%n%nOPERACIONES:"
                            +"%n1.- Añadir un cliente (Altas)"
                            +"%n2.- Desactivar un cliente (Bajas)"
                            +"%n3.- Cambiar atributos de cliente (Modificaciones)"
                            +"%n%nq.- FIN"
                            +"%nSeleccion: -->");
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1": 
                    System.out.printf("%n%n*****REGISTRO*****%n");
                    System.out.printf("%nDNI: ");
                    String dni = sc.nextLine();
                    int flag = c.dniRepetido(dni);
                    
                    if(flag == 1){
                        cl.add(dni);
                    
                        System.out.printf("%nNombre: ");
                        String nombre = sc.nextLine();
                        cl.add(nombre);
                    
                        System.out.printf("%nPrimer Apellido: ");
                        String apellido = sc.nextLine();
                        cl.add(apellido);
                    
                        System.out.printf("%nDireccion: ");
                        String direccion = sc.nextLine();
                        cl.add(direccion);
                    
                        String estado = "activo";
                        cl.add(estado);
                    
                        c.añadirCliente(cl); // Funcion que añade una lista de tipo string conteniendo los datos de un cliente
                                         // para almacenarlos en la base de datos
                        System.out.println();
                    
                        for (String s : c.obtenerListadoClientes()) { // Devuelve una lista con todos los clientes de nuestra base de dato
                            System.out.println(s);
                        }
                        System.out.println();
                    
                        cl.clear();//En caso de que se quiera añadir más de un cliente en la misma ejecucion
                    }
                    else if(flag == 0){
                        System.out.printf("%n--------------->ERROR: Ha introducido un DNI repetido.Saliendo...%n%n");
                    }                  
                    break;
                case "2": 
                    System.out.printf("%n%nIntroduzca el DNI del cliente que desea eleminar: ");
                    dni = sc.nextLine();

                    int registrado = c.eliminarCliente(dni); 
                    if(registrado==0){ 
                        System.out.printf("%nUsuario no encontrado con el dni introducido");
                        System.out.printf("%nSi no se encuentra en nuestra base de datos " 
                                + " vaya a Clientes - Añadir un cliente, para darse de alta");
                    }
                    else{
                        for (String s : c.obtenerListadoClientes()) { // Devuelve una lista con todos los clientes de nuestra base de datos
                              System.out.println(s);
                        }
                        System.out.println();
                        System.out.printf("%n------------->Usuario eliminado con exito%n");
                    }
                    break;
                case "3":
                    boolean end = false;
                    System.out.printf("%n%nIntroduzca el DNI del cliente que desea modificar: ");
                    dni = sc.nextLine();
                    do{
                        System.out.printf(
                            "%n%n¿Que desea cambiar?:" 
                                +"\n1.- DNI" 
                                +"\n2.- Nombre"
                                +"\n3.- Apellido"
                                +"\n4.- Direccion" 
                                +"\n5.- Estado"
                                +"%n%nq.- FIN"
                                +"%nSeleccion: -->");
                        String op = sc.nextLine().toLowerCase();
                        if(!op.equalsIgnoreCase("q")){
                            System.out.printf("%nCambio:");
                            String cambio =sc.nextLine();
                            String sentencia = c.modificarCliente(op,cambio,dni); // Devuelve el mensaje que indica que cambio se ha realizado 
                            
                            for (String s : c.obtenerListadoClientes()) {// Devuelve una lista de los clientes para comprobar las modificaciones realizadas
                                System.out.println(s);
                            }
                            System.out.println();
                            System.out.println(sentencia);
                        }
                        else{
                            end = true;
                        }
                    }while(!end);    
                case "q": fin = preguntarSiSalimos("Desea volver al menu principal?[s/N]");               break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
        }while(!fin);
    }//End of clientes

    private void resultados() {
        float importeTotalDeVentas;
        float importeTotalFacturado;
        String valorTotalExistenciasSinIVA;
        String DNIdelCliente = "vacio";
        boolean fin = false;
        int registrado;
        
        registrado = c.calcularResultados(DNIdelCliente); // Llamada a la funcion calcular resultados de modo que funcione en caso de que se
                                                          // escoja una opcion que no sea la 2, en la que se necesita el dni como argumento.
                                                          // Por ello pasamos un argumentos falso, que no moleste para calcular el resto de opciones
        do{
            System.out.printf(
                    "%n%nMOSTRAR:"
                            +"%n1.- Importe total de ventas"
                            +"%n2.- Importe total facturado"
                            +"%n3.- Calculo valor total de las existencias del almacen(sin IVA)"
                            +"%n%nq.- FIN"
                            +"%nSeleccion: -->");
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1": 
                    importeTotalDeVentas = c.getTotalSalesImport();
                    System.out.printf("%n%nEl importe total de ventas es %.2f%n",importeTotalDeVentas);
                    break;
                case "2": 
                    System.out.printf("%n%nIntroduzca el DNI del cliente que desea modificar: ");
                    DNIdelCliente = sc.nextLine();
                    registrado = c.calcularResultados(DNIdelCliente);//Devuelve un 1 si el usuario esta registrado, un 0 en caso contrario
                    
                    if(registrado==0){
                        System.out.printf("%nUsuario no encontrado con el dni introducido");
                        System.out.printf("%nSi no se encuentra en nuestra base de datos " 
                                + " vaya a Clientes - Añadir un cliente, para darse de alta");
                        
                        break;
                    }
                    
                    importeTotalFacturado = c.getTotalCheckedImport();
                    System.out.printf("%n%nEl importe total facturado por el cliente con DNI %s es %.2f%n",DNIdelCliente ,importeTotalFacturado);
                    break;
                case "3": 
                    valorTotalExistenciasSinIVA = c.getTotalValueWithoutIVA();
                    System.out.println(valorTotalExistenciasSinIVA);
                    break;
                case "q": fin = preguntarSiSalimos("Desea volver al menu principal?[s/N]");                break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
        }while(!fin);
    }//End of resultados

    private void listados() {
        boolean fin = false;
        do{
            System.out.printf(
                    "%n%nORDENAR POR:"
                            +"%n%n=====PRODUCTOS=====%n"
                            +"%n1.- Nombres"
                            +"%n2.- Tipo IVA y precio"
                            +"%n%n=====CLIENTES=====%n"
                            +"%n3.- Apellidos primero y Nombre despues"
                            +"%n4.- DNI"
                            +"%n%nq.- FIN"
                            +"%nSeleccion: -->");
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1": 
                case "2": 
                case "3": 
                case "4":  c.ordenarPor(opcion);  this.verListado(opcion);                      break; 
                case "q":  fin = preguntarSiSalimos("Desea volver al menu principal?[s/N]");    break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
        }while(!fin);
    }//End of listados
    
    private void verListado(String opcion) {
        List<String> listadoProducto = c.obtenerListadoProductos();
        List<String> listadoClientes = c.obtenerListadoClientes();
        if(listadoProducto == null || listadoClientes == null){
            System.err.printf("%n%nLista vacia " 
                    + " Por favor, de valores a la lista%n%n");
            return;
        }
        System.out.println();
        if(opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2")){
            for (String s : listadoProducto) {
                System.out.println(s);
            }
            System.out.println();
        }
        else if(opcion.equalsIgnoreCase("3") || opcion.equalsIgnoreCase("4")){
            for (String s : listadoClientes) {
                System.out.println(s);
            }
            System.out.println();
        }
        else{
            System.out.println("\n--------------->Ha habido algun error\n");
        }
    }//End of verListado

    private void ventas() {
        String ticket,factura,prod1,prod2;
        boolean fin = false;
        do{
            System.out.printf(
                    "%n%nCOMPRAR CON:"
                            +"%n1.- Ticket"
                            +"%n2.- Factura"
                            +"%n%nq.- FIN"
                            +"%nSeleccion: -->");
            String opcion = sc.nextLine().toLowerCase();
            switch(opcion){
                case "1": 
                    System.out.printf("%n%nHa elegido la opcion TICKET%n");
                    do{
                        System.out.printf("%n¿Que producto desea obtener?:");
                        prod1 = sc.nextLine();
                        
                        if(!prod1.isEmpty()){
                            System.out.printf("%n¿Y cuanta cantidad de ese producto?:");
                            int num1 = Integer.parseInt(sc.nextLine());
                            int stock = c.verificarProducto(num1,prod1,opcion);
                            if(stock<0){
                              System.out.printf("%n%n--------------->Stock agotado o producto no encontrado");
                              System.out.printf("%nNo se puede hacer la venta de este producto%n");
                           } 
                           else{
                               System.out.printf("%n%nProducto en stock(%d productos restantes).%n",stock);
                               System.out.printf("Si desea salir " +
                                    "deje en blanco la casilla del producto a obtener.%n");
                           }
                        }
                        else{
                            System.out.printf("%n%nProducto vacio. Saliendo...%n");       
                        }
                    }while(!prod1.isEmpty());  
                    c.storeTicketIntoModel();

                    ticket = c.getTicket();   
                    System.out.println(ticket);
                    break;
                case "2": 
                    System.out.printf("%n%nHa elegido la opcion FACTURA%n");
                    System.out.printf("%nPor favor, introduzca su DNI: ");
                    String DNI_usuario = sc.nextLine();
                    
                    int almacenado=c.verificarDNI(DNI_usuario);
                    if(almacenado==0){
                        System.out.printf("%n%nUsuario NO REGISTRADO");
                        System.out.printf("%nPor favor, vuelva a menu y elija la opcion de "
                                + " Clientes - Añadir un cliente, para darse de alta");
                        System.out.printf("%nO bien si usted ya ha sido dado de alta, modifique su estado a activo%n");
                        System.out.printf("%nUna vez registrado, podra abonar con factura%n");
                    }
                    else if(almacenado == 1){
                        System.out.printf("%n%nUsuario REGISTRADO");
                        do{
                          System.out.printf("%n¿Que producto desea obtener?:");
                          prod2 = sc.nextLine();                         

                          if(!prod2.isEmpty()){
                            System.out.printf("%n¿Y cuanta cantidad de ese producto?:");
                            int num2 = Integer.parseInt(sc.nextLine());
                            
                            int stock = c.verificarProducto(num2,prod2,opcion);//Devuelve el stock que queda actualmente de ese producto
                            if(stock<0){
                              System.out.printf("%n%n--------------->Stock agotado o producto no encontrado");
                              System.out.printf("%nNo se puede hacer la venta de este producto%n");
                            } 
                            else{
                               System.out.printf("%n%nProducto en stock(%d productos restantes).%n",stock);
                               System.out.printf("Si desea salir " +
                                    "deje en blanco la casilla del producto a obtener.%n");
                            }
                          }
                          else{
                            System.out.printf("%n%nProducto vacio. Saliendo...%n");       
                          }
                        }while(!prod2.isEmpty()); 
                        c.storeFacturaIntoModel(DNI_usuario);
                        
                        factura = c.getFactura(DNI_usuario);   
                        System.out.println(factura);
                    }
                    break;
                case "q": fin = preguntarSiSalimos("Desea volver al menu principal?[s/N]");                break;
                default:
                    System.out.printf("%n%nOpcion desconocida%n%n");
                    break;
            }
        }while(!fin);
    }//End of ventas 
}//End of View