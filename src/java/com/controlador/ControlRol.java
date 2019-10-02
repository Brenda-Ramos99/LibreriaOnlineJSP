/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.entidades.*;
import com.modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brenda Ramos
 */
public class ControlRol extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            DaoRol ob1= new DaoRol();
            Rol rol;
            int r;
            RequestDispatcher res;
            if(request.getParameter("mostrar")!=null){
                try {
                    request.setAttribute("roles", ob1.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                }
                
            }
            
            else if(request.getParameter("btnGuardar")!=null){
                try {
                    
                    rol = new Rol(request.getParameter("rol"));
                    r=ob1.insertar(rol);
                    request.setAttribute("roles", ob1.mostrar());
                    if(r>0)
                        request.setAttribute("r", "El registro se ha insertado correctamente");
                    else
                        request.setAttribute("r", "Error al insertar el registro");
                } catch (Exception e) {
                    request.setAttribute("Error", e.getMessage());
                }
                
            }
            
            else if(request.getParameter("btnModificar")!=null){
                try {
                    rol = new Rol(Integer.parseInt(request.getParameter("id_rol")),request.getParameter("rol"));
                    r=ob1.modificar(rol);
                    request.setAttribute("roles", ob1.mostrar());
                    if(r>0)
                        request.setAttribute("r", "El registro se ha modificado correctamente");
                    else
                        request.setAttribute("r", "Error al modificar el registro");
                } catch (Exception e) {
                    request.setAttribute("Error", e.getMessage());
                }
                
            }

            else if(request.getParameter("btnEliminar")!=null){
                try {
                    
                    rol = new Rol(Integer.parseInt(request.getParameter("id_rol")));
                    r=ob1.eliminar(rol);
                    request.setAttribute("roles", ob1.mostrar());
                    if(r>0)
                        request.setAttribute("r", "Se ha eliminado correctamente el registro");
                    else
                        request.setAttribute("r", "Error al eliminar el registro");
                } catch (Exception e) {
                    request.setAttribute("Error", e.getMessage());
                }
                
            }
            
            else if(request.getParameter("btnEliLog")!=null){
                try {
                    
                    rol = new Rol(Integer.parseInt(request.getParameter("id_rol")));
                    r=ob1.eliLog(rol);
                    request.setAttribute("roles", ob1.mostrar());
                    if(r>0)
                        request.setAttribute("r", "El registro ha sido eliminado logicamente");
                    else
                        request.setAttribute("r", "Error al eliminar el registro logicamente");
                } catch (Exception e) {
                    request.setAttribute("Error", e.getMessage());
                }
                
            }
            res=request.getRequestDispatcher("vistaRol.jsp");
            res.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
