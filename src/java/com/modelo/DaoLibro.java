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
 * @author BymerGomez
 */
public class DaoLibro extends Conexion implements Crud{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Libro lb;
    Autor aut;
    Categoria cat;
    
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException
    {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from libro as l inner join categoria as cat on l.id_categoria = cat.id_categoria inner join autor as au on l.id_autor = au.id_autor where l.estado=0;");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                aut=new Autor(rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16), rs.getString(17));
                cat= new Categoria(rs.getInt(10), rs.getString(11));
                lb= new Libro(rs.getInt(1), cat, aut, rs.getString(4), rs.getInt(5), rs.getInt(6),rs.getString(7),rs.getDouble(8));
                ar.add(lb);
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
        lb=(Libro)o;
        ps=super.con().prepareStatement("insert into libro(id_categoria,"
                + "id_autor,titulo,tomo,existencias,anio_public,precio) values(?,?,?,?,?,?,?)");
        ps.setInt(1, lb.getId_categoria().getId_categoria());
        ps.setInt(2, lb.getIdAutor().getId_autor());
        ps.setString(3,lb.getTitulo());
        ps.setInt(4,lb.getTomo());
        ps.setInt(5,lb.getExistencias());
        ps.setString(6,lb.getAnio_public());
        ps.setDouble(7,lb.getPrecio());
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
        
      lb=(Libro)o;
        ps=super.con().prepareStatement("update libro set id_categoria=?,"
                + "id_autor=?,titulo=?,tomo=?,existencias=?,anio_public=?,"
                + "precio=? where id_libro=?");
        ps.setInt(1, lb.getId_categoria().getId_categoria());
        ps.setInt(2, lb.getIdAutor().getId_autor());
        ps.setString(3,lb.getTitulo());
        ps.setInt(4,lb.getTomo());
        ps.setInt(5,lb.getExistencias());
        ps.setString(6,lb.getAnio_public());
        ps.setDouble(7,lb.getPrecio());
        ps.setInt(8,lb.getId_libro());

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
    lb=(Libro)o;
    ps=super.con().prepareStatement("delete from libro where id_libro=?");
        
        ps.setInt(1, lb.getId_libro());
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
        
        lb=(Libro)o;
        ps=super.con().prepareStatement("update libro set estado=1 where id_libro=?");
        
        ps.setInt(1, lb.getId_libro());
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
    public int usuario(Object o) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
