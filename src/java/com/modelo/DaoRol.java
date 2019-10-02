/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.Rol;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brenda Ramos
 */
public class DaoRol extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Rol rol;

    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from rol where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                rol=new Rol(rs.getInt(1), rs.getString(2));
                ar.add(rol);
            }
        } catch (Exception e) {
        }
        finally{
            ps.close();
            super.con().close();
        }
        return ar;
    }

    @Override
    public int insertar(Object o) throws SQLException, ClassNotFoundException {
        rol=(Rol)o;
        ps=super.con().prepareStatement("INSERT INTO `rol` (`rol`) "
                + "VALUES (?);");
        ps.setString(1, rol.getRol());
        try {
            res=ps.executeUpdate();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
        }
        return res;
    }

    @Override
    public int modificar(Object o) throws SQLException, ClassNotFoundException {
        rol=(Rol)o;
        ps=super.con().prepareStatement("UPDATE `rol` SET `rol` = ? "
                + "WHERE `rol`.`id_rol` = ?;");
        ps.setString(1, rol.getRol());
        ps.setInt(2, rol.getId_rol());
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
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        rol=(Rol)o;
        ps=super.con().prepareStatement("delete from `rol` WHERE"
                + " `rol`.`id_rol` = ?;");
        ps.setInt(1, rol.getId_rol());
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
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        rol=(Rol)o;
        ps=super.con().prepareStatement("UPDATE `rol` SET `estado` = '1' "
                + "WHERE `rol`.`id_rol` = ?;");
        ps.setInt(1, rol.getId_rol());
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
    
}
