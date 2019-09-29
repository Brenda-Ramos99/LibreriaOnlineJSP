
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetalleVenta {
    
    
    private int id_detalle_venta;
    private Libro id_libro;
    private Venta id_venta;
    private int cantidad;
    private double precio;
    private double subtotal;
    private int estado;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalle_venta, Libro id_libro, Venta id_venta, int cantidad, double precio, double subtotal, int estado) {
        this.id_detalle_venta = id_detalle_venta;
        this.id_libro = id_libro;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public DetalleVenta(Libro id_libro, Venta id_venta, int cantidad, double precio, double subtotal, int estado) {
        this.id_libro = id_libro;
        this.id_venta = id_venta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public DetalleVenta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Libro getId_libro() {
        return id_libro;
    }

    public void setId_libro(Libro id_libro) {
        this.id_libro = id_libro;
    }

    public Venta getId_venta() {
        return id_venta;
    }

    public void setId_venta(Venta id_venta) {
        this.id_venta = id_venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
    
    
}
