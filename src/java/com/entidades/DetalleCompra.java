
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetalleCompra {
    
    private int id_detalle_compra;
    private Compra id_compra;
    private Libro id_libro;
    private int cantidad;
    private double precio;
    private double subtotal;
    private int estado;

    public DetalleCompra() {
    }

    public DetalleCompra(int id_detalle_compra, Compra id_compra, Libro id_libro, int cantidad, double precio, double subtotal, int estado) {
        this.id_detalle_compra = id_detalle_compra;
        this.id_compra = id_compra;
        this.id_libro = id_libro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public DetalleCompra(Compra id_compra, Libro id_libro, int cantidad, double precio, double subtotal, int estado) {
        this.id_compra = id_compra;
        this.id_libro = id_libro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public DetalleCompra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public Compra getId_compra() {
        return id_compra;
    }

    public void setId_compra(Compra id_compra) {
        this.id_compra = id_compra;
    }

    public Libro getId_libro() {
        return id_libro;
    }

    public void setId_libro(Libro id_libro) {
        this.id_libro = id_libro;
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
