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
public class DaoCompra extends Conexion implements Crud
{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Compra comp;
    Usuario usu;
    Rol rol;
    Membresia mem;
    
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from compra, usuario where compra.id_usuario=usuario.id_usuario and");
        try {
            rs=ps.executeQuery();
            while(rs.next())
            {
                mem = new Membresia(rs.getInt(9));
                rol = new Rol(rs.getInt(8));
                usu = new Usuario(rs.getInt(7), rol, mem, rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getInt(15));
                comp = new Compra(rs.getInt(1),rs.getString(2),rs.getDouble(3),usu);
                ar.add(comp);
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
        comp=(Compra)o;
        ps=super.con().prepareStatement("insert into compra(fecha_compra,IVA,total,id_usuario) values");
        ps.setString(1, comp.getFecha_compra());
        ps.setDouble(2, comp.getTotal());
        ps.setDouble(3, comp.getIVA());
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
        comp=(Compra)o;
        ps=super.con().prepareStatement("update compra set fecha=?,total=?,iva=?"
                + " where id_compra=?;");
        ps.setString(1, comp.getFecha_compra());
        ps.setDouble(2, comp.getTotal());
        ps.setDouble(3, comp.getIVA());
        ps.setInt(4, comp.getId_compra());
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
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        comp=(Compra)o;
        ps=super.con().prepareStatement("delete from compra where id_compra=?;");
        ps.setInt(1, comp.getId_compra());
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
        comp=(Compra)o;
        ps=super.con().prepareStatement("update compra set estado=1 where id_compra=?;");
        ps.setInt(1, comp.getId_compra());
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
