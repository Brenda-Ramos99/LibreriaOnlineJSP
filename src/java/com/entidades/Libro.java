
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Libro {
    
   private int id_libro;
   private Categoria id_categoria;
   private Autor id_autor;
   private String titulo;
   private String tomo;
   private int existencias;
   private String anio_public;
   private double precio;
   private int estado;

    public Libro(int id_libro, Categoria id_categoria, Autor id_autor, String titulo, String tomo, int existencias, String anio_public, double precio, int estado) {
        this.id_libro = id_libro;
        this.id_categoria = id_categoria;
        this.id_autor = id_autor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
        this.estado = estado;
    }

    public Libro() {
    }

    public Libro(Categoria id_categoria, Autor id_autor, String titulo, String tomo, int existencias, String anio_public, double precio, int estado) {
        this.id_categoria = id_categoria;
        this.id_autor = id_autor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
        this.estado = estado;
    }

    public Libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Autor getId_autor() {
        return id_autor;
    }

    public void setId_autor(Autor id_autor) {
        this.id_autor = id_autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getAnio_public() {
        return anio_public;
    }

    public void setAnio_public(String anio_public) {
        this.anio_public = anio_public;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
