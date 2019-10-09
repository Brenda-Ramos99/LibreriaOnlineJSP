
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Libro
{
    private int id_libro;
    private Categoria id_categoria;
    private Autor idAutor;
    private String titulo;
    private int tomo;
    private int existencias;
    private String anio_public;
    private Double precio;

    public Libro() {
    }

    public Libro(int id_libro, Categoria id_categoria, Autor idAutor,
            String titulo, int tomo, int existencias, String anio_public, Double precio)
    {
        this.id_libro = id_libro;
        this.id_categoria = id_categoria;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
    }

    public Libro(Categoria id_categoria, Autor idAutor, String titulo, int tomo,
            int existencias, String anio_public, Double precio)
    {
        this.id_categoria = id_categoria;
        this.idAutor = idAutor;
        this.titulo = titulo;
        this.tomo = tomo;
        this.existencias = existencias;
        this.anio_public = anio_public;
        this.precio = precio;
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

    public Autor getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Autor idAutor) {
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTomo() {
        return tomo;
    }

    public void setTomo(int tomo) {
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
