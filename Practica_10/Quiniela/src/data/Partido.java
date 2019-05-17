/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author pgina27
 */
public class Partido {

    private String equipoLocal;
    private String equipoVisitante;
    private float golesLocal;
    private float golesVisitante;
    private String resultado;

    public void calcularResultado() {
        if (golesLocal > golesVisitante) {
            this.resultado = "1 ";
        } else if (golesVisitante > golesLocal) {
            this.resultado = "2 ";
        } else {
            this.resultado = "X ";
        }
    }

    /**
     * @return the equipoLocal
     */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * @param equipoLocal the equipoLocal to set
     */
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * @return the equipoVisitante
     */
    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * @param equipoVisitante the equipoVisitante to set
     */
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * @return the golesLocal
     */
    public float getGolesLocal() {
        return golesLocal;
    }

    /**
     * @param golesLocal the golesLocal to set
     */
    public void setGolesLocal(float golesLocal) {
        this.golesLocal = golesLocal;
    }

    /**
     * @return the golesVisitante
     */
    public float getGolesVisitante() {
        return golesVisitante;
    }

    /**
     * @param golesVisitante the golesVisitante to set
     */
    public void setGolesVisitante(float golesVisitante) {
        this.golesVisitante = golesVisitante;
    }

    /**
     * @return the resultado
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    

}
