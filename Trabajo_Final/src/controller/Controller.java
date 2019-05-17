/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.Cliente;
import data.Desgloses;
import data.Factura;
import data.Model;
import data.Producto;
import data.Ticket;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.Charset;


/**
 *
 * @author Luis
 */
public class Controller {
    
    private final Model m = new Model();
    
    /*
    //
    // IMPORTAR ARCHIVOS EN EL ARRANQUE
    //
    */

    public void importarArranque() {
        this.importarClientes();
        this.importarProductos();
    }
    
    public void importarClientes() {
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String archivoClientesAComprobar = m.getArchivoBinario_Clientes();
        String archivoClientesALeer = m.getFichero_Clientes();
        String rutaClientesAComprobar = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoClientesAComprobar;// Ruta del archivo .bin (en caso de que existiera)
        String rutaClientesALeer = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoClientesALeer; // Ruta del archivo .csv 
        
        File f = new File(rutaClientesAComprobar);
        Path p = f.toPath();
        File f_read = new File(rutaClientesALeer);
        Path p_read = f_read.toPath();
        List<String> lineas = new ArrayList<>();
        List<Cliente> list = new ArrayList<>();
        
        if(Files.exists(p)){
            try{
                FileInputStream ficheroEntrada = new FileInputStream(f);
                ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);

                list = (List<Cliente>) objetoEntrada.readObject(); //Lee el contenido de cada fila del archivo binario y lo guarda en una variable producto
                                
                objetoEntrada.close();
                
                m.setClientes(list);
            }catch(IOException | ClassNotFoundException e){
                System.err.printf("%nNo se pudo abrir el fichero binario %s%n",rutaClientesAComprobar);
                System.out.println(e);
                System.exit(1);
            }
        }
        else{
            try{
                lineas = Files.readAllLines(p_read,Charset.forName("UTF-8")); 

            }catch(IOException e){
                System.err.printf("%nNo se pudo abrir el fichero .csv %s%n",rutaClientesALeer);
                System.out.println(e);
                System.exit(1);
            }
            int numeroDeClientes = lineas.size();
            String DNI ;
            String nombre;
            String apellido;
            String direccion;
            String estado;

            Cliente e;
        
            String[] fragmentos;
            for (int i = 0; i < numeroDeClientes; i++) {
                if(lineas.get(i).isEmpty()){
                     continue;
                }
                fragmentos = lineas.get(i).split("#");
                DNI = fragmentos[0];
                nombre = fragmentos[1];
                apellido = fragmentos[2];
                direccion = fragmentos[3];
                estado = fragmentos[4];
                e = new Cliente(DNI,nombre,apellido,direccion,estado,null);
                list.add(e);
            }          
            m.setClientes(list);
        }
    }//End of importarClientes

    public void importarProductos() {
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String archivoProductosAComprobar = m.getArchivoBinario_Productos();
        String archivoProductosALeer = m.getFichero_Productos();
        String rutaProductosAComprobar = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoProductosAComprobar;// Ruta del archivo .bin (en caso de que existiera)
        String rutaProductosALeer = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoProductosALeer;// Ruta del archivo .csv
        
        File f = new File(rutaProductosAComprobar);
        Path p = f.toPath();
        File f_read = new File(rutaProductosALeer);
        Path p_read = f_read.toPath();
        
        List<String> lineas = new ArrayList<>();
        List<Producto> list = new ArrayList<>();
        
        if(Files.exists(p)){
            try{
                FileInputStream ficheroEntrada = new FileInputStream(f);
                ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada);
                
                list = (List<Producto>) objetoEntrada.readObject(); //Lee el contenido de cada fila del archivo binario y lo guarda en una variable producto
                                
                objetoEntrada.close();
                
                m.setProductos(list);
            }catch(IOException | ClassNotFoundException e){
                System.err.printf("%nNo se pudo abrir el fichero binario %s%n",rutaProductosAComprobar);
                System.out.println(e);
                System.exit(1);
            }
        }
        else{
            try{
                lineas = Files.readAllLines(p_read,Charset.forName("UTF-8"));
                int numeroDeProductos = lineas.size();
                String nombre;
                float precio;
                float tipoIVA;
                int num;
            
                Producto e;
        
                String[] fragmentos;
                for (int i = 0; i < numeroDeProductos; i++) {
                    if(lineas.get(i).isEmpty()){ //Si no hay nada en el archivo (esta vacio) se sale del progrma
                       continue;
                    }
                    fragmentos = lineas.get(i).split("#");
                    nombre = fragmentos[0];
                    precio = Float.parseFloat(fragmentos[1]);
                    tipoIVA = Float.parseFloat(fragmentos[2]);
                    num = Integer.parseInt(fragmentos[3]);
                    e = new Producto(nombre,precio,tipoIVA,num);
                    list.add(e);
                }
                m.setProductos(list);
            }catch(IOException | NumberFormatException e){
                System.err.printf("%nNo se pudo abrir el fichero .csv %s%n",rutaProductosALeer);
                System.out.println(e);
                System.exit(1);
            }
        } 
    }//End of importarProductos
    
    public void exportarSalida() {
        this.exportarClientes();
        this.exportarProductos();
    }
    
    private void exportarClientes() {
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String archivoClientes= m.getArchivoBinario_Clientes();
        String rutaClientes = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoClientes;
        
        File f = new File(rutaClientes);
        Path p = f.toPath();

        List<Cliente> list = new ArrayList<>();
        
        try{
                FileOutputStream ficheroSalida = new FileOutputStream(f);
                ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);

                objetoSalida.writeObject(m.getClientes());

                objetoSalida.close();
                
        }catch(IOException e){
                System.err.printf("%nNo se pudo escribir el fichero binario %s%n",rutaClientes);
                System.out.println(e);
                System.exit(1);
        }
        
    }

    private void exportarProductos() {
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String archivoProductos = m.getArchivoBinario_Productos();
        String rutaProductos = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                archivoProductos;// Ruta del archivo .bin (en caso de que existiera)
        
        File f = new File(rutaProductos);
        Path p = f.toPath();

        List<Producto> list = new ArrayList<>();
        
        try{
                FileOutputStream ficheroSalida = new FileOutputStream(f);
                ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
                
                objetoSalida.writeObject(m.getProductos());
                
                objetoSalida.close();
                
        }catch(IOException e){
                System.err.printf("%nNo se pudo escribir el fichero binario %s%n",rutaProductos);
                System.out.println(e);
                System.exit(1);
        }
    }

    /*
    //
    // Opcion --> ARCHIVOS
    //
    */

    public String exportarEn(String opcion) throws FileNotFoundException {
        String ruta = "desconocido";
        if(opcion.equals("1")){
            ruta = this.exportarColumnas();
        }
        else if(opcion.equals("2")){
            ruta = this.exportarHTML();
        }
        
        return ruta;
    }//End of exportarEn

    private String exportarHTML() {
        String nombreFichero = m.getaExportar_html();
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String ruta = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                nombreFichero;
        
        File f = new File(ruta);
        Path p = f.toPath();
        List<String> lista = new ArrayList<>();
        
        lista.add("<hl>LISTA DE PRODUCTOS</hl>");
        lista.add("<table>\n");
        lista.add("<tr> <td>Nombre</td> <td>Precio</td> <td>TipoIVA</td> <td>Unidades</td> </tr>\n");
        
        for(Producto pr : m.getProductos()){
            lista.add(String.format("\n<TR> <TD>%15s</TD> <TD>%10.2f</TD> <TD>%10.2f</TD> <TD>%10d</TD> </TR>\n",
                    pr.getNombre(),pr.getPrecio(),pr.getIVA(),pr.getNum_unidades()));
        }
        
        try{
            Files.deleteIfExists(p);
            Files.write(p,lista);
        }catch(Exception e){
            System.err.printf("%nError en los datos HTML%n");
            System.out.println(e);
            System.exit(0);
        }
        
        return ruta;
    }//End of exportarHTML

    private String exportarColumnas() throws FileNotFoundException{
        String nombreFichero = m.getaExportar_columnas();
        String usuario = System.getProperty("user.home");
        String carpeta = m.getNombreCarpeta();
        String ruta = usuario +
                File.separator +
                "Desktop" +
                File.separator +
                carpeta +
                File.separator +
                nombreFichero;
        
        File f = new File(ruta);
        Path p = f.toPath();
        
        List<String> lista = new ArrayList<>();
        lista.add(String.format("%30s %10s %10s %10s\n","NOMBRE","PRECIO","IVA","UNIDADES"));
        for(Producto pr : m.getProductos()){
            lista.add(String.format("%30s %10.2f %10.2f %10d",
            pr.getNombre(),pr.getPrecio(),pr.getIVA(),pr.getNum_unidades())+"\n");
        }
        
        try{
            Files.deleteIfExists(p);
            Files.write(p,lista);
        }
        catch(Exception e){
            System.err.printf("%nError en los datos encolumnados%n");
            System.out.println(e);
            System.exit(0);
        }
        
        return ruta;
    }//End of exportarColumnas


    /*
    //
    // Opcion --> CLIENTES
    //
    */

    
    public int dniRepetido(String dni) {
        int valor = 1;
        for(Cliente c : m.getClientes()){
            if(c.getDni().equalsIgnoreCase(dni)){
                valor = 0;
            }
        }
 
        return valor;
    }

    public void añadirCliente(List<String> cl) {
        Cliente c = new Cliente(cl.get(0),cl.get(1),cl.get(2),cl.get(3),cl.get(4),null);
        m.setNuevoCliente(c);
    }
    
    public int eliminarCliente(String dni) { 
        return m.deleteClient(dni);
    }

    public String modificarCliente(String operacion,String cambio,String dni) {
        return m.setModify(operacion,cambio,dni);
    }
    
    /*
    //
    // Opcion --> RESULTADOS
    //
    */
      
    
    /*
    *
    * Calcula los resultados de cada apartado del menu RESULTADOS
    * 
    *
    */
    
    
    public int calcularResultados(String dni) {
        int flag = 0;
        float importeTotalVentas = 0; 
        float importeTotalFacturado = 0;
        float ValorTotalExistencias = 0;
        float total = 0;
        StringBuilder sb = new StringBuilder();
        
        // Opcion 1 de la Vista
        for (Cliente c : m.getClientes()){
            if(c.getFacturas() != null){
                for (Factura f : c.getFacturas()){
                    System.out.printf("%n%s - %.2f%n",c.getNombre(),f.getImporte_total());
                    importeTotalVentas += f.getImporte_total();
                }
            }
        }
        
        if(m.getTicket() != null){
            for (Ticket t : m.getTicket()){
                importeTotalVentas += t.getImporte_total();
            }
        }

        
        m.setTotalSalesImport(importeTotalVentas);
        
        // Opcion 2 de la Vista
        for (Cliente c : m.getClientes()){
            if(dni.equalsIgnoreCase(c.getDni())){
                if(c.getFacturas() == null){
                    importeTotalFacturado = 0;
                    flag = 1;
                }
                else{
                    for (Factura f : c.getFacturas()){
                        importeTotalFacturado += f.getImporte_total();
                        flag = 1;
                    }
                }
            }
        }
        
        m.setTotalCheckedImport(importeTotalFacturado);
        
        // Opcion 3 de la Vista
        //   Imprime una lista con los productos y sus precios.
        //   Así como el valor total de todos ellos.
        sb.append(String.format("\n %s %10s","PRODUCTO","VALOR TOTAL EXISTENCIAS"));
        for (Producto p : m.getProductos()){
            ValorTotalExistencias = p.getPrecio()*p.getNum_unidades();
            sb.append(String.format("\n %30s %10.2f \n",p.getNombre(),ValorTotalExistencias));
            total += ValorTotalExistencias;
        }
        sb.append("\n");
        sb.append(String.format("TOTAL EXISTENCIAS = %.2f",total));
        
        m.setTotalValueWithoutIVA(sb.toString());
        
        return flag;
    }//End of calcularResultados
    

    public float getTotalSalesImport() {
        return m.getImporteTotalDeVentas();
    }

    public float getTotalCheckedImport() {
        return m.getImporteTotalFacturado();
    }

    public String getTotalValueWithoutIVA() {
        return m.getValorTotalExistenciasSinIVA();
    }
    
    /*
    //
    // Opcion --> LISTADOS
    //
    */
  
    public void ordenarPor(String opcion) {
        m.sortBy(opcion);
    }
    
    public List<String> obtenerListadoProductos() {
        return m.getListadoProductos();
    }

    public List<String> obtenerListadoClientes() {
        return m.getListadoClientes();
    }

    /*
    //
    // Opcion --> VENTAS
    //
    */
      
    public int verificarProducto(int num,String nombre,String opcion) {
        int resultado = 0;
        for (Producto p : m.getProductos()){
          if(nombre.equalsIgnoreCase(p.getNombre())){
            // Resta al numero de unidades del producto que coincide con el nombre introducido, la cantidad introducida
            resultado = p.getNum_unidades() - num; 
            if(resultado >= 0){
                // Guarda el nuevo stock del producto en la base de datos
                m.setNuevaCantidadProducto(nombre,resultado);
                Producto prodLista = new Producto(p.getNombre(),p.getPrecio(),p.getIVA(),num);
                if(opcion.equals("1")){
                    // Guarda el producto en la lista de la compra para el ticket
                    m.setProductoEnTicketCompra(prodLista);
                }
                else if(opcion.equals("2")){
                    // Guarda el producto en la lista de la compra para la factura
                    m.setProductoEnFacturaCompra(prodLista);
                }
                break;
            } 
          }     
        }
        return resultado;
    }//End of verificarProducto
       
    
    /*
    *
    * Realiza los calculos necesarios para almacenar los tipos de productos y demas de cada ticket
    * 
    *
    */
    
    
    public void storeTicketIntoModel() {
        float importe;
        float aPagar = 0;
        float sinIva;
        for (Producto p : m.getProductosTicketCompra()){ //m.getProductos devuelve los productos comprados para Facturar por el cliente cada vez
                sinIva = p.getPrecio()* p.getNum_unidades();
                importe = p.getPrecio() * p.getNum_unidades() * p.getIVA();
                aPagar += importe + sinIva;
        }  
        // Añade una unidad al identificador del ticket indicando que es una nueva lista
        int i = m.getNumFacturaSimplificada(1);
        
        Ticket t = new Ticket(i,aPagar);
        m.setNuevoTicket(t);//Crea el formato del ticket con el identificador y el importe de los productos
                            // de la lista de la compra del ticket 
                            
    }//End of storeTicketIntoModel
   
    
    /*
    *
    * Verifica a través del DNI pasado desde la vista, que el usuario que pide realizar una factura
    * esta activo en la base de datos
    *
    */
    
    
    public int verificarDNI(String DNI_usuario) {
        int flag = 0;
        
        for (Cliente c : m.getClientes()){
            if(c.getDni().equalsIgnoreCase(DNI_usuario) && c.getEstado().equalsIgnoreCase("activo")){ 
                flag=1; 
                break;
            }
        }
        
        return flag;
    }//End of verificarDNI
    
    
    /*
    *
    * Realiza los calculos necesarios para convertir los productos asi como el importe
    * en una variable de tipo Factura
    *
    */
    
    
    
    public void storeFacturaIntoModel(String dni) {
        float importe;
        float aPagar = 0;
        float sinIva;
        for (Producto p : m.getProductosFacturaCompra()){ //m.getProductos devuelve los productos comprados para Facturar por el cliente cada vez 
                sinIva = p.getPrecio()* p.getNum_unidades();
                importe = p.getPrecio() * p.getNum_unidades() * p.getIVA();
                aPagar += importe + sinIva;
        }
        int i = m.getNumFacturaOrdinaria(1);   
        
        Factura f = new Factura(i,dni,aPagar);
        m.setFacturasIntoCliente(f,dni);
    }//End of storeFacturaIntoModel
    
    
    /*
    *
    * Realiza el ticket que saldra por pantalla y lo devuelve a la vista en forma de cadena concatenada
    *
    */
    
    
    public String getTicket() {
        StringBuilder sb = new StringBuilder();
        for (Ticket t : m.getTicket()){
            if(t.getIdentificador() == m.getNumFacturaSimplificada(0)){
                String hora = t.getHora().toString();
                hora = hora.replace("T", " ");// Retira de la cadena una T que estorba en medio entre la hora y la fecha
                float importe,precio,aporte,base;
                Desgloses[] d = new Desgloses[3];
                for (int i = 0; i < 3; i++) {
                    d[i] = new Desgloses();
                }
                sb.append(String.format("\n%s\n","FACTURA SIMPLIFICADA"));
                sb.append(String.format("%s\n",hora));
                sb.append(String.format("%s: 00%d\n","N.FACT.S",t.getIdentificador()));
                sb.append("\n");
                sb.append("*****PVP IVA INCLUIDO*****\n");
                sb.append("\n");
                for (Producto p : m.getProductosTicketCompra()){ //Devuelve los productos unicamente comprados por el usuario
                    if(p.getNum_unidades() >= 2){
                        sb.append(String.format("%-30s\n",p.getNombre()));
                        aporte = p.getPrecio()* p.getNum_unidades();
                        importe = p.getPrecio() * p.getNum_unidades() * p.getIVA();
                        importe += aporte;
                        // El importe que muestro por pantalla es el del precio con IVA
                        sb.append(String.format("%17d X %.2f %11.2f\n",p.getNum_unidades(),p.getPrecio(),importe));
                    }
                    else{
                        importe = p.getPrecio() * p.getIVA() *p.getNum_unidades();
                        precio = p.getPrecio() + importe;
                        sb.append(String.format("%-30s %-3.2f\n",p.getNombre(),precio));
                    }
                }
                sb.append(String.format("%4s\n","====================================="));
                sb.append(String.format("%-4s %22.2f\n","TOTAL A PAGAR",t.getImporte_total()));
                sb.append(String.format("%4s\n","====================================="));
                sb.append(String.format("%4s\n","DESGLOSES DEL IVA"));
                sb.append("\n");
                sb.append(String.format("%8s %7s %12s\n","TIPO IVA","BASE","CUOTA"));     
                
                for (Producto p : m.getProductosTicketCompra()){
                    if(p.getIVA() == 0.04f){
                        base = p.getPrecio() *p.getNum_unidades();
                        d[0].setBase(d[0].getBase()+base);
                        d[0].setPorcentaje(p.getIVA()*100);
                        d[0].setCuota(base*p.getIVA());
                    }
                    else if(p.getIVA() == 0.10f){
                        base = p.getPrecio() *p.getNum_unidades();
                        d[1].setBase(d[1].getBase()+base);
                        d[1].setPorcentaje(p.getIVA()*100);
                        d[1].setCuota(base*p.getIVA());
                    }
                    else if(p.getIVA() == 0.21f){
                        base = p.getPrecio() *p.getNum_unidades();
                        d[2].setBase(d[2].getBase()+base);
                        d[2].setPorcentaje(p.getIVA()*100);
                        d[2].setCuota(base*p.getIVA());
                    }
                }
                
                for(int i = 0; i<3;i++){
                    if(d[i].getBase() != 0){
                       sb.append(String.format("%5.2f%s %10.2f %13.2f\n",d[i].getPorcentaje(),"%",d[i].getBase(),d[i].getCuota())); 
                    }
                }
                break;
        
            }
        }
        m.borrarProductosCompra();//Si en una misma ejecucion se realizan mas de 1 ticket para que no se superpongan en la misma variable
        return sb.toString();
    }//End of getTicket
    
    
    /*
    *
    * Realiza la factura que saldra por pantalla y la devuelve a la vista en forma de cadena concatenada
    *
    */
    

    public String getFactura(String dni) {
        StringBuilder sb = new StringBuilder();
        for(Cliente c : m.getClientes()){
           if(c.getFacturas() != null){    
                for(Factura f : c.getFacturas()){
                    if(f.getIdentificador() == m.getNumFacturaOrdinaria(0)){
                        String hora = f.getHora().toString();
                        int numFactura = m.getNumFacturaOrdinaria(0);
                        hora = hora.replace("T", " ");
                        float importe,precio,aporte,base;
                    
                        Desgloses[] d = new Desgloses[3];
                        for (int i = 0; i < 3; i++) { //Creamos los ejemplares vacios de la clase Desgloses
                            d[i] = new Desgloses();
                        }
                    
                        sb.append(String.format("\n%s\n","FACTURA ORDINARIA"));
                        sb.append(String.format("%s\n",hora));
                        sb.append(String.format("%s: 000%d\n","N.FACT.O",f.getIdentificador()));
                        sb.append("\n");
                        sb.append(String.format("Cliente : %s %s   %s\n",c.getNombre(),c.getApellido(),c.getDni()));
                        sb.append(String.format("%s\n",c.getDireccion()));
                        sb.append("\n");
                        sb.append("*****PVP IVA INCLUIDO*****\n");
                        sb.append("\n");
                        for (Producto p : m.getProductosFacturaCompra()){
                            if(p.getNum_unidades() >= 2){
                                sb.append(String.format("%-30s\n",p.getNombre()));
                                aporte = p.getPrecio()* p.getNum_unidades();
                                importe = p.getPrecio() * p.getNum_unidades() * p.getIVA();
                                importe += aporte;
                                sb.append(String.format("%17d X %.2f %12.2f\n",p.getNum_unidades(),p.getPrecio(),importe));
                            }
                            else{
                                importe = p.getPrecio() * p.getIVA() *p.getNum_unidades();
                                precio = p.getPrecio() + importe;
                                sb.append(String.format("%-30s %-2.2f\n",p.getNombre(),precio));
                            }
                        }
                        sb.append(String.format("%4s\n","====================================="));
                        sb.append(String.format("%4s %23.2f\n","TOTAL A PAGAR",f.getImporte_total()));
                        sb.append(String.format("%4s\n","====================================="));
                        sb.append(String.format("%4s\n","DESGLOSES DEL IVA"));
                        sb.append("\n");
                        sb.append(String.format("%8s %7s %12s\n","TIPO IVA","BASE","CUOTA"));  
        
                        for (Producto p : m.getProductosFacturaCompra()){
                            if(p.getIVA() == 0.04f){
                                base = p.getPrecio() *p.getNum_unidades();
                                d[0].setBase(d[0].getBase()+base);
                                d[0].setPorcentaje(p.getIVA()*100);
                                d[0].setCuota(base*p.getIVA());
                            }
                            else if(p.getIVA() == 0.10f){
                                base = p.getPrecio() *p.getNum_unidades();
                                d[1].setBase(d[1].getBase()+base);
                                d[1].setPorcentaje(p.getIVA()*100);
                                d[1].setCuota(base*p.getIVA());
                            }
                            else if(p.getIVA() == 0.21f){
                                base = p.getPrecio() *p.getNum_unidades();
                                d[2].setBase(d[2].getBase()+base);
                                d[2].setPorcentaje(p.getIVA()*100);
                                d[2].setCuota(base*p.getIVA());
                            }
                        }
                
                        for(int i = 0; i<3;i++){
                            if(d[i].getBase() != 0){ //Si la base no esta vacia, es que hay productos que han sido vendidos con ese tipo de IVA
                                sb.append(String.format("%5.2f%s %10.2f %13.2f\n",d[i].getPorcentaje(),"%",d[i].getBase(),d[i].getCuota())); 
                            }
                        }
                        break;
                    }//End of if(f.getIdentificador...
                }//End of for(Factura f...
           }//End of if(c.getFacturas...
        }//End of for(Cliente...
       m.borrarProductosCompra();
       return sb.toString();
    }

}
