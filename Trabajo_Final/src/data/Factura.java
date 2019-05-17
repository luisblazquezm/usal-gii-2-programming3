/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDate;
import java.time.LocalDateTime;
/**
 *
 * @author Luis
 */
public class Factura implements java.io.Serializable{
    private int identificador;
    private LocalDate fecha = LocalDate.now();
    private LocalDateTime hora = LocalDateTime.now();
    private String dni;
    private float importe_total;

    public Factura(int identificador,String dni, float importe_total) {
        this.identificador = identificador;
        this.dni = dni;
        this.fecha = fecha;
        this.importe_total = importe_total;
    }

    /**
     * @return the identificador
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * @param identificador the identificador to set
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * @return the fecha
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the hora
     */
    public LocalDateTime getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
    
    /**
     * @return the importe_total
     */
    public float getImporte_total() {
        return importe_total;
    }

    /**
     * @param importe_total the importe_total to set
     */
    public void setImporte_total(float importe_total) {
        this.importe_total = importe_total;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @param dni the dni to set
     */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
}
