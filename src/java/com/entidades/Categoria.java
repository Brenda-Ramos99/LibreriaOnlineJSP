
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Categoria
{
    
    private int id_categoria;
    private String nombre_cat;

    public Categoria() {
    }

    public Categoria(int id_categoria, String nombre_cat) {
        this.id_categoria = id_categoria;
        this.nombre_cat = nombre_cat;
    }

    public Categoria(String nombre_cat) {
        this.nombre_cat = nombre_cat;
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

    public String getNombre_cat() {
        return nombre_cat;
    }

    public void setNombre_cat(String nombre_cat) {
        this.nombre_cat = nombre_cat;
    }
}
