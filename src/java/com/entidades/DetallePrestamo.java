
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetallePrestamo {
    
    private int id_detalle_prestamo;
    private Prestamo prestamo;
    private Libro libro;
    private int cantidad;
    private double subtotal;
    
    public DetallePrestamo()
    {
        
    }

    public DetallePrestamo(int id_detalle_prestamo, Prestamo prestamo,
            Libro libro, int cantidad, double subtotal)
    {
        this.id_detalle_prestamo = id_detalle_prestamo;
        this.prestamo = prestamo;
        this.libro = libro;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePrestamo(Prestamo prestamo, Libro libro, int cantidad,
            double subtotal)
    {
        this.prestamo = prestamo;
        this.libro = libro;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public DetallePrestamo(int id_detalle_prestamo) {
        this.id_detalle_prestamo = id_detalle_prestamo;
    }

    public int getId_detalle_prestamo() {
        return id_detalle_prestamo;
    }

    public void setId_detalle_prestamo(int id_detalle_prestamo) {
        this.id_detalle_prestamo = id_detalle_prestamo;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
