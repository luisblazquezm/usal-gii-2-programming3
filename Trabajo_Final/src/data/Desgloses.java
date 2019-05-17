/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Luis
 */
public class Desgloses {
    private float porcentaje;
    private float base;
    private float cuota;

    public Desgloses(float porcentaje, float base, float cuota) {
        this.porcentaje = porcentaje;
        this.base = base;
        this.cuota = cuota;
    }

    public Desgloses() {
        this.porcentaje = 0;
        this.base = 0;
        this.cuota = 0;
    }

    /**
     * @return the porcentaje
     */
    public float getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the base
     */
    public float getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(float base) {
        this.base = base;
    }

    /**
     * @return the cuota
     */
    public float getCuota() {
        return cuota;
    }

    /**
     * @param cuota the cuota to set
     */
    public void setCuota(float cuota) {
        this.cuota = cuota;
    }
    
    
}
