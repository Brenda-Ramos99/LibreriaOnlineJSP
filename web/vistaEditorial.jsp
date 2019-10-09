<%-- 
    Document   : vistaAutor
    Created on : 27-sep-2019, 12:55:15
    Author     : Eduardo Recinos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vista Editoral</title>
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
                            $("#formedit").submit();
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
                            <h4 class="modal-title text-xs-center">Control de editoriales</h4>
                        </div>
                        <div class="modal-body">
                            <form name="f1" id="formedit" action="ControlEditorial"><div id="ocultar"></div>
                                <input type="hidden">
                                <div class="form-group hidden">
                                    <label class="control-label">ID</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_editorial" id="id_editorial">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Nombre</label>
                                    <div>
                                        <input type="text" name="nombre" id="nombre" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Direccion</label>
                                    <div>
                                        <input type="text" name="direccion" id="direccion" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Pais</label>
                                    <div>
                                        <select name="pais" id="pais" class="form-control">
                                            <option>Seleccionar</option>
                                            <option value="Alemania">Alemania</option>
                                            <option value="Argentina">Argentina</option>
                                            <option value="Australia">Australia</option>
                                            <option value="Colombia">Colombia</option>
                                            <option value="El salvador">El salvador</option>
                                            <option value="Mexico">Mexico</option>
                                            <option value="Uruguay">Uruguay</option>
                                            <option value="Inglaterra">Inglaterra</option>
                                            <option value="Chile">Chile</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Telefono</label>
                                    <div>
                                        <input type="text" name="telefono" id="telefono" value="" class="form-control"/>
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
            <h1>Control de Editoriales</h1>
            <%
                if(request.getAttribute("editoriales")==null)
                response.sendRedirect("ControlEditorial?mostrar=1");
            %>
            <div class="col-md-9">
                <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);$('#btnModificar').attr('disabled',true);$('#Eliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
                <a class="btn btn-primary" href="Reporte/rEditorial.jsp?id=3">Reporte</a><br>
                <form name="form1" action="Reporte/rEditorial_1.jsp" target="_black"><br>
                    <input type="text" class="col-sm-auto" name ="parametro" size="10"/>
                    <input type="submit" class="btn btn-primary" value="Filtrar por nombre de Editorial" />
                </form>
                <table class="table table-hover">
                    <tr><th>ID</th><th>Nombre</th><th>Direccion</th><th>Pais</th><th>Telefono</th><th>Acción</th></tr>
                    <c:if test="${editoriales!=null}">
                        <c:forEach var="v" items="${editoriales}">
                        <tr>
                            <td>${v.getId_editorial()}</td>
                            <td>${v.getNombre()}</td>
                            <td>${v.getDireccion()}</td>
                            <td>${v.getPais()}</td>
                            <td>${v.getTelefono()}</td>
                            <td>
                                <a href='#ModalExample' class='btn btn-danger' data-toggle='modal' 
                                onclick="$('#id_editorial').val('${v.getId_editorial()}');
                                $('#nombre').val('${v.getNombre()}');
                                $('#direccion').val('${v.getDireccion()}');
                                $('#pais').val('${v.getPais()}');
                                $('#telefono').val('${v.getTelefono()}');
                                $('#btnGuardar').attr('disabled',true);
                                $('#btnModificar').attr('disabled',false);
                                $('#Eliminar').attr('disabled',false);
                                $('#btnEliLog').attr('disabled',false);">Editar
                                </a>
                            </td>
                        </tr>
                        </c:forEach>
                    </c:if>
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
