
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetalleCompra {
    
    private int id_detalle_compra;
    private Compra compra;
    private Libro libro;
    private int cantidad;
    private double precio;
    private double subtotal;
    

    public DetalleCompra()
    {
        
    }

    public DetalleCompra(int id_detalle_compra, Compra compra, Libro libro,
            int cantidad, double precio, double subtotal)
    {
        this.id_detalle_compra = id_detalle_compra;
        this.compra = compra;
        this.libro = libro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }

    public DetalleCompra(Compra compra, Libro libro, int cantidad,
            double precio, double subtotal)
    {
        this.compra = compra;
        this.libro = libro;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
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

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
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
