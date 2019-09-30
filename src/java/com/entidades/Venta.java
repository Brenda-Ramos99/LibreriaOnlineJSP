
package com.entidades;

/**
 *
 * @author Eduardo Recinos
 */
public class Venta
{
    private int id_venta;
    private Editorial editorial;
    private String fecha;
    private double iva;
    private double total;

    public Venta()
    {
        
    }

    public Venta(int id_venta, Editorial editorial, String fecha, double iva,
            double total)
    {
        this.id_venta = id_venta;
        this.editorial = editorial;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
    }

    public Venta(Editorial editorial, String fecha, double iva, double total)
    {
        this.editorial = editorial;
        this.fecha = fecha;
        this.iva = iva;
        this.total = total;
    }

    public Venta(int id_venta)
    {
        this.id_venta = id_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
