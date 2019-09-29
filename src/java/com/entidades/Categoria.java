
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Categoria {
    
    
    
    private int id_categoria;
    private String nombre;
    private int estado;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre, int estado) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.estado = estado;
    }

    public Categoria(String nombre, int estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
}
