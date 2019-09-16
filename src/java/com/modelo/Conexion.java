/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;
import java.sql.*;
/**
 *
 * @author Administrador
 */
public class Conexion {
    private String driver ="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://127.0.0.1:3306/biblioteca";
    private String user="root";
    private String password="";
    
    public Connection con()throws SQLException,ClassNotFoundException
    {
        Class.forName(driver);
        return DriverManager.getConnection(url,user,password);
    }
}
