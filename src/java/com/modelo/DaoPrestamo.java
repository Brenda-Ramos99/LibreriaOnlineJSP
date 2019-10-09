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
    Usuario usu;
    Rol rol;
    Membresia mem;
    
    
    public int ultimoId() throws SQLException, ClassNotFoundException
    {
        int id = 0;
        ps=super.con().prepareStatement("select max(id_prestamo) from compra where estado = 0");
        try
        {
            rs=ps.executeQuery();
            while(rs.next())
            {
                id = rs.getInt(1);
            }
        }
        catch (Exception e)
        {
            
        }
        finally
        {
            ps.close();
            super.con().close();
        }
        return id;
    }
    public ArrayList<Object> mostrar() throws SQLException, ClassNotFoundException {
        ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from compra, usuario where compra.id_usuario=usuario.id_usuario and compra.estado = 0");
        try {
            rs=ps.executeQuery();
            while(rs.next())
            {
                mem = new Membresia(rs.getInt(9));
                rol = new Rol(rs.getInt(8));
                usu = new Usuario(rs.getInt(7), rol, mem, rs.getString(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getInt(14), rs.getInt(15));
                presta = new Prestamo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), usu);
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
        ps=super.con().prepareStatement("INSERT INTO prestamo(fecha_inicio, fecha_fin, total, id_usuario) VALUES (?,?,?,?);");
        ps.setString(1, presta.getFecha_inicio());
        ps.setString(2, presta.getFecha_fin());
        ps.setDouble(3, presta.getTotal());
        ps.setInt(4, presta.getUsuario().getId_usuario());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("ec: "+e.getMessage());
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
        ps=super.con().prepareStatement("UPDATE prestamo set fecha_inicio=?, fecha_fin=?, total=?, id_usuario=? where id_prestamo=?;");
        ps.setString(1, presta.getFecha_inicio());
        ps.setString(2, presta.getFecha_fin());
        ps.setDouble(3, presta.getTotal());
        ps.setInt(4, presta.getUsuario().getId_usuario());
        ps.setInt(5, presta.getId_prestamo());
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
        ps=super.con().prepareStatement("delete from prestamo where id_prestamo=?");
        ps.setInt(1, presta.getId_prestamo());
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
        presta=(Prestamo)o;
        ps=super.con().prepareStatement("update prestamo set estado=1 where id_prestamo=?;");
        ps.setInt(1, presta.getId_prestamo());
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
