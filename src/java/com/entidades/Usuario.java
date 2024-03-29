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
public class Usuario
{
    private int id_usuario;
    private Rol rol;
    private Membresia membresia;
    private String usuario;
    private String pass;
    private int edad;
    private String direccion;
    private int tarjeta;
    private int cvc;

    public Usuario()
    {
        
    }

    public Usuario(int id_usuario, Rol rol, Membresia membresia, String usuario,
            String pass, int edad, String direccion, int tarjeta, int cvc)
    {
        this.id_usuario = id_usuario;
        this.rol = rol;
        this.membresia = membresia;
        this.usuario = usuario;
        this.pass = pass;
        this.edad = edad;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.cvc = cvc;
    }

    public Usuario(Rol rol, Membresia membresia, String usuario, String pass,
            int edad, String direccion, int tarjeta, int cvc)
    {
        this.rol = rol;
        this.membresia = membresia;
        this.usuario = usuario;
        this.pass = pass;
        this.edad = edad;
        this.direccion = direccion;
        this.tarjeta = tarjeta;
        this.cvc = cvc;
    }

    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Membresia getMembresia() {
        return membresia;
    }

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public int getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(int tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
    
}
