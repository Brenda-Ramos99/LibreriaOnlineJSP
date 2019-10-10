<%-- 
    Document   : vistaRol
    Created on : 10-01-2019, 02:23:49 PM
    Author     : Brenda Ramos
--%>

<%@page import="java.util.Collection"%>
<%@page import="com.entidades.Autor"%>
<%@page import="com.entidades.Rol"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
        HttpSession sesion=request.getSession();
        if(sesion.getAttribute("id_rol")==null)
        {
            response.sendRedirect("login.jsp");
        }
        else
        {
            int id_rol=(Integer)sesion.getAttribute("id_rol");
            if(id_rol==1||id_rol==2){
            //out.print("<script>alert('Bienvenido: "+sesion.getAttribute("id_usuario")+"')</script>");
        %>
<html>
    <head>
        <title>Vista Roles</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootsrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
       <link href="bootsrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <script src="bootsrap/js/bootstrap.js" type="text/javascript"></script>
       <script src="jquery.js" type="text/javascript"></script>
       <script src="sweetalert2.all.min.js" type="text/javascript"></script>
       <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
       <script src="bootsrap/js/bootstrap.min.js" type="text/javascript"></script>
       <script>
            $(document).ready(function(){
                $('#Eliminar').click(function(){
                    Swal.fire({
                        type:"info",
                        title:"Eliminar registro",
                        text:"Este proceso no se podra revertir. Desea Eliminar?",
                        showCancelButton:true,
                        cancelButtonColor:"red",
                        confirmButtonColor:"green",
                    }).then(result=>{
                        if(result.value){
                            $("#ocultar").append("<input type='hidden' name='btnEliminar'>");
                            $("#formRol").submit();
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <!--Inicial el Menu-->
        <nav class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top" id="mainNav">
            <!--WIlliam mira como lo puedes modificar para que sea como icono a la derecha y no quede en el menú-->
            <div class="fa fa-user">
                <b><font color="bcae86" size="5"><%=session.getAttribute("usu")%></font></b>
            </div>
    <center>
        <ul class="navbar-nav ml-auto">
            <%
                if(id_rol==1){  
            %>
            <li class="nav-item mx-0 mx-md-0">
                <a class="nav-link py-3 px-0 px-md-3 rounded active" href="vistaAutor.jsp">Autor</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
            <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaLibro.jsp">Libro</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
                <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaEditorial.jsp">Editorial</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
                <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaRol.jsp">Rol</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
                <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaMembresia.jsp">Membresia</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
                <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaVenta.jsp">Compra Proveedores</a>
            </li>
            
            <%
            }
            %>
            <li class="nav-item mx-0 mx-md-0">
              <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="VistaCompra.jsp">Comprar</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
              <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaPrestamo.jsp">Alquilar</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
              <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaCategoria.jsp">Categorias</a>
            </li>
            </li>
            <li class="nav-item mx-0 mx-md-0">
                <%
                if(request.getParameter("c")!=null){
                    sesion.removeAttribute("id_rol");
                    sesion.invalidate();
                    response.sendRedirect("login.jsp");
                }
                %>
              <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="home.jsp?c=1">Cerrar sesión</a>
            </li>
        </ul>
    </center>
    </nav>
              <!--Fin del Menu-->
        <div class="container">
            <div id="ModalExample" class="modal fade"><!-- Modal HTML Markup -->
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title text-xs-center">Registro de Roles</h4>
                        </div>
                        <div class="modal-body">
                            <form name="f1" id="formRol" action="ControlRol"><div id="ocultar">
                                <input type="hidden">
                                <div class="form-group hidden">
                                    <label class="control-label">ID</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_rol" id="id_rol">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Rol</label>
                                    <div>
                                        <input type="text" name="rol" id="rol" value="" class="form-control"/>
                                    </div>
                                </div>
                        </div>
                    </div>
                        <div class="modal-footer text-xs-center">
                            <input type="submit" id="btnGuardar" value="Guardar" disabled="true" name="btnGuardar" class="btn btn-success"/>
                            <input type="submit" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                            <input type="button" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                            <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </form>
                        </div>
                </div>
            </div><!-- /.modal-content -->
        </div>
        
        <h1>Vista Rol</h1>
        <%
            if(request.getAttribute("roles")==null)
                response.sendRedirect("ControlRol?mostrar=1");
                
        %>
        <div class="col-md-9">
            <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);$('#btnModificar').attr('disabled',true);$('#Eliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
            <a class="btn btn-primary" href="Reporte/rRol.jsp?id=3">Reporte</a><br>
            <form name="form1" action="Reporte/rRol_1.jsp" target="_black">
                <br>
                <input type="text" class="col-sm-auto" name ="parametro" size="10"/>
                <input type="submit" class="btn btn-primary" value="Filtrar por tipo" />
            </form>
                <table class="table table-hover">
                    <tr><th>ID</th><th>Rol</th><th>Acción</th></tr>
                    <%
                        if(request.getAttribute("roles")!=null){
                            ArrayList<Rol> a= new ArrayList<Rol>();
                            a.addAll((Collection)request.getAttribute("roles"));
                            for(Rol v:a){
                                
                                out.println("<tr>"
                                                + "<td>"+v.getId_rol()+"</td>"
                                                + "<td>"+v.getRol()+"</td>"
                                                + "<td>"
                                                    + "<a href='#ModalExample' class='btn btn-danger' data-toggle='modal' onclick=$('#id_rol').val('"+v.getId_rol()+"');"
                                                    + "$('#rol').val('"+v.getRol()+"');$('#btnGuardar').attr('disabled',true);$('#btnModificar').attr('disabled',false);$('#Eliminar').attr('disabled',false);$('#btnEliLog').attr('disabled',false); >Editar</a>"
                                                + "</td>"
                                            + "</tr>");
                                
                            }
                        }
                    %>
                </table>
                
                <%
                    if(request.getAttribute("r")!=null)
                       out.println("<script>Swal.fire('Confirmacion','"+request.getAttribute("r")+"','info')</script>");
                   
                    if(request.getAttribute("error")!=null)
                       out.println("<script>Swal.fire('error','"+request.getAttribute("error")+"','warning')</script>");
                %>
        </div>
        <%@include file="plantilla/componentes/footerBody.jsp" %>
        <%@include file="plantilla/componentes/copyRightSection.jsp"%>
        <%@include file="plantilla/componentes/scroll.jsp" %>
        <%@include file="plantilla/componentes/portafolioSection.jsp" %>
        <%@include file="plantilla/componentes/script.jsp" %>
    </body>
</html>
