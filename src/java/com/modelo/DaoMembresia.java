/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brenda Ramos
 */
public class DaoMembresia extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Membresia mem;

    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from membresia where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                mem=new Membresia(rs.getInt(1), rs.getString(2),rs.getDouble(3));
                ar.add(mem);
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
        mem=(Membresia)o;
        ps=super.con().prepareStatement("INSERT INTO `membresia`(`tipo_membresia`,`precio_membresia`) "
                + "VALUES (?,?);");
        ps.setString(1, mem.getTipo_membresia());
        ps.setDouble(2 ,mem.getPrecio_membresia());
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
        mem=(Membresia)o;
        ps=super.con().prepareStatement("UPDATE `membresia` SET `tipo_membresia` = ?,"
                + "`precio_membresia`=? WHERE `id_membresia` = ?;");
        ps.setString(1, mem.getTipo_membresia());
        ps.setDouble(2, mem.getPrecio_membresia());
        ps.setInt(3, mem.getId_membresia());
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
        mem=(Membresia)o;
        ps=super.con().prepareStatement("delete from `membresia` WHERE `id_membresia` = ?;");
        ps.setInt(1, mem.getId_membresia());
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
        mem=(Membresia)o;
        ps=super.con().prepareStatement("UPDATE `membresia` SET `estado` = '1' "
                + "WHERE `id_membresia` = ?;");
        ps.setInt(1, mem.getId_membresia());
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
