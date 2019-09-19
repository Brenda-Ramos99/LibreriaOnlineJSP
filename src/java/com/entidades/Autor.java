package com.entidades;

/**
 * Nombre de la Clase: Autor
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */
public class Autor
{
    private int id_autor;
    private String seudonimo;
    private String nombre;
    private String genero;
    private String nacionalidad;
    private int estado;

    /*Método constructor vacío para inicializar la clase*/
    public Autor()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla autor en la 
    base de datos*/
    
    public Autor(int id_autor,String seudonimo, String nombre, String genero, String nacionalidad, int estado)
    {
        this.id_autor = id_autor;
        this.seudonimo = seudonimo;
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
    }

    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla autor en la base de 
    datos (sin ID, ya que es autoincrementable)*/
    
    public Autor(String seudonimo, String nombre, String genero, String nacionalidad, int estado)
    {
        this.seudonimo = seudonimo;
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.estado = estado;
    }

 
    /*Método constructor para el ID del autor, necesario para realizar la 
    eliminación de registros a la tabla autor en la base de datos*/
    public Autor(int id_autor)
    {
        this.id_autor = id_autor;
    }
    
    /*Metodo para mostrar todos los campos excepto el estado*/

    public Autor(int id_autor, String seudonimo, String nombre, String genero,
            String nacionalidad)
    {
        this.id_autor = id_autor;
        this.seudonimo = seudonimo;
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
    }
    

    /*Métodos de acceso de la Clase*/
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

    public String getSeudonimo() {
        return seudonimo;
    }

    public void setSeudonimo(String seudonimo) {
        this.seudonimo = seudonimo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
