<%-- 
    Document   : vistaAutor
    Created on : 27-sep-2019, 12:55:15
    Author     : Eduardo Recinos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Vista Libro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootsrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootsrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootsrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="jquery.js" type="text/javascript"></script>
        <script src="bootsrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
        <!-- Custom fonts for this template-->
        <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="resources/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
        <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
        <!--Platilla-->
        <link href="plantilla/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
        <!-- Theme CSS -->
         <link href="plantilla/css/freelancer.min.css" rel="stylesheet">
        <!--PlatillaFin-->
       <script>
            $(document).ready(function(){
                $('#btnEliminar').click(function(){
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
                            $("#formLib").submit();
                        }
                    });
                });
            });
        </script>
        <script>
            function limpiar()
            {
                $('#id_libro').val('');
                $('#id_categoria').val('Seleccionar');
                $('#id_autor').val('Seleccionar');
                $('#titulo').val('');
                $('#tomo').val('');
                $('#existencias').val('');
                $('#anio_public').val('');
                $('#precio').val('0');
            }
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
                <a class="nav-link py-3 px-0 px-md-3 rounded" href="vistaAutor.jsp">Autor</a>
            </li>
            <li class="nav-item mx-0 mx-md-0">
            <a class="nav-link py-3 px-0 px-md-3 rounded active" href="VistaLibro.jsp">Libro</a>
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
              <a class="nav-link py-3 px-0 px-md-3 rounded js-scroll-trigger" href="vistaCompra.jsp">Comprar</a>
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
        <div class="container">
            <!-- Modal HTML Markup -->
            <div id="ModalExample" class="modal fade">
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title text-xs-center">Control de Libros</h4>
                        </div>
                        <div class="modal-body">
                            <form name="f1" id="formLib" action="ControlLibro"><div id="ocultar"></div>
                                <input type="hidden">
                                <div class="form-group hidden" hidden="true">
                                    <label class="control-label">ID</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_libro" id="id_libro">
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label class="control-label">Categorias</label>
                                    <div>
                                        <select name="id_categoria" id="id_categoria" class="form-control">
                                            
                                            <%
                                                if(request.getAttribute("libros")!=null){
                                                    ArrayList<Categoria> d = new ArrayList<Categoria>();
                                                    d.addAll((Collection)request.getAttribute("categorias"));
                                                    for(Categoria v:d){
                                                        out.println("<option value='"+v.getId_categoria()+"'>"+v.getNombre_cat()+"</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                </div>
                                <label class="control-label">Autores</label>
                                    <div>
                                        <select name="id_autor" id="id_autor" class="form-control">
                                            
                                            <%
                                                if(request.getAttribute("libros")!=null){
                                                    ArrayList<Autor> d = new ArrayList<Autor>();
                                                    d.addAll((Collection)request.getAttribute("autores"));
                                                    for(Autor v:d){
                                                        out.println("<option value='"+v.getId_autor()+"'>"+v.getNombre()+"</option>");
                                                    }
                                                }
                                            %>
                                        </select>
                                    </div>
                                <div class="form-group">
                                    <label class="control-label">Titulo</label>
                                    <div>
                                        <input type="text" name="titulo" id="titulo" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Tomo</label>
                                    <div>
                                        <INPUT TYPE="NUMBER" name="tomo" id="tomo" MIN="1" MAX="10" STEP="1" VALUE="1" class="form-control col-3">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Existencias</label>
                                    <div>
                                        <INPUT TYPE="NUMBER" name="existencias" id="existencias" MIN="1" MAX="100" STEP="1" VALUE="1" class="form-control col-3">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Año de publicacion</label>
                                    <div>
                                        <INPUT TYPE="NUMBER" name="anio_public" id="anio_public" MIN="1500" MAX="2019" STEP="1" VALUE="1900" class="form-control col-3">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Precio</label>
                                    <div>
                                        <input type="text" name="precio" id="precio" value="" class="form-control"/>
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer text-xs-center">
                            <input type="submit" id="btnGuardar" value="Guardar" disabled="true" name="btnGuardar" class="btn btn-success"/>
                            <input type="submit" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                            <input type="button" id="btnEliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                            <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </form>
                        </div>
                    </div><!-- /.modal-content -->
                </div>
            </div>

        <h1>Control de Libros</h1>
        <%
            if(request.getAttribute("libros")==null)
                response.sendRedirect("ControlLibro?mostrar=1");
        %>
        <div class="col-md-9">
            <a href="#ModalExample" type="reset" id="btnNuevo" onclick="limpiar();$('#btnGuardar').attr('disabled',false);
                $('#btnModificar').attr('disabled',true);
                $('#btnEliminar').attr('disabled',true);
                $('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
            <a class="btn btn-primary" href="Reporte/rLibro.jsp?id=3">Reporte</a>
            <form name="form1" action="Reporte/rLibro_1.jsp" target="_black">
                <br>
                <input type="text" class="col-sm-auto" name ="parametro" size="10"/>
                <input type="submit" class="btn btn-primary" value="Filtrar por nombre de titulo" />
            </form>
                <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Categoria</th>
                            <th>Autor</th>
                            <th>Titulo</th>
                            <th>Tomo</th>
                            <th>Existencias</th>
                            <th>Publicacion</th>
                            <th>Precio</th>
                            <th>Accion</th>
                        </tr>
                    </thead>
                    <c:if test="${libros!=null}">
                        <c:forEach var="v" items="${libros}">
                            <tr>
                                <td>${v.getId_libro()}</td>
                                <td>${v.getId_categoria().getNombre_cat()}</td>
                                <td>${v.getIdAutor().getNombre()}</td>
                                <td>${v.getTitulo()}</td>
                                <td>${v.getTomo()}</td>
                                <td>${v.getExistencias()}</td>
                                <td>${v.getAnio_public()}</td>
                                <td>${v.getPrecio()}</td>
                                <td>
                                    <a href='#ModalExample' class='btn btn-danger' data-toggle='modal' 
                                        onclick="$('#id_libro').val('${v.getId_libro()}');
                                        $('#id_categoria').val('${v.getId_categoria().getNombre_cat()}');
                                        $('#id_autor').val('${v.getIdAutor().getNombre()}');
                                        $('#titulo').val('${v.getTitulo()}');
                                        $('#tomo').val('${v.getTomo()}');
                                        $('#existencias').val('${v.getExistencias()}');
                                        $('#anio_public').val('${v.getAnio_public()}');
                                        $('#precio').val('${v.getPrecio()}');
                                        $('#btnGuardar').attr('disabled',true);
                                        $('#btnModificar').attr('disabled',false);
                                        $('#btnEliminar').attr('disabled',false);
                                        $('#btnEliLog').attr('disabled',false);">Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                </table>      
        </div>
        <c:if test="${r!=null}">
            <script>Swal.fire('Confirmacion','${r}','info')</script>
        </c:if>
        <c:if test="${error!=null}">
            <script>Swal.fire('error','${error}','warning')</script>
        </c:if>
        </div>
        <br><br><br><br>
        
        <%@include file="plantilla/componentes/footerBody.jsp" %>
        <%@include file="plantilla/componentes/copyRightSection.jsp"%>
        <%@include file="plantilla/componentes/scroll.jsp" %>
        <%@include file="plantilla/componentes/portafolioSection.jsp" %>
        <%@include file="plantilla/componentes/script.jsp" %>
         <!-- Bootstrap core JavaScript-->
        <script src="resources/vendor/jquery/jquery.min.js" type="text/javascript"></script>
        <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>

        <!-- Core plugin JavaScript-->
        <script src="resources/vendor/jquery-easing/jquery.easing.min.js" type="text/javascript"></script>

        <!-- Custom scripts for all pages-->
        <script src="resources/js/sb-admin-2.min.js" type="text/javascript"></script>


        <!-- Page level plugins -->
          <script src="resources/vendor/datatables/jquery.dataTables.min.js" type="text/javascript"></script>
          <script src="resources/vendor/datatables/dataTables.bootstrap4.min.js" type="text/javascript"></script>
          <script>$("#data").DataTable();</script>
          <%      
            }else{
                response.sendRedirect("login.jsp");
            }

        }
        %>
    </body>
</html>
