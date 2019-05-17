/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Luis
 */
public class Model {
    Supermercado lista = new Supermercado();
    private final String archivoBinario_Clientes = "clientes.bin";
    private final String archivoBinario_Productos = "productos.bin";
    private final String fichero_Clientes = "clientes.csv";
    private final String fichero_Productos = "productos.csv";
    private final String nombreCarpeta = "Super17";
    private final String aExportar_html = "productos.html";
    private final String aExportar_columnas = "productos.col";
    private float importeTotal;
    private float importeTotalFacturado;
    private String valorTotalExistencias;
    private int numFacturaSimplificada;
    private int numFacturaOrdinaria;
    private final int defaultNumTicket = 112802;
    private final int defaultNumFactura = 19803;
    private Ticket ticketCompra;
    private Factura facturaCompra;
    private List<Producto> ticket = new ArrayList<>();
    private List<Producto> factura = new ArrayList<>();
    private List<Ticket> ticketNuevo = new ArrayList<>();
    private List<Factura> facturaNueva = new ArrayList<>();
    private List<Factura> facturaPrueba = new ArrayList<>();
    
    public Supermercado getSupermercado(){
        return lista;
    }
    
    public void setSupermercado(Supermercado lista){
        this.lista = lista;
    }

    public List<Cliente> getClientes(){
        return this.lista.getTipoCliente();
    }
    
    public List<Producto> getProductos(){
        return this.lista.getTipoProducto();
    }
    
    public List<Ticket> getTicket(){
        return this.lista.getTipoTicket();
    }
    
    public List<Factura> getFactura(String dni){
        for(Cliente c : this.getClientes()){
            if(dni.equalsIgnoreCase(c.getDni())){
                this.facturaPrueba = c.getFacturas();
            }
        }
        
        return this.facturaPrueba;
    }
    
    /*
    //
    // IMPORTAR ARCHIVOS EN EL ARRANQUE
    //
    */

    public void setClientes(List<Cliente> list) {
        this.lista.setTipoCliente(list);
    }

    public void setProductos(List<Producto> list) {
        this.lista.setTipoProducto(list);

    }
    
    /*
    //
    // Opcion --> ARCHIVOS
    //
    */

    public String getArchivoBinario_Clientes() {
        return archivoBinario_Clientes;
    }

    public String getArchivoBinario_Productos() {
        return archivoBinario_Productos;
    }

    public String getFichero_Clientes() {
        return fichero_Clientes;
    }
    
    public String getFichero_Productos() {
        return fichero_Productos;
    }

    public String getNombreCarpeta() {
        return nombreCarpeta;
    }

    public String getaExportar_html() {
        return aExportar_html;
    }

    public String getaExportar_columnas() {
        return aExportar_columnas;
    }
    
    /*
    //
    // Opcion --> CLIENTES
    //
    */

    public void setNuevoCliente(Cliente c) {
        this.lista.getTipoCliente().add(c);
        //this.setlista(lista);
    }
    
    public int deleteClient(String dni) {
        int flag = 0;
        for (Cliente c : this.getClientes()){
            if(dni.equalsIgnoreCase(c.getDni())){
                flag = 1;
                c.setEstado("inactivo");
                break;
            }
        }
        return flag;
    }
    
    /*
    *
    * Realiza las operaciones convenientes dentro de nuestra base de datos
    * para modificar cualquiera de los aspectos del cliente indicado a traves
    * del argumento opcion(indica que modificacion se desea realizar)
    *
    */
    
    
    public String setModify(String operacion, String cambio, String dni) {
        String sentencia;
        if(operacion.equalsIgnoreCase("1")){
            for (Cliente c : this.getClientes()){
                if(dni.equalsIgnoreCase(c.getDni())){
                    c.setDni(cambio);
                    break;
                }
            }
            sentencia = "\nDNI modificado con exito\n"; 
        }
        else if(operacion.equalsIgnoreCase("2")){
            for (Cliente c : this.getClientes()){
                if(dni.equalsIgnoreCase(c.getDni())){
                    c.setNombre(cambio);
                    break;
                }
            }
            sentencia = "\nNombre modificado con exito\n"; 
        }
        else if(operacion.equalsIgnoreCase("3")){
            for (Cliente c : this.getClientes()){
                if(dni.equalsIgnoreCase(c.getDni())){
                    c.setApellido(cambio);
                    break;
                }
            }
            sentencia = "\nApellido modificado con exito\n"; 
        }
        else if(operacion.equalsIgnoreCase("4")){
            for (Cliente c : this.getClientes()){
                if(dni.equalsIgnoreCase(c.getDni())){
                    c.setDireccion(cambio);
                    break;
                }
            }
            sentencia = "\nDireccion modificada con exito\n"; 
        }
        else if(operacion.equalsIgnoreCase("5")){
            for (Cliente c : this.getClientes()){
                if(dni.equalsIgnoreCase(c.getDni())){
                    c.setEstado(cambio);
                    break;
                }
            }
            sentencia = "\nEstado modificado con exito\n"; 
        }
        else{
            sentencia = "\nOpcion no valida\n";
        }
        
        return sentencia;
    }
    
    /*
    //
    // Opcion --> RESULTADOS
    //
    */

    public void setTotalSalesImport(float importeTotalVentas) {
        this.importeTotal = importeTotalVentas;
    }

    public void setTotalCheckedImport(float importeTotalFacturado) {
        this.importeTotalFacturado = importeTotalFacturado;
    }

    public void setTotalValueWithoutIVA(String toString) {
        this.valorTotalExistencias = toString;
    }

    public float getImporteTotalDeVentas() {
        return importeTotal;
    }

    public float getImporteTotalFacturado() {
        return importeTotalFacturado;
    }

    public String getValorTotalExistenciasSinIVA() {
        return valorTotalExistencias;
    }
    
    /*
    //
    // Opcion --> LISTADOS
    //
    */
    
    public void sortBy(String opcion) {
        Comparator<Cliente> ComparadorCliente = null;
        Comparator<Producto> ComparadorProducto = null;
        switch(opcion.toLowerCase()){
            case "1": ComparadorProducto = new ComparadorDeNombre();           break;
            case "2": ComparadorProducto = new ComparadorDeIVA_Precio();       break;
            case "3": ComparadorCliente  = new ComparadorDeApellidoYNombre();  break; 
            case "4": ComparadorCliente  = new ComparadorDeDNI();              break;
            default:  ComparadorProducto = new ComparadorDeNombre();           break;
        }
        if(opcion.equalsIgnoreCase("1") || opcion.equalsIgnoreCase("2")){ //Se ordena segun los Productos
            Collections.sort(this.getProductos(),ComparadorProducto);
        }
        else if(opcion.equalsIgnoreCase("3") || opcion.equalsIgnoreCase("4")){ //Se ordena segun los Clientes
            Collections.sort(this.getClientes(), ComparadorCliente);
        }
    }


    /*
    *
    * Devuelve una lista de los Productos que se encuentran disponibles en cada
    * ejecucion de este menu en listados
    *
    */
    
    
    public List<String> getListadoProductos() {
        List<String> result = new ArrayList<>();
        String separador =
                "+---------------------------+---------------+--------------+--------------+";
        result.add(String.format("| %-25s | %-13s | %-12s | %-5s |","NOMBRE","PRECIO","IVA","NUM_UNIDADES"));
        result.add(separador);
        for (Producto p : this.getProductos()){
            result.add(p.exportAsColumns());
            result.add(separador);
        }
        return result;
    }

    
    /*
    *
    * Devuelve una lista de los Clientes que se encuentran almacenados en cada
    * ejecucion de este menu en listados
    *
    */
    
    
    public List<String> getListadoClientes() {
        List<String> result = new ArrayList<>();
        String separador =
                "+-----------+-----------------------+-----------------+-----------------------------------------+-----------------+";
        result.add(String.format("| %-9s | %-21s | %-15s | %-39s | %-15s |","DNI","NOMBRE","APELLIDO","DIRECCION","ESTADO"));
        result.add(separador);
        for (Cliente c : this.getClientes()){
            result.add(c.exportAsColumns());
            result.add(separador);
        }
        return result;
    }

    /*
    //
    // Opcion --> VENTAS
    //
    */

    public void setNuevaCantidadProducto(String nombre,int resultado) {
        for (Producto p : this.getProductos()){
            if(p.getNombre().equalsIgnoreCase(nombre)){
                p.setNum_unidades(resultado);
                break;
            }
        }
    }

    public void setProductoEnTicketCompra(Producto p) {
        this.ticket.add(p);
    }
    
    public List<Producto> getProductosTicketCompra(){
        return this.ticket;
    }
    
    public void setNuevoTicket(Ticket c) {
        this.ticketNuevo.add(c);
        this.lista.setTipoTicket(ticketNuevo);
        this.setTicketParaComprar(c);
    }
             
    
    /*
    *
    * Almacena la factura con el respectivo cliente(a traves del DNI)
    * al que corresponde
    *
    */
    
    
    public void setFacturasIntoCliente(Factura f,String dni){
        this.setFacturaParaComprar(f);
        for (Cliente c : this.getClientes()){
            if(dni.equalsIgnoreCase(c.getDni())){
                //Es la primera factura de ese cliente
                if((c.getFacturas()) == null){
                    this.facturaNueva.add(f);
                    c.setFacturas(facturaNueva);
                }
                else{
                    this.facturaNueva = c.getFacturas();
                    this.facturaNueva.add(f);
                    c.setFacturas(facturaNueva);
                }
                break;
            }       
        }
    }
    
    public void setProductoEnFacturaCompra(Producto p) {
        this.factura.add(p);
    }
    
    public List<Producto> getProductosFacturaCompra() {
        return this.factura;
    }
    
    public int getNumFacturaSimplificada(int flag){
        if(flag == 1){
            if(this.getTicket() == null){// EN caso de no haber Ticket y sea el primero, el identificador sera un uno
                this.numFacturaSimplificada = this.defaultNumTicket;
            }
            else{
                this.numFacturaSimplificada = this.getTicket().get(this.getTicket().size()-1).getIdentificador();
                this.numFacturaSimplificada++;
            }
        }

        return this.numFacturaSimplificada;
    }

    public int getNumFacturaOrdinaria(int flag) {
        if(flag == 1){
            for(Cliente c : this.getClientes()){
                if((c.getFacturas()) == null || c.getFacturas().size() == 1){ // EN caso de no haber facturas y sea la primera, el identificador sera un uno
                    this.numFacturaOrdinaria = this.defaultNumFactura;
                }
                else{ //Devuelve el identificador de la ultima factura introducida en caso de que haya mas de una 
                    this.numFacturaOrdinaria = c.getFacturas().get(c.getFacturas().size()-1).getIdentificador();
                    this.numFacturaOrdinaria++;
                }
            }
        }
        
        return this.numFacturaOrdinaria;
    }

    public void setNumFacturaOrdinaria() {
        (this.numFacturaOrdinaria)++;
    }
    
    private void setTicketParaComprar(Ticket c) {
        this.ticketCompra = c;
    }
    
    public Ticket getTicketParaComprar(){
        return this.ticketCompra;
    }

    private void setFacturaParaComprar(Factura f) {
        this.facturaCompra = f;
    }
    
    public Factura getFacturaParaComprar(){
        return this.facturaCompra;
    }
            
    /*
    *
    * Borra los ticket y Factura del local de manera que se guarden en la base de datos
    * pero no se apilen y cada vez que el usuario pida nuevos productos, salgan los productos
    * de la compra anterior
    *
    */
    
    
    public void borrarProductosCompra() {
        this.ticket.clear();
        this.factura.clear();
    }

            
            

}
