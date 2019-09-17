package com.entidades;

/**
 * Nombre de la Clase: Compra
 * Versión: 1.0
 * Fecha: 23/08/2019
 * Copyright: ITCA-FEPADE
 * @author Elvis Adalberto Alfaro Gómez
 */
public class Compra
{
    private int id_compra;
    private String fecha;
    private double total;
    private double IVA=0.13;
    private int estado;

    /*Método constructor vacío para inicializar la clase*/
    public Compra()
    {
        
    }

    /*Método constructor de todos los campos disponible para una instancia al 
    momento de mostrar todos los datos provenientes de la tabla compra en la 
    base de datos*/

    public Compra(int id_compra, String fecha, double total, int estado) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    public Compra(int id_compra, String fecha, double total) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.total = total;
    }

    
    
    /*Método constructor de todos los campos necesarios para una instancia al 
    momento de insertar datos provenientes de la tabla compra en la base de 
    datos (sin ID, ya que es autoincrementable)*/
    public Compra(String fecha, double total, int estado)
    {
        this.fecha = fecha;
        this.total = total;
        this.estado = estado;
    }

    /*Método constructor para el ID del compra, necesario para realizar la
    eliminación de registros a la tabla compra en la base de datos*/
    public Compra(int id_compra) {
        this.id_compra = id_compra;
    }

    /*Métodos de acceso de la Clase*/

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
