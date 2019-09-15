<%-- 
    Document   : index
    Created on : 15-sep-2019, 8:24:10
    Author     : BymerGomez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
    <center><h1>Bienvenido!</h1>
    <form name="f1" action="#" method="POST">
        User:<input type="text" name="user" value="" size="20" /><br>
        Pass:<input type="password" name="pass" value="" size="20" /><br>
        <input type="submit" value="Aceptar" name="b1" />
    </form></center>
    <%
        if(request.getParameter("b1")!=null)
        {
            String user = request.getParameter("user");
            String pass = request.getParameter("pass");
            if(user.equals("sis12")&&pass.equals("123"))
            {
                HttpSession s = request.getSession();
                s.setAttribute("s1", user);
                response.sendRedirect("principal.jsp");
            }
            else
            {
                out.println("<script>alert('FAILED')</script>");
            }
        }
    %>
    </body>
</html>
