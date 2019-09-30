
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Editorial {
    
    
    private int id_editorial;
    private String nombre;
    private String direccion;
    private String pais;
    private String telefono;

    public Editorial() {
    }

    public Editorial(int id_editorial, String nombre, String direccion,
            String pais, String telefono)
    {
        this.id_editorial = id_editorial;
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Editorial(String nombre, String direccion, String pais,
            String telefono)
    {
        this.nombre = nombre;
        this.direccion = direccion;
        this.pais = pais;
        this.telefono = telefono;
    }

    public Editorial(int id_editorial)
    {
        this.id_editorial = id_editorial;
    }

    public int getId_editorial() {
        return id_editorial;
    }

    public void setId_editorial(int id_editorial) {
        this.id_editorial = id_editorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
