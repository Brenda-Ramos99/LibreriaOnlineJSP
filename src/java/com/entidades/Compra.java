/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

/**
 *
 * @author william villatoro
 */
public class Compra
{
    private int id_compra;
    private String fecha_compra;
    private double IVA=0.13;
    private double total;
    private Usuario usuario;

    public Compra() {
    }

    public Compra(int id_compra, String fecha_compra, double total, Usuario usuario) {
        this.id_compra = id_compra;
        this.fecha_compra = fecha_compra;
        this.total = total;
        this.usuario = usuario;
    }

    public Compra(String fecha_compra, double total, Usuario usuario) {
        this.fecha_compra = fecha_compra;
        this.total = total;
        this.usuario = usuario;
    }

    public Compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha_compra() {
        return fecha_compra;
    }

    public void setFecha_compra(String fecha_compra) {
        this.fecha_compra = fecha_compra;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
