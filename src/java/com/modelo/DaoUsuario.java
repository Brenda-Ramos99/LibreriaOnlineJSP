/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.NotFoundException;

/**
 *
 * @author william Villatoro
 */
public class DaoUsuario {
   Conex db=new Conex();
   String sql="";
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    public int rol(String usuario, String pass){
    int id_rol=0;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            sql="select id_rol from usuario where usuario=? and pass=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
            id_rol=rs.getInt(1);
            }
            con.close();
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            
        }
        return id_rol;
    }
    
    public int validar(String usuario, String pass){
    int id_rol=0;
        try {
            Class.forName(db.getDriver());
            con=DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
            sql="select id_usuario from usuario where usuario=? and pass=?";
            ps=con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            while(rs.next()){
            id_rol=rs.getInt(1);
            }
            con.close();
            rs.close();
            ps.close();
        } catch (SQLException | ClassNotFoundException e) {
            
        }
        return id_rol;
    }
    
}
