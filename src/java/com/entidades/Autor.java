
package com.entidades;

/**
 *
 * @author Eduard Recinos
 */
public class Autor
{   
    private int id_autor;
    private String nombre;
    private String seudonimo;
    private String genero;
    private String nacionalidad;
    
    public Autor() {
    }

    public Autor(int id_autor, String nombre, String seudonimo, String genero, String nacionalidad) {
        this.id_autor = id_autor;
        this.nombre = nombre;
        this.seudonimo = seudonimo;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public Autor(String nombre, String seudonimo, String genero, String nacionalidad) {
        this.nombre = nombre;
        this.seudonimo = seudonimo;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }

    public Autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
