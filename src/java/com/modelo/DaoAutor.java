/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import com.entidades.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Brenda Ramos
 */
public class DaoAutor extends Conexion implements Crud
{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Autor autor;
    
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from autor where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                autor=new Autor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                ar.add(autor);
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
        autor=(Autor)o;
        ps=super.con().prepareStatement("INSERT INTO `autor` (`nombre`,"
                + " `seudonimo`, `genero`, `nacionalidad`) "
                + "VALUES (?,?,?,?);");
        ps.setString(1, autor.getNombre());
        ps.setString(2,autor.getSeudonimo());
        ps.setString(3,autor.getGenero());
        ps.setString(4,autor.getNacionalidad());
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
        autor=(Autor)o;
        ps=super.con().prepareStatement("update `autor` set `nombre`=?,`seudonimo` =?, `genero`=?, `nacionalidad`=? where id_autor=?;");
        ps.setString(1, autor.getNombre());
        ps.setString(2,autor.getSeudonimo());
        ps.setString(3,autor.getGenero());
        ps.setString(4,autor.getNacionalidad());
        ps.setInt(5, autor.getId_autor());
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
        autor = (Autor)o;
        ps= super.con().prepareStatement("delete from autor where id_autor=?");
        ps.setInt(1, autor.getId_autor());
        try {
            res=ps.executeUpdate();
        } catch (Exception e)
        {
        }
        finally
        {
            super.con().close();
            ps.close();
        }
        return res;
    }

    @Override
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        autor=(Autor)o;
        ps=super.con().prepareStatement("update autor set estado=1 where id_autor=?;");
        ps.setInt(1, autor.getId_autor());
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
