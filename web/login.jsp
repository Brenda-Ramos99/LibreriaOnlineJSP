<%-- 
    Document   : login
    Created on : 09-30-2019, 03:37:01 PM
    Author     : william Villatoro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <h1>Loging</h1>
        <form action="ControlLogin" method="post">
            Usuario<br><input type="text"  name="usuario"><br>
            password<br><input type="password"  name="pass"><br>
            <input type="submit" name="btnInciar" value="Inciar">
            
        </form>
        <%
        HttpSession sesion=request.getSession();
        int id_rol=0;
        
        if(request.getAttribute("id_rol")!=null){
        id_rol=(Integer)request.getAttribute("id_rol");
        
        
        sesion.setAttribute("id_usuario",request.getAttribute("id_usuario"));
        sesion.setAttribute("id_rol",id_rol);
        response.sendRedirect("home.jsp");
        

        }
        %>
    </body>
</html>
