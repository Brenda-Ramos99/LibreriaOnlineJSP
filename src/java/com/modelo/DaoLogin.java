/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.Membresia;
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
    Membresia mem;
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from usuario as usu inner join rol as r on usu.id_rol = r.id_rol inner join membresia as mem on usu.id_membresia = mem.id_membresia where usu.estado=0;");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                mem = new Membresia(rs.getInt(14),rs.getString(15),rs.getDouble(16));
                rol = new Rol(rs.getInt(11),rs.getString(12));
                user = new Usuario(rs.getInt(1),
                        rol, mem, rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getInt(9));
                ar.add(user);
            }
        } catch (Exception e) {
        }
        finally{
            ps.close();
            super.con().close();
        }
        return ar;    }

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
        user=(Usuario)o;
        ps=super.con().prepareStatement("update usuario into id_rol=? ,id_membresia =?"
                + "usuario=?,pass=?,edad=?,direccion=?,tarjeta=?,cvc=?,estado=? where id_usuario=?");
        ps.setInt(1, user.getRol().getId_rol());
        ps.setInt(2, user.getMembresia().getId_membresia());
        ps.setString(3, user.getUsuario());
        ps.setString(4, user.getPass());
        ps.setInt(5, user.getEdad());
        ps.setString(6, user.getDireccion());
        ps.setInt(7, user.getTarjeta());
        ps.setInt(8, user.getCvc());
        ps.setInt(9, user.getId_usuario());
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
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        user=(Usuario)o;
        ps=super.con().prepareStatement("delete from `usuario` WHERE `id_usuario` = ?;");
        ps.setInt(1, user.getId_usuario());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            ps.close();
            super.con().close();
        }
        return res;    }

    @Override
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        user=(Usuario)o;
        ps=super.con().prepareStatement("UPDATE `usuario` SET `estado` = '1' "
                + "WHERE `id_usuario` = ?;");
        ps.setInt(1, user.getId_usuario());
        try {
            res=ps.executeUpdate();
        } catch (Exception e) {
        }
        finally{
            ps.close();
            super.con().close();
        }
        return res;
    }    

    @Override
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
