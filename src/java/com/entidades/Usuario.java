package sistem.Entidades;

/**
 * Nombre de la Clase:Usuario
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Usuario
{
    private int id;
    private String user;
    private String pass;
    private int edad;
    private String direccion;
    private Rol rol;

    public Usuario(int id, String user, String pass, int edad, String direccion,
            Rol rol)
    {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.edad = edad;
        this.direccion = direccion;
        this.rol = rol;
    }

    public Usuario(String user, String pass, int edad, String direccion, Rol rol) {
        this.user = user;
        this.pass = pass;
        this.edad = edad;
        this.direccion = direccion;
        this.rol = rol;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
