
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Rol {
    
    
    private int id_rol;
    private String rol;
    private int estado;

    public Rol() {
    }

    public Rol(int id_rol, String rol, int estado) {
        this.id_rol = id_rol;
        this.rol = rol;
        this.estado = estado;
    }

    public Rol(String rol, int estado) {
        this.rol = rol;
        this.estado = estado;
    }

    public Rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
    
}
