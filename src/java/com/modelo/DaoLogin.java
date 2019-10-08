/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.Rol;
import com.entidades.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author william Villatoro
 */
public class DaoLogin extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    int res;
    Usuario user;
    Rol rol;
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertar(Object o) throws SQLException, ClassNotFoundException {
        user=(Usuario)o;
        ps=super.con().prepareStatement("insert into usuario(id_rol,id_membresia,"
                + "usuario,pass,edad,direccion,tarjeta,cvc)values(?,?,?,?,"
                + "?,?,?,?)");
        ps.setInt(1, user.getRol().getId_rol());
        ps.setInt(2, user.getMembresia().getId_membresia());
        ps.setString(3, user.getUsuario());
        ps.setString(4, user.getPass());
        ps.setInt(5, user.getEdad());
        ps.setString(6, user.getDireccion());
        ps.setInt(7, user.getTarjeta());
        ps.setInt(8, user.getCvc());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }finally{
        ps.close();
        super.con().close();
        }
        return  res;
    }
    
   

    @Override
    public int modificar(Object o) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public int usuario(Object o) throws SQLException, ClassNotFoundException {
        user=(Usuario)o;
        ps=super.con().prepareStatement("select count(*) from usuario where user=?");
        ps.setString(1, user.getUsuario());
        try {
            rs=ps.executeQuery();
            if(rs.next()){
            return rs.getInt(1);
        }
            return 1;
        } 
        catch (Exception e) {
        }
        finally{
        ps.close();
        super.con().close();
        }
        return  1;
    }
    
}
