package com.entidades;

/**
 * Nombre de la Clase:
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */

public class Detalle_prestamo
{
    private int id_detalle_prestamo;
    private Libro libro; //fk del código del libro prestado
    private Prestamo prestamo;//fk del codigo de prestamo generado
    private double subtotal;

    /*Método constructor vacío para inicializar la clase*/
    public Detalle_prestamo()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla detalle_prestamo en la 
    base de datos*/

    public Detalle_prestamo(int id_detalle_prestamo, Libro libro, Prestamo prestamo, double subtotal) {
        this.id_detalle_prestamo = id_detalle_prestamo;
        this.libro = libro;
        this.prestamo = prestamo;
        this.subtotal = subtotal;
    }
    
    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla detalle_prestamo en la 
    base de datos (sin ID, ya que es autoincrementable)*/
    public Detalle_prestamo(Libro libro, Prestamo prestamo, double subtotal) {
        this.libro = libro;
        this.prestamo = prestamo;
        this.subtotal = subtotal;
    }
    
    /*Método constructor para el ID del detalle de prestamo, necesario para 
    realizar la eliminación de registros a la tabla detalle de prestamo en la
    base de datos*/
    public Detalle_prestamo(int id_detalle_prestamo)
    {
        this.id_detalle_prestamo = id_detalle_prestamo;
    }

    /*Métodos de acceso de la Clase*/

    public int getId_detalle_prestamo() {
        return id_detalle_prestamo;
    }

    public void setId_detalle_prestamo(int id_detalle_prestamo) {
        this.id_detalle_prestamo = id_detalle_prestamo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
