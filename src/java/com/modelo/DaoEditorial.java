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
 * @author Eduardo Recinos
 */
public class DaoEditorial extends Conexion implements Crud{
    
     PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Editorial edit;
    

    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException
    {
         ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from editorial where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                edit=new Editorial(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ar.add(edit);
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
        edit=(Editorial)o;
        ps=super.con().prepareStatement("insert into editorial(nombre,direccion,pais,telefono) values(?,?,?,?)");
        ps.setString(1, edit.getNombre());
        ps.setString(2,edit.getDireccion());
        ps.setString(3,edit.getPais());
        ps.setString(4,edit.getTelefono());
        try {
            res=ps.executeUpdate();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
            super.con().close();
        }
        return res;
    }

    @Override
    public int modificar(Object o) throws SQLException, ClassNotFoundException {
        edit=(Editorial)o;
        ps=super.con().prepareStatement("update editorial set nombre=?,direccion=?,pais=?,telefono=? where id_editorial=?");
        ps.setString(1, edit.getNombre());
        ps.setString(2,edit.getDireccion());
        ps.setString(3,edit.getPais());
        ps.setString(4,edit.getTelefono());
        ps.setInt(5, edit.getId_editorial());
        try {
            res=ps.executeUpdate();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
            super.con().close();
        }
        return res;        
    }

    @Override
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        edit=(Editorial)o;
        ps=super.con().prepareStatement("delete from editorial where id_editorial=?");

        ps.setInt(1, edit.getId_editorial());
        try {
            res=ps.executeUpdate();
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
            super.con().close();
        }
        return res;
    }

    @Override
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        edit=(Editorial)o;
        ps=super.con().prepareStatement("update editorial set estado=1 where id_editorial=?");
        ps.setInt(1, edit.getId_editorial());
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
