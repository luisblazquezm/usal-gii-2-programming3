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
public class Producto implements java.io.Serializable {
    private String nombre;
    private float precio;
    private float IVA;
    private int num_unidades;
    
    public Producto(String nombre, float precio, float IVA, int num_unidades) {
        this.nombre = nombre;
        this.precio = precio;
        this.IVA = IVA;
        this.num_unidades = num_unidades;
    }

    public String exportAsColumns() {
        return String.format("| %-25s | %-13.2f | %-12.2f | %-12d |",
                  this.nombre,
                  this.precio,
                  this.IVA,
                  this.num_unidades);
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the IVA
     */
    public float getIVA() {
        return IVA;
    }

    /**
     * @param IVA the IVA to set
     */
    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    /**
     * @return the num_unidades
     */
    public int getNum_unidades() {
        return num_unidades;
    }

    /**
     * @param num_unidades the num_unidades to set
     */
    public void setNum_unidades(int num_unidades) {
        this.num_unidades = num_unidades;
    }
    
    
}
