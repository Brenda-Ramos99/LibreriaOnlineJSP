package com.entidades;

/**
 * Nombre de la Clase: Editorial
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Editorial
{
    private int id_edit;
    private String telefono;
    private String nombre;
    private String pais;
    private String direccion;

    /*Método constructor vacío para inicializar la clase*/
    public Editorial()
    {
        
    }
    
    /*Método constructor de todos los campos disponible para una instancia al 
        momento de mostrar todos los datos provenientes de la tabla editorial en la 
        base de datos*/
    public Editorial(int id_edit, String telefono, String nombre, String pais,
            String direccion)
    {
        this.id_edit = id_edit;
        this.telefono = telefono;
        this.nombre = nombre;
        this.pais = pais;
        this.direccion = direccion;
    }

    
    /*Método constructor de todos los campos necesarios para una instancia al 
        momento de insertar datos provenientes de la tabla editorial en la base
        de datos (sin ID, ya que es autoincrementable)*/
    public Editorial(String telefono, String nombre, String pais,
            String direccion)
    {
        this.telefono = telefono;
        this.nombre = nombre;
        this.pais = pais;
        this.direccion = direccion;
    }

    
    /*Método constructor para el ID del editorial, necesario para realizar la 
        eliminación de registros a la tabla editorial en la base de datos*/
    public Editorial(int id_edit)
    {
        this.id_edit = id_edit;
    }

    /*Métodos de acceso de la Clase*/
    public int getId_edit() {
        return id_edit;
    }

    public void setId_edit(int id_edit) {
        this.id_edit = id_edit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }    
}
