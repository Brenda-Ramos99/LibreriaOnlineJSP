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
public class DaoDetalleCompra extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    DetalleCompra dep;
    
    
    public ArrayList<Object> mostrar(Compra ob) throws SQLException, ClassNotFoundException {
         ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("SELECT * FROM detalle_compra,libro "
                + "where detalle_compra.estado = 0 and detalle_compra.id_libro=libro.id_libro "
                + "and detalle_compra.id_compra=?;");
        ps.setInt(1, ob.getId_compra());
        try {
            rs=ps.executeQuery();
            while(rs.next())
            {
                Libro lib = new Libro();
                lib.setId_libro(rs.getInt(8));
                lib.setTitulo(rs.getString(11));
                dep = new DetalleCompra(rs.getInt(1), new Compra(rs.getInt(2)), lib, rs.getInt(4), rs.getDouble(5), rs.getDouble(6));//La instancia COmpra no sería 2???
                ar.add(dep);
            }
        } catch (Exception e) {
            System.out.println("error: "+e.getMessage());
        }
        finally{
            ps.close();
            super.con().close();
        }
        return ar;
    }
    public int insertar(Object o) throws SQLException, ClassNotFoundException {
        dep=(DetalleCompra)o;
        ps=super.con().prepareStatement("INSERT INTO `biblioteca`.`detalle_compra` "
                + "(`id_compra`, `id_libro`, `cantidad`, `precio`, `subtotal`, `estado`) "
                + "VALUES (?, ?, ?, ?, ?, 0);");
        ps.setInt(1, dep.getCompra().getId_compra());
        ps.setInt(2, dep.getLibro().getId_libro());
        ps.setDouble(3, dep.getCantidad());
        ps.setDouble(4, dep.getPrecio());
        ps.setDouble(5, dep.getSubtotal());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("insertar: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    public int modificar(Object o) throws SQLException, ClassNotFoundException {
        dep=(DetalleCompra)o;
        ps=super.con().prepareStatement("UPDATE `biblioteca`.`detalle_compra` set "
                + "`id_compra`=?, `id_libro`=?, `cantidad`=?, `precio`=?, `subtotal`=? "
                + "WHERE id_detalle_compra=?");
        ps.setInt(1, dep.getCompra().getId_compra());
        ps.setInt(2, dep.getLibro().getId_libro());
        ps.setDouble(3, dep.getCantidad());
        ps.setDouble(4, dep.getPrecio());
        ps.setDouble(5, dep.getSubtotal());
        ps.setInt(6, dep.getId_detalle_compra());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("modificar: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        dep=(DetalleCompra)o;
        ps=super.con().prepareStatement("DELETE FROM `detalle_compra`  WHERE id_detalle_compra=?");
        ps.setInt(1, dep.getId_detalle_compra());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("elimiar: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    
}
