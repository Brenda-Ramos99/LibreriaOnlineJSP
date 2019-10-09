/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.*;
import com.entidades.Categoria;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author BymerGomez
 */
public class DaoCategoria extends Conexion implements Crud
{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Categoria cat;

    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from categoria where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                cat=new Categoria(rs.getInt(1), rs.getString(2));
                ar.add(cat);
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
        cat=(Categoria)o;
        ps=super.con().prepareStatement("INSERT INTO `categoria` (`nombre_cat`) "
                + "VALUES (?);");
        ps.setString(1, cat.getNombre_cat());
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
        cat=(Categoria)o;
        ps=super.con().prepareStatement("UPDATE `categoria` SET `nombre_cat` = ? "
                + "WHERE `categoria`.`id_categoria` = ?;");
        ps.setString(1, cat.getNombre_cat());
        ps.setInt(2, cat.getId_categoria());
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
        cat=(Categoria)o;
        ps=super.con().prepareStatement("delete from `categoria` WHERE"
                + " `categoria`.`id_categoria` = ?;");
        ps.setInt(1, cat.getId_categoria());
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
        cat=(Categoria)o;
        ps=super.con().prepareStatement("UPDATE `categoria` SET `estado` = '1' "
                + "WHERE `categoria`.`id_categoria` = ?;");
        ps.setInt(1, cat.getId_categoria());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
