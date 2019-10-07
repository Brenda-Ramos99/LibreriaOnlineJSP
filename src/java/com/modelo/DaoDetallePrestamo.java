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
public class DaoDetallePrestamo extends Conexion {
    PreparedStatement ps;
    ResultSet rs;
    int res=0;
    DetallePrestamo detap;
    
    
    public ArrayList<Object> mostrar(Prestamo ob) throws SQLException, ClassNotFoundException {
         ArrayList<Object> ar = new ArrayList<>();
        ps=super.con().prepareStatement("select * from detalle_prestamo, libro where detalle_prestamo.estado != 1 and detalle_prestamo.id_libro=libro.id_libro and detalle_prestamo.id_prestamo=?;");
        ps.setInt(1, ob.getId_prestamo());
        try {
            rs=ps.executeQuery();
            while(rs.next())
            {
                Libro lib = new Libro();
                lib.setId_libro(rs.getInt(7));
                lib.setTitulo(rs.getString(10));
                detap = new DetallePrestamo(rs.getInt(1), new Prestamo(2), lib, rs.getInt(4), rs.getDouble(5));
                ar.add(detap);
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
        detap=(DetallePrestamo)o;
        ps=super.con().prepareStatement("INSERT INTO `biblioteca`.`detalle_prestamo` (`id_prestamo`, `id_libro`, `cantidad`, `subtotal`) VALUES (?,?,?,?);");
        ps.setInt(1, detap.getPrestamo().getId_prestamo());
        ps.setInt(2, detap.getLibro().getId_libro());
        ps.setInt(3, detap.getCantidad());
        ps.setDouble(4, detap.getSubtotal());
        try
        {
            res=ps.executeUpdate();
        }
        catch (Exception e)
        {
            System.out.println("edc: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    public int modificar(Object o) throws SQLException, ClassNotFoundException {
        detap=(DetallePrestamo)o;
        //ps=super.con().prepareStatement("UPDATE `biblioteca`.`detalle_compra` set `id_compra`=?, `id_libro`=?, `cantidad`=?, `precio`=?, `subtotal`=? WHERE id_detalle_compra=?");
        ps=super.con().prepareStatement("UPDATE `biblioteca`.`detalle_prestamo` SET `id_prestamo` = ?, `id_libro` = ?, `cantidad` = ?, `subtotal` = ? WHERE (`id_detalle_prestamo` = ?);");
        ps.setInt(1, detap.getPrestamo().getId_prestamo());
        ps.setInt(2, detap.getLibro().getId_libro());
        ps.setInt(3, detap.getCantidad());
        ps.setDouble(4, detap.getSubtotal());
        ps.setInt(6, detap.getId_detalle_prestamo());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("edc: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    public int eliminar(Object o) throws SQLException, ClassNotFoundException {
        detap=(DetallePrestamo)o;
        ps=super.con().prepareStatement("DELETE FROM `biblioteca`.`detalle_prestamo` WHERE (`id_detalle_prestamo` = ?);");
        ps.setInt(1, detap.getId_detalle_prestamo());
        
        try {
            res=ps.executeUpdate();
            
        }
        catch (Exception e)
        {
            System.out.println("edc: "+e.getMessage());
        }
        finally
        {
            ps.close();
        }
        return res;
    }
    
}
