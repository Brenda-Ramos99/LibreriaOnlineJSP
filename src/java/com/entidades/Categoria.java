package com.entidades;

/**
 * Nombre de la Clase:Categoría
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Categoria
{
    private int id_categoria;
    private String nombre_cat;

    /*Método constructor vacío para inicializar la clase Libro*/
    public Categoria()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla categoria en la 
    base de datos*/
    public Categoria(int id_categoria, String nombre_cat)
    {
        this.id_categoria = id_categoria;
        this.nombre_cat = nombre_cat;
    }

    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla categoria en la base de 
    datos (sin ID, ya que es autoincrementable)*/
    public Categoria(String nombre_cat)
    {
        this.nombre_cat = nombre_cat;
    }

    /*Método constructor para el ID del categoría, necesario para realizar la 
    eliminación de registros a la tabla categoria en la base de datos*/
    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    /*Métodos de acceso de la Clase*/
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
