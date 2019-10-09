/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import com.entidades.Compra;
import com.entidades.DetalleCompra;
import com.entidades.Libro;
import com.entidades.Usuario;
import com.modelo.DaoCompra;
import com.modelo.DaoDetalleCompra;
import com.modelo.DaoLibro;
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
public class ControlCompra extends HttpServlet {

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
            DaoCompra daoCompra = new DaoCompra();
            DaoDetalleCompra daoDc=new DaoDetalleCompra();
//            -------------fin variables-------------  
            if(request.getParameter("mostrar")!=null){
                try {
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("compra", daoCompra.mostrar());
                } catch (Exception e) {
                    System.out.println("e: "+e.getMessage());
                    request.setAttribute("error", e.getMessage());
                }
            }
            else if(request.getParameter("btnEliminar")!=null){
                try {
                    if(daoCompra.eliminar(new Compra(Integer.parseInt(request.getParameter("id_compra"))))>1){
                        request.setAttribute("r", "Eliminado con exito");
                    }else{
                        request.setAttribute("r", "Error al eliminar...");
                    }
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("compra", daoCompra.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("e: "+e.getMessage());
                }
            }
            else if(request.getParameter("btnEliLog")!=null){
                try {
                    if(daoCompra.eliLog(new Compra(Integer.parseInt(request.getParameter("id_compra"))))>1){
                        request.setAttribute("r", "Eliminado con exito");
                    }else{
                        request.setAttribute("r", "Error al eliminar...");
                    }
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("compra", daoCompra.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("e: "+e.getMessage());
                }
            }
            else if(request.getParameter("cargar")!=null){
                try {
                    
                    request.setAttribute("id", request.getParameter("cargar"));
                    request.setAttribute("idUsuario", request.getParameter("idUsuario"));
                    request.setAttribute("detalleLibro", daoDc.mostrar(new Compra(Integer.parseInt(request.getParameter("cargar")))));
                    request.setAttribute("libros", daoLib.mostrar());
                    request.setAttribute("compra", daoCompra.mostrar());
                } catch (Exception e) {
                    request.setAttribute("error", e.getMessage());
                    System.out.println("e: "+e.getMessage());
                }
            }else if(request.getParameter("opcion")!=null){
                
                if(request.getParameter("opcion").equals("nuevo")){
                    try {
                        Compra c = new Compra(request.getParameter("fecha_compra"),
                            Double.parseDouble(request.getParameter("total")), 
                            new Usuario(Integer.parseInt(request.getParameter("id_cliente"))));
                        int r = daoCompra.insertar(c);
                        if(r>0){
                            int id=daoCompra.ultimoId();
                            String[] nuevos = request.getParameter("nuevosL").split(",");
                            int totalN = nuevos.length;
                            
                            for(int i=4;i<totalN;i+=5){
                                DetalleCompra depC = new DetalleCompra(new Compra(id),
                                        new Libro(Integer.parseInt(nuevos[i-4])), 
                                        Integer.parseInt(nuevos[i-2]), 
                                        Double.parseDouble(nuevos[i-1]), 
                                        Double.parseDouble(nuevos[i])
                                );
                                daoDc.insertar(depC);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                else if(request.getParameter("opcion").equals("modificar")){
                    System.out.println("-----------------------------");
                    System.out.println("-----------------------------");
                    System.out.println("----data compra-------");
                    System.out.println(request.getParameter("id_compra"));
                    System.out.println(request.getParameter("fecha_compra"));
                    System.out.println(request.getParameter("id_cliente"));
                    System.out.println("----fi data compra-------");
                    try {
                        Compra c = new Compra(Integer.parseInt(request.getParameter("id_compra")),
                                request.getParameter("fecha_compra"),
                            Double.parseDouble(request.getParameter("total")), 
                            new Usuario(Integer.parseInt(request.getParameter("id_cliente"))));
                        int r = daoCompra.modificar(c);
                        System.out.println("result: "+r);
                        if(r>0){
                            int id=Integer.parseInt(request.getParameter("id_compra"));
                            String[] nuevos = request.getParameter("nuevosL").split(",");
                            String[] modificar = request.getParameter("modificarL").split(",");
                            String[] eliminar = request.getParameter("eliminarL").split(",");
                            
                            int totalN = nuevos.length;
                            int totalM = modificar.length;
                            int totalE = eliminar.length;
                            System.out.println("----data-------");
                            System.out.println(request.getParameter("id_compra"));
                            System.out.println(request.getParameter("nuevosL"));
                            System.out.println(request.getParameter("modificarL"));
                            System.out.println(request.getParameter("eliminarL"));
                            System.out.println("----fi data-------");
                            System.out.println("-----");
                            for(int i=4;i<totalN;i+=5){
                                DetalleCompra depC = new DetalleCompra(new Compra(id),
                                        new Libro(Integer.parseInt(nuevos[i-4])), 
                                        Integer.parseInt(nuevos[i-2]), 
                                        Double.parseDouble(nuevos[i-1]), 
                                        Double.parseDouble(nuevos[i])
                                );
                                System.out.println("isertar: "+daoDc.insertar(depC));
                                
                            }
                            
                            for(int i=5;i<totalM;i+=6){
                                DetalleCompra depC = new DetalleCompra(
                                        Integer.parseInt(modificar[i-5]),
                                        new Compra(id),
                                        new Libro(Integer.parseInt(modificar[i-4])), 
                                        Integer.parseInt(modificar[i-2]), 
                                        Double.parseDouble(modificar[i-1]), 
                                        Double.parseDouble(modificar[i])
                                );
                                System.out.println("modificar: "+daoDc.modificar(depC));
                            }
                            
                            for(int i=0;i<totalE;i++){
                                DetalleCompra depC = new DetalleCompra(
                                        Integer.parseInt(eliminar[i])
                                );
                                System.out.println("eliminar: "+daoDc.eliminar(depC));
                            }
                            System.out.println("-----");
                        }
                    } catch (Exception e) {
                        System.out.println("control: "+e.getMessage());
                    }
                }
            }
            
            
            res = request.getRequestDispatcher("vistaCompra.jsp");
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
