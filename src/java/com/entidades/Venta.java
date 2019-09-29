
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Venta {
    
    
    
    private int id_venta;
    private Editorial id_editorial;
    private String fecha;
    private double iva;
    private double total;
    private int estado;

    public Venta() {
    }

    public Venta(int id_venta, Editorial id_editorial, String fecha, double iva, double total, int estado) {
        this.id_venta = id_venta;
        this.id_editorial = id_editorial;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
    }

    public Venta(Editorial id_editorial, String fecha, double iva, double total, int estado) {
        this.id_editorial = id_editorial;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
        this.estado = estado;
    }

    public Venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Editorial getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(Editorial id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
