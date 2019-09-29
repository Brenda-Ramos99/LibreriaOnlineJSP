
package com.entidades;



/**
 *
 * @author Eduardo Recinos
 */
public class Membresia {
    
    private int id_membresia;
    private String tipo_membresia;
    private double precio_membresia;
    private int estado;

    public Membresia() {
    }

    public Membresia(int id_membresia, String tipo_membresia, double precio_membresia, int estado) {
        this.id_membresia = id_membresia;
        this.tipo_membresia = tipo_membresia;
        this.precio_membresia = precio_membresia;
        this.estado = estado;
    }

    public Membresia(String tipo_membresia, double precio_membresia, int estado) {
        this.tipo_membresia = tipo_membresia;
        this.precio_membresia = precio_membresia;
        this.estado = estado;
    }

    public Membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public int getId_membresia() {
        return id_membresia;
    }

    public void setId_membresia(int id_membresia) {
        this.id_membresia = id_membresia;
    }

    public String getTipo_membresia() {
        return tipo_membresia;
    }

    public void setTipo_membresia(String tipo_membresia) {
        this.tipo_membresia = tipo_membresia;
    }

    public double getPrecio_membresia() {
        return precio_membresia;
    }

    public void setPrecio_membresia(double precio_membresia) {
        this.precio_membresia = precio_membresia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
}
