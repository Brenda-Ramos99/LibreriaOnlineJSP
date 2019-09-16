package com.entidades;

/**
 * Nombre de la Clase: Libro
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Libro
{
    private int id_libro;
    private String titulo;
    private int existencias;
    private double precio;
    private String anio_public;
    private String tomo;
    private Categoria categoria;
    private Autor autor;
    private Editorial edit;
    private Usuario usuario;

    /*Método constructor vacío para inicializar la clase Libro*/
    public Libro()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabña Libro en la 
    base de datos*/
    public Libro(int id_libro, String titulo, int existencias, double precio,
            String anio_public, String tomo, Categoria categoria, Autor autor,
            Editorial edit, Usuario usuario)
    {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.existencias = existencias;
        this.precio = precio;
        this.anio_public = anio_public;
        this.tomo = tomo;
        this.categoria = categoria;
        this.autor = autor;
        this.edit = edit;
        this.usuario = usuario;
    }
    
    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla Libro en la base de 
    datos (sin ID, ya que es autoincrementable)*/
    public Libro(String titulo, int existencias, double precio,
            String anio_public, String tomo, Categoria categoria, Autor autor,
            Editorial edit, Usuario usuario)
    {
        this.titulo = titulo;
        this.existencias = existencias;
        this.precio = precio;
        this.anio_public = anio_public;
        this.tomo = tomo;
        this.categoria = categoria;
        this.autor = autor;
        this.edit = edit;
        this.usuario = usuario;
    }
    

    /*Método constructor para el ID del Libro, necesario para realizar la 
    eliminación de registros a la tabla Libro en la base de datos*/
    public Libro(int id_libro)
    {
        this.id_libro = id_libro;
    }

    /*Métodos de acceso de la Clase*/

    public int getId_libro() {
        return id_libro;
    }

    public void setId_libro(int id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAnio_public() {
        return anio_public;
    }

    public void setAnio_public(String anio_public) {
        this.anio_public = anio_public;
    }

    public String getTomo() {
        return tomo;
    }

    public void setTomo(String tomo) {
        this.tomo = tomo;
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

    public Editorial getEdit() {
        return edit;
    }

    public void setEdit(Editorial edit) {
        this.edit = edit;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
