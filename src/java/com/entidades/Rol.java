package sistem.Entidades;

/**
 * Nombre de la Clase:Rol
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Rol
{
    private int id_rol;
    private String rol;

    /*Método constructor vacío para inicializar la clase*/
    public Rol()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla Rol en la 
    base de datos*/
    public Rol(int id_rol, String rol)
    {
        this.id_rol = id_rol;
        this.rol = rol;
    }

    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla Rol en la base de 
    datos (sin ID, ya que es autoincrementable)*/
    public Rol(String rol)
    {
        this.rol = rol;
    }

    /*Método constructor para el ID del Rol, necesario para realizar la 
    eliminación de registros a la tabla Rol en la base de datos*/
    public Rol(int id_rol) {
        this.id_rol = id_rol;
    }

    /*Métodos de acceso de la Clase*/
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
    
}
