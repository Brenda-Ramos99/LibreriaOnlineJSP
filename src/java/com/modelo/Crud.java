package com.modelo;
import java.sql.*;
import java.util.*;
/**
 *
 * @author Administrador
 */
public interface Crud 
{    
    public ArrayList<Object> mostrar() throws SQLException,ClassNotFoundException;
    public int insertar(Object o) throws SQLException,ClassNotFoundException;
    public int modificar(Object o) throws SQLException,ClassNotFoundException;
    public int eliminar(Object o) throws SQLException,ClassNotFoundException;
}
