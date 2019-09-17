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
            while (rs.next())
            {                
                autor=new Autor();
                ar.add(autor);
            }
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
        }
        return ar;
    }

    @Override
    public int insertar(Object o) throws SQLException, ClassNotFoundException {
        autor=(Autor)o;
        ps=super.con().prepareStatement("insert into autor (nombre, seudonimo,"
                + "genero,nacionalidad,estado, id_autor) values (?,?,?,?,?,?)");
        ps.setString(1, autor.getNombre());
        ps.setString(2,autor.getNombre());
        ps.setString(3,autor.getSeudonimo());
        ps.setString(4,autor.getGenero());
        ps.setString(5,autor.getNacionalidad());
        ps.setInt(2, autor.getId_depto().getId_depto());//devuelve primero el departamento y luego el id del mismo
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
