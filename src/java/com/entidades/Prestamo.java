
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Prestamo {
    
    
    
    private int id_prestamo;
    private String fecha_inicio;
    private String fecha_fin;
    private double total;
    private Usuario id_usuario;

    public Prestamo() {
    }

    public Prestamo(int id_prestamo, String fecha_inicio, String fecha_fin, double total, Usuario id_usuario) {
        this.id_prestamo = id_prestamo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.total = total;
        this.id_usuario = id_usuario;
    }

    public Prestamo(String fecha_inicio, String fecha_fin, double total, Usuario id_usuario) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.total = total;
        this.id_usuario = id_usuario;
    }

    public Prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }
    
    
    
    
    
    
}
