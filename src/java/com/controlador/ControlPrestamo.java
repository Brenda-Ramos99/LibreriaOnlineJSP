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
 * @author BymerGomez
 */
public class ControlPrestamo extends HttpServlet {

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
            //            ------------- variables----------------
            RequestDispatcher res;
            DaoLibro daoLib = new DaoLibro();
            DaoPrestamo daoPresta = new DaoPrestamo();
            DaoDetallePrestamo daoDp = new DaoDetallePrestamo();
//            -------------fin variables-------------  
            if(request.getParameter("mostrar")!=null){
                try {
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("prestamo", daoPresta.mostrar());
                } catch (Exception e) {
                    System.out.println("e: "+e.getMessage());
                    request.setAttribute("error", e.getMessage());
                }
            }
            else if(request.getParameter("btnEliminar")!=null){
                try {
                    if(daoPresta.eliminar(new Prestamo(Integer.parseInt(request.getParameter("id_prestamo"))))>1){
                        request.setAttribute("r", "Eliminado con exito");
                    }else{
                        request.setAttribute("r", "Error al eliminar...");
                    }
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("prestamo", daoPresta.mostrar());
                } catch (Exception e) {
                    System.out.println("e: "+e.getMessage());
                    request.setAttribute("error", e.getMessage());
                }
            }
            else if(request.getParameter("btnEliLog")!=null){
                try {
                    if(daoPresta.eliLog(new Prestamo(Integer.parseInt(request.getParameter("id_prestamo"))))>1){
                        request.setAttribute("r", "Eliminado con exito");
                    }else{
                        request.setAttribute("r", "Error al eliminar...");
                    }
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("prestamo", daoPresta.mostrar());
                } catch (Exception e) {
                    System.out.println("e: "+e.getMessage());
                    request.setAttribute("error", e.getMessage());
                }
            }
            else if(request.getParameter("cargar")!=null){
                try
                {
                    /*------PREGUNTAR :v----------------------------------------*/
                    request.setAttribute("id", request.getParameter("cargar"));
                    request.setAttribute("idUsuario", request.getParameter("idUsuario"));
                    request.setAttribute("detalleLibro", daoDp.mostrar(new Prestamo(Integer.parseInt(request.getParameter("cargar")))));
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("prestamo", daoPresta.mostrar());
                } catch (Exception e) {
                    System.out.println("e: "+e.getMessage());
                    request.setAttribute("error", e.getMessage());
                }
            }else if(request.getParameter("opcion")!=null){
                System.out.println(request.getParameter("-----------------------------"));
                if(request.getParameter("opcion").equals("nuevo")){
                    try
                    {   
                        Prestamo p = new Prestamo(request.getParameter("fecha_inicio"), request.getParameter("fecha_fin"),
                                Double.parseDouble(request.getParameter("total")),
                                new Usuario(Integer.parseInt(request.getParameter("id_cliente"))));
                        int r = daoPresta.insertar(p);
                        if(r>0){
                            int id=daoPresta.ultimoId();
                            String[] nuevos = request.getParameter("nuevosL").split(",");
                            int totalN = nuevos.length;
                            
                            for(int i=4;i<totalN;i+=5){
                                /*----------------------PRESGUNTAR :v -------------------------*/
                                DetallePrestamo depP = new DetallePrestamo(new Prestamo(id),
                                        new Libro(Integer.parseInt(nuevos[i-4])),
                                        Integer.parseInt(nuevos[i-2]),
                                        Double.parseDouble(nuevos[i])
                                );
                                daoDp.insertar(depP);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(request.getParameter("opcion").equals("modificar")){
                    /*Preguntar......................................*/
                    System.out.println(request.getParameter("id_prestamo"));
                    System.out.println(request.getParameter("fecha_inicio"));
                    System.out.println(request.getParameter("id_cliente"));
                    try {
                        Prestamo p = new Prestamo(Integer.parseInt(request.getParameter("id_prestamo")),
                                request.getParameter("fecha_inicio"), request.getParameter("fecha_fin"),
                                Double.parseDouble(request.getParameter("total")),
                                new Usuario(Integer.parseInt(request.getParameter("id_cliente"))));
                        int r = daoPresta.modificar(p);
                        if(r>0){
                            int id=Integer.parseInt(request.getParameter("id_prestamo"));
                            String[] nuevos = request.getParameter("nuevosL").split(",");
                            String[] modificar = request.getParameter("modificarL").split(",");
                            String[] eliminar = request.getParameter("eliminarL").split(",");
                            
                            int totalN = nuevos.length;
                            int totalM = modificar.length;
                            int totalE = eliminar.length;
                            
                            System.out.println(request.getParameter("id_prestamo"));
                            System.out.println(request.getParameter("nuevosL"));
                            System.out.println(request.getParameter("modificarL"));
                            System.out.println(request.getParameter("eliminarL"));
                            
                            for(int i=4;i<totalN;i+=5){
                                DetallePrestamo depP = new DetallePrestamo(new Prestamo(id),
                                        new Libro(Integer.parseInt(nuevos[i-4])),
                                        Integer.parseInt(nuevos[i-2]),
                                        Double.parseDouble(nuevos[i])
                                );
                                daoDp.insertar(depP);
                            }
                            
                            for(int i=5;i<totalM;i+=6){
//                                DetalleCompra depC = new DetalleCompra(
//                                        Integer.parseInt(modificar[i-5]),
//                                        new Compra(id),
//                                        new Libro(Integer.parseInt(modificar[i-4])), 
//                                        Integer.parseInt(modificar[i-2]), 
//                                        Double.parseDouble(modificar[i-1]), 
//                                        Double.parseDouble(modificar[i])
//                                );
                                DetallePrestamo depP = new DetallePrestamo(
                                       Integer.parseInt(modificar[i-5]),
                                       new Prestamo(id),
                                       new Libro(Integer.parseInt(modificar[i-4])), 
                                       Integer.parseInt(modificar[i-2]), 
                                       Double.parseDouble(modificar[i])
                               );
                                daoDp.modificar(depP);
                            }
                            
                            for(int i=0;i<totalE;i++){
                                DetallePrestamo depP = new DetallePrestamo(
                                        Integer.parseInt(eliminar[i])
                                );
                                daoDp.eliminar(depP);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            
            
            res = request.getRequestDispatcher("vistaPrestamo.jsp");
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