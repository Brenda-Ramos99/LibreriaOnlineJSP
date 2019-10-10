<%-- 
    Document   : rCompra
    Created on : 10-08-2019, 11:24:18 PM
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
    File f = new File(application.getRealPath("ReportesP/reCompra.jasper"));
    Map p = new HashMap();
    byte[] bytes=JasperRunManager.runReportToPdf(f.getPath(), p,c.con());
    response.setContentType("application/pdf");
    response.setContentLength(bytes.length);
    ServletOutputStream outp = response.getOutputStream();
    outp.write(bytes,0,bytes.length);
    outp.flush();
    outp.close();
%>
