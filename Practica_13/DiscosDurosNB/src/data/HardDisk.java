/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author pgina27
 */
public class HardDisk {
    
    private String fabricante;
    private float megabytes;
    private String modelo;
    private String numeroDeSeries;
    private int tasaDeTransmision;
    private String tecnologia;
    private String tipoDeInterface;
    private int velocidadDeRotacion;
    
    public static final String[] FABRICANTES = {
        "Seagate", "Western Digital", "Intel", "Samsung", "Toshiba", "Crucial"
    };
    
    public static final String[] MODELOS = {
        "7200.14", "7200.12", "7200.15", "Momentus"
    };
    
    public static final String[] TECNOLOGIAS = {
        "HD", "SSD", "SSHD", "DVD", "BLUE RAY"
    };
    
    public static final float[] CAPACIDADES = {
        640.0f, 1024.0f, 2048.0f
    };
    
    public static final int[] VELOCIDADESDEROTACION = {
        5400, 7200, 15000
    };
    
    public static final int[] TASATRANSIMISION = {
        110, 180, 720, 220, 380, 660
    };
    
    public static final String[] TIPOSDEINTERFACE = {
        "SATA3", "SATA6", "PATA", "SCSI"
    };
    
    public static final String[] NUMEROSDESERIE = {
        "a123", "b123456", "c56789", "d78904"
    };
    
    
    public HardDisk(String fabricante, float megabytes, String modelo, String numeroDeSeries, int tasaDeTransmision, String tecnologia, String tipoDeInterface, int velocidadDeRotacion) {
        this.fabricante = fabricante;
        this.megabytes = megabytes;
        this.modelo = modelo;
        this.numeroDeSeries = numeroDeSeries;
        this.tasaDeTransmision = tasaDeTransmision;
        this.tecnologia = tecnologia;
        this.tipoDeInterface = tipoDeInterface;
        this.velocidadDeRotacion = velocidadDeRotacion;
    }
    
    static HardDisk instanceWithRandomAttributes() {
    }

    public String exportStateWithDelimiters(String delimiter) {
        String resultado;
        resultado = String.format(
                "%s %5s %6.1f %5s %5s %5s %5s %6s ", );
    }

    String exportStateAsColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the fabricante
     */
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the megabytes
     */
    public float getMegabytes() {
        return megabytes;
    }

    /**
     * @param megabytes the megabytes to set
     */
    public void setMegabytes(float megabytes) {
        this.megabytes = megabytes;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numeroDeSeries
     */
    public String getNumeroDeSeries() {
        return numeroDeSeries;
    }

    /**
     * @param numeroDeSeries the numeroDeSeries to set
     */
    public void setNumeroDeSeries(String numeroDeSeries) {
        this.numeroDeSeries = numeroDeSeries;
    }

    /**
     * @return the tasaDeTransmision
     */
    public int getTasaDeTransmision() {
        return tasaDeTransmision;
    }

    /**
     * @param tasaDeTransmision the tasaDeTransmision to set
     */
    public void setTasaDeTransmision(int tasaDeTransmision) {
        this.tasaDeTransmision = tasaDeTransmision;
    }

    /**
     * @return the tecnologia
     */
    public String getTecnologia() {
        return tecnologia;
    }

    /**
     * @param tecnologia the tecnologia to set
     */
    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    /**
     * @return the tipoDeInterface
     */
    public String getTipoDeInterface() {
        return tipoDeInterface;
    }

    /**
     * @param tipoDeInterface the tipoDeInterface to set
     */
    public void setTipoDeInterface(String tipoDeInterface) {
        this.tipoDeInterface = tipoDeInterface;
    }

    /**
     * @return the velocidadDeRotacion
     */
    public int getVelocidadDeRotacion() {
        return velocidadDeRotacion;
    }

    /**
     * @param velocidadDeRotacion the velocidadDeRotacion to set
     */
    public void setVelocidadDeRotacion(int velocidadDeRotacion) {
        this.velocidadDeRotacion = velocidadDeRotacion;
    }
    
    
    
    
    
}
