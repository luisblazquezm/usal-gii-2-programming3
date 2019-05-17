/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author Luis
 */
public class Supermercado {
    private List<Cliente> tipoCliente;
    private List<Ticket> tipoTicket;
    private List<Producto> tipoProducto;

    public Supermercado(List<Cliente> tipoCliente,List<Producto> tipoProducto,List<Ticket> tipoTicket) {
        this.tipoCliente = tipoCliente;
        this.tipoTicket = tipoTicket;
        this.tipoProducto = tipoProducto;
    }

    public Supermercado() {
        this.tipoCliente = null;
        this.tipoTicket = null;
        this.tipoProducto = null;
    }

    /**
     * @return the tipoCliente
     */
    public List<Cliente> getTipoCliente() {
        return tipoCliente;
    }

    /**
     * @param tipoCliente the tipoCliente to set
     */
    public void setTipoCliente(List<Cliente> tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * @return the tipoTicket
     */
    public List<Ticket> getTipoTicket() {
        return tipoTicket;
    }

    /**
     * @param tipoTicket the tipoTicket to set
     */
    public void setTipoTicket(List<Ticket> tipoTicket) {
        this.tipoTicket = tipoTicket;
    }

    /**
     * @return the tipoProducto
     */
    public List<Producto> getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(List<Producto> tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    
    
    
}
