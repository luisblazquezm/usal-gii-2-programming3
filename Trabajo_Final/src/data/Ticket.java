/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Luis
 */
public class Ticket {
    private Random r;
    private int identificador ;
    private LocalDate fecha = LocalDate.now();
    private LocalDateTime hora = LocalDateTime.now();
    private float importe_total;

    public Ticket(int identificador, float importe_total) {
        this.identificador = identificador;
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
    
    
}
