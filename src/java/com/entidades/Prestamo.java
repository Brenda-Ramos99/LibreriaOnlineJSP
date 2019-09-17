package com.entidades;

/**
 * Nombre de la Clase:
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */
public class Prestamo
{
    private int id_prestamo;
    private String fecha_inicio;
    private String fecha_final;
    private double total;
    private int estado;

    /*Método constructor vacío para inicializar la clase*/
    public Prestamo()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla prestamo en la 
    base de datos*/

    public Prestamo(int id_prestamo, String fecha_inicio, String fecha_final, double total, int estado) {
        this.id_prestamo = id_prestamo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.total = total;
        this.estado = estado;
    }

    public Prestamo(int id_prestamo, String fecha_inicio, String fecha_final, double total) {
        this.id_prestamo = id_prestamo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.total = total;
    }

    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla prestamo en la base de 
    datos (sin ID, ya que es autoincrementable)*/

    public Prestamo(String fecha_inicio, String fecha_final, double total, int estado) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_final = fecha_final;
        this.total = total;
        this.estado = estado;
    }
    

    /*Método constructor para el ID del Libro, necesario para realizar la 
    eliminación de registros a la tabla Libro en la base de datos*/
    public Prestamo(int id_prestamo)
    {
        this.id_prestamo = id_prestamo;
    }

    /*Métodos de acceso de la Clase*/

    public int getId_prestamo() {
        return id_prestamo;
    }

    public void setId_prestamo(int id_prestamo) {
        this.id_prestamo = id_prestamo;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_final() {
        return fecha_final;
    }

    public void setFecha_final(String fecha_final) {
        this.fecha_final = fecha_final;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
}
