/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
//import static com.coti.tools.Esdia.*;
/**
 *
 * @author pgina27
 */
public class Factura {

    private String nombre;
    private String razon_social;
    private String NIF;
    private float importe;
    private float tipo_de_IVA;
    private String fecha;
    private String concepto;
    
    //Static values used for random attributes
    
    private static final String[] NIFS = {
       "12345678A",
       "23456789B",
       "34567890C"
    };
    
    private static final String[] CONCEPTOS = {
      "Recambios",
      "Fungibles",
      "Adquisiciones"
    };
    
    private static final String[] DIRECCIONES = {
      "Calle del Pez, 13",
      "Rue du Percebe, 14",
      "RoBauer Lande, 1",
      "Rebengasse, 3",
      "KrankenhausstraBe, 1"
    };
    
    private static final String[] FECHAS = {
      "23/Nov/1989",
      "12/Oct/1492",
      "20/Feb/2038"
    };
    
    private static final String[] NOMBRES = {
      "John Doe", "Richard Roe",
      "Hans Wurst", "Juan Palomo"
    };
    
    private static final float IVAS[] = {
      10f,
      22f,
      6f
    };
    
    public Factura(String NIF,String c ,String f, float i,String n,String rz,float tdi){
        this.nombre = n;
        this.razon_social = rz;
        this.NIF = NIF;
        this.importe = i;
        this.tipo_de_IVA = tdi;
        this.fecha = f;
        this.concepto = c;
    }
    
    public Factura(){
        this.nombre = "Desconocido";
        this.razon_social = "Desconocido";
        this.NIF = "Desconocido";
        this.importe = 0;
        this.tipo_de_IVA = 0;
        this.fecha = "Desconocido";
        this.concepto = "Desconocido";
    }
    
    public static Factura instanceWithRandomAttributes(){
        Random r = new Random();
        
        Factura f = new Factura(
                NIFS[r.nextInt(NIFS.length)],
                CONCEPTOS[r.nextInt(CONCEPTOS.length)],
                FECHAS[r.nextInt(FECHAS.length)],
                1.0f + 1000.0f * r.nextFloat(),
                NOMBRES[r.nextInt(NOMBRES.length)],
                DIRECCIONES[r.nextInt(DIRECCIONES.length)],
                IVAS[r.nextInt(IVAS.length)]
        );
        
        return f;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public float getTipo_de_IVA() {
        return tipo_de_IVA;
    }

    public void setTipo_de_IVA(float tipo_de_IVA) {
        this.tipo_de_IVA = tipo_de_IVA;
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String exportStateAsColumns() {
        return String.format("| %9s | %-25s | %11s | %7.2f | %-15s | %-25s | %8.2f |",
                this.NIF,
                this.concepto,
                this.fecha,
                this.importe,
                this.nombre,
                this.razon_social,
                this.tipo_de_IVA);
    }
    
}
