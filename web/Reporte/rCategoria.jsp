<%-- 
    Document   : rCategoria
    Created on : 10-03-2019, 04:24:55 PM
    Author     : Brenda Ramos
--%>

<%@page import="com.modelo.Conexion"%>
<%@page import="java.io.File"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="net.sf.jasperreports.engine.*" %>

<!DOCTYPE html>
<%
    Conexion c = new Conexion();
    File f = new File(application.getRealPath("ReportesP/reCategoria.jasper"));
    Map p = new HashMap();
    p.put("id", request.getParameter("id")); 
    byte[] bytes=JasperRunManager.runReportToPdf(f.getPath(), p,c.con());
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream outp = response.getOutputStream();
    outp.write(bytes,0,bytes.length);
    outp.flush();
    outp.close();
%>
