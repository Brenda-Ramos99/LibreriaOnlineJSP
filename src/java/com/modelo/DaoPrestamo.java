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
public class DaoPrestamo extends Conexion implements Crud
{
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    Prestamo presta;
    
    @Override
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from prestamo where estado=0");
        try {
            rs=ps.executeQuery();
            while(rs.next()){
                presta=new Prestamo(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getDouble(5));
                ar.add(presta);
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
        presta=(Prestamo)o;
        ps=super.con().prepareStatement("insert into prestamo(fecha_inicio,"
                + "fecha_final,estado,total) values(?,?,?,0,?);");
        ps.setString(1, presta.getFecha_inicio());
        ps.setString(2, presta.getFecha_final());
        ps.setInt(3, presta.getEstado());
        ps.setDouble(4, presta.getTotal());
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
        presta=(Prestamo)o;
        ps=super.con().prepareStatement("update prestamo set fecha_inicio=?,"
                + "fecha_final=?,total=? where id_prestamo=?;");
        ps.setString(1, presta.getFecha_inicio());
        ps.setString(2, presta.getFecha_final());
        ps.setDouble(3, presta.getTotal());
        ps.setInt(4, presta.getId_prestamo());
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
        presta=(Prestamo)o;
        ps=super.con().prepareStatement("delete from prestamo where id_prestamo=?;");
        ps.setInt(1, presta.getId_prestamo());
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
    public int eliLog(Object o) throws SQLException, ClassNotFoundException {
        presta=(Prestamo)o;
        ps=super.con().prepareStatement("update prestamo set estado=1 where id_prestamo=?;");
        ps.setInt(1, presta.getId_prestamo());
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
}
