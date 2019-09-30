
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetalleVenta {
    
    
    private int id_detalle_venta;
    private Libro libro;
    private Venta venta;
    private int cantidad;
    private double precio;
    private double subtotal;

    public DetalleVenta() {
    }

    public DetalleVenta(int id_detalle_venta, Libro libro, Venta venta,
            int cantidad, double precio, double subtotal)
    {
        this.id_detalle_venta = id_detalle_venta;
        this.libro = libro;
        this.venta = venta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public DetalleVenta(Libro libro, Venta venta, int cantidad, double precio,
            double subtotal)
    {
        this.libro = libro;
        this.venta = venta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public DetalleVenta(int id_detalle_venta)
    {
        this.id_detalle_venta = id_detalle_venta;
    }

    public int getId_detalle_venta() {
        return id_detalle_venta;
    }

    public void setId_detalle_venta(int id_detalle_venta) {
        this.id_detalle_venta = id_detalle_venta;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
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
}
