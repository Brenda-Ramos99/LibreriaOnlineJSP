
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Libro
{
    private int id_libro;
    private Categoria categoria;
    private Autor autor;
    private String titulo;
    private String tomo;
    private int existencias;
    private String anio_public;
    private double precio;

    public Libro() {
    }

    public Libro(int id_libro, Categoria categoria, Autor autor, String titulo,
            String tomo, int existencias, String anio_public, double precio)
    {
        this.id_libro = id_libro;
        this.categoria = categoria;
        this.autor = autor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
    }

    public Libro(Categoria categoria, Autor autor, String titulo, String tomo, int existencias, String anio_public, double precio) {
        this.categoria = categoria;
        this.autor = autor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
    }

    public Libro(int id_libro)
    {
        this.id_libro = id_libro;
    }

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
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
}
