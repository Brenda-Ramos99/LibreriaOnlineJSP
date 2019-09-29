
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class DetallePrestamo {
    
    private int id_detalle_prestamo;
    private Prestamo id_prestamo;
    private Libro id_libro;
    private int cantidad;
    private double subtotal;
    private int estado;

    public DetallePrestamo() {
    }

    public DetallePrestamo(int id_detalle_prestamo, Prestamo id_prestamo, Libro id_libro, int cantidad, double subtotal, int estado) {
        this.id_detalle_prestamo = id_detalle_prestamo;
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
    }

    public DetallePrestamo(Prestamo id_prestamo, Libro id_libro, int cantidad, double subtotal, int estado) {
        this.id_prestamo = id_prestamo;
        this.id_libro = id_libro;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.estado = estado;
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

    public Prestamo getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(Prestamo id_prestamo) {
        this.id_prestamo = id_prestamo;
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
