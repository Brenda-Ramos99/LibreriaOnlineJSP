package com.entidades;

/**
 * Nombre de la Clase: Detalle_compra
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */
public class Detalle_compra
{
    private int id_detalle_compra;
    private Libro libro;//fk de libro
    private Compra compra;//fk de compra
    private int cantidad;
    private double precio;
    private double subtotal;

    /*Método constructor vacío para inicializar la clase*/
    public Detalle_compra()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla detalle_compra
    en la base de datos*/

    public Detalle_compra(int id_detalle_compra, Libro libro, Compra compra,
            int cantidad, double precio, double subtotal)
    {
        this.id_detalle_compra = id_detalle_compra;
        this.libro = libro;
        this.compra = compra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }
    
    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla detalle_compra en la
    base de datos (sin ID, ya que es autoincrementable)*/

    public Detalle_compra(Libro libro, Compra compra, int cantidad, double precio, double subtotal) {
        this.libro = libro;
        this.compra = compra;
        this.cantidad = cantidad;
        this.precio = precio;
        this.subtotal = subtotal;
    }
    
    
    /*Método constructor para el ID del detalle_compra, necesario para realizar
    la eliminación de registros a la tabla detalle_compra en la base de datos*/
    public Detalle_compra(int id_detalle_compra)
    {
        this.id_detalle_compra = id_detalle_compra;
    }
    
    /*Métodos de acceso de la Clase*/

    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
}
