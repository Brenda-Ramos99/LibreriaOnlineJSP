<%-- 
    Document   : index
    Created on : 09-18-2019, 10:15:30 PM
    Author     : admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>

<%
        HttpSession sesion=request.getSession();
        if(sesion.getAttribute("id_rol")== null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            int id_rol=(Integer)sesion.getAttribute("id_rol");
            if(id_rol==1||id_rol==2){
            //out.print("<script>alert('Bienvenido: "+sesion.getAttribute("id_usuario")+"')</script>");
        %>
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <meta charset="UTF-8">
        <link href="plantilla/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
  <!-- Theme CSS -->
    <link href="plantilla/css/freelancer.min.css" rel="stylesheet">
    </head>
    <body>
        <h1>BIBLIOTECA ON-LINE SIS 12 B</h1>
    <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
    <center>
        <ul class="navbar-nav ml-auto">
            <%
                if(id_rol==1){  
            %>
            <li class="nav-item mx-0 mx-lg-1">
                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaAutor.jsp">Autor</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaEditorial.jsp">Editorial</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaRol.jsp">Rol</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaMembresia.jsp">Membresia</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
                <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaVenta.jsp">Venta</a>
            </li>
            <%
            }
            %>
            <li class="nav-item mx-0 mx-lg-1">
            <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaLibro.jsp">Libro</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="VistaCompra.jsp">Comprar</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaPrestamo.jsp">Alquilar</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="vistaCategoria.jsp">Categorias</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#sobre-nosotros">Sobre Nosotros</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="#contactenos">Contactenos</a>
            </li>
            <li class="nav-item mx-0 mx-lg-1">
                <%
                if(request.getParameter("c")!=null){
                    sesion.removeAttribute("id_rol");
                    sesion.invalidate();
                    response.sendRedirect("login.jsp");
                }
                %>
              <a class="nav-link py-3 px-0 px-lg-3 rounded js-scroll-trigger" href="home.jsp?c=1">Cerrar sesión</a>
            </li>
        </ul>
    </center>
    </nav>    
        <%@include file="plantilla/componentes/headerBody.jsp" %>
        <%@include file="plantilla/componentes/section.jsp" %>
        <%@include file="plantilla/componentes/aboutUsSection.jsp" %>
        <%@include file="plantilla/componentes/contactSection.jsp" %>
        <%@include file="plantilla/componentes/footerBody.jsp" %>
        <%@include file="plantilla/componentes/copyRightSection.jsp" %>
        <%@include file="plantilla/componentes/scroll.jsp" %>
        <%@include file="plantilla/componentes/portafolioSection.jsp" %>
        <%@include file="plantilla/componentes/script.jsp" %>
        <%      
            }else{
                response.sendRedirect("login.jsp");
            }

            }
        %>
    </body>
</html>
