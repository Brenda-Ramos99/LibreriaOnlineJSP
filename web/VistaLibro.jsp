<%-- 
    Document   : vistaAutor
    Created on : 27-sep-2019, 12:55:15
    Author     : Eduardo Recinos
--%>

<%@page import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vista Libro</title>
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
                            $("#formLib").submit();
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
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
                                <div class="form-group hidden ">
                                    <label class="control-label">ID</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_libro" id="id_libro">
                                    </div>
                                </div>
                                <div class="form-group ">
                                    <label class="control-label">Categorias</label>
                                    <div>
                                        <select name="id_categoria" id="id_categoria" class="form-control">
                                            <option>Seleccionar</option>
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
                                            <option>Seleccionar</option>
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
                                        <input type="text" name="tomo" id="tomo" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Existencias</label>
                                    <div>
                                        <input type="text" name="existencias" id="existencias" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Año de publicacion</label>
                                    <div>
                                        <input type="text" name="anio_public" id="anio_public" value="" class="form-control"/>
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
                            <input type="button" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
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
            <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);$('#btnModificar').attr('disabled',true);$('#Eliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
            <a class="btn btn-primary" href="reporte.jsp?id=3">Reporte</a>
                <table class="table table-hover">
                    <tr>
                        <th>ID</th>
                        <th>Categoria</th>
                        <th>Autor</th>
                        <th>Titulo</th>
                        <th>Tomo</th>
                        <th>Existencias</th>
                        <th>Publicacion</th>
                        <th>precio</th>
                        <th>Accion</th>
                    </tr>
                    <!--<c:if test="${libros!=null}">
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
                                        $('#Eliminar').attr('disabled',false);
                                        $('#btnEliLog').attr('disabled',false);">Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>-->
                    
                    <% 
                        if(request.getAttribute("libros")!=null){
                            ArrayList<Libro> a= new ArrayList<Libro>();
                            a.addAll((Collection)request.getAttribute("libros"));
                            for(Libro v:a){
                                out.println("<tr>"
                                    + "<td>"+v.getId_libro()+"</td>"
                                    + "<td>"+v.getId_categoria().getNombre_cat()+"</td>"
                                    + "<td>"+v.getIdAutor().getNombre()+"</td>"
                                    + "<td>"+v.getTitulo()+"</td>"
                                    + "<td>"+v.getTomo()+"</td>"
                                    + "<td>"+v.getExistencias()+"</td>"
                                    + "<td>"+v.getAnio_public()+"</td>"
                                    + "<td>"+v.getPrecio()+"</td>"                          
                                    + "<td><a href='#ModalExample' class='btn btn-danger' data-toggle='modal' onclick=$('#id_libro').val('"+v.getId_libro()+"');"
                                    + "$('#id_categoria').val('"+v.getId_categoria().getNombre_cat()+"');"
                                    + "$('#id_autor').val('"+v.getIdAutor().getNombre()+"');"
                                    + "$('#titulo').val('"+v.getTitulo()+"');"
                                    + "$('#tomo').val('"+v.getTomo()+"');"                    
                                    + "$('#existencias').val('"+v.getExistencias()+"');"
                                    + "$('#anio_public').val('"+v.getAnio_public()+"');"
                                    + "$('#precio').val('"+v.getPrecio()+"');"
                                    + "$('#btnGuardar').attr('disabled',true);"
                                    + "$('#btnModificar').attr('disabled',false);"
                                    + "$('#Eliminar').attr('disabled',false);"
                                    + "$('#btnEliLog').attr('disabled',false); />Editar</td></tr>");
                            }
                        }
                    %>
                </table>
                
        </div>
               <%
                    if(request.getAttribute("r")!=null)
                       out.println("<script>Swal.fire('Confirmacion','"+request.getAttribute("r")+"','info')</script>");
                   
                   if(request.getAttribute("error")!=null)
                       out.println("<script>Swal.fire('error','"+request.getAttribute("error")+"','warning')</script>");
               %>
        </div>
    </body>
</html>
