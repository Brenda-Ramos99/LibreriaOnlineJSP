<%-- 
    Document   : vistaAutor
    Created on : 27-sep-2019, 12:55:15
    Author     : BymerGomez
--%>

<%@page import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                            $("#f1").submit();
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
       <title>Vista para Empleado</title>
        <div class="container">
            

<!-- Modal HTML Markup -->
<div id="ModalExample" class="modal fade">
    <div class="modal-dialog modal-xl">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title text-xs-center">Registro de Autores</h4>
            </div>
            <div class="modal-body">
                <form name="f1" id="f1" action="ControlAutor">
                    <input type="hidden">
                    <div class="form-group hidden">
                        <label class="control-label">ID</label>
                        <div>
                            <input type="text" class="form-control" name="id_autor" id="id_autor">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nombre</label>
                        <div>
                            <input type="text" name="nombre" id="nombre" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Seudónimo</label>
                        <div>
                            <input type="text" name="seudonimo" id="seudonimo" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Género</label>
                        <div><CENTER>
                            Masculino: <input type="radio" class="form form-group" name="genero" value="Masculino" checked="checked" />
                            Femenino: <input type="radio" class="form form-group" name="genero" value="Femenino" /></CENTER><br>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nacionalidad</label>
                        <div>
                            <select name="nacionalidad" id="nacionalidad" class="form-control">
                        <option>Seleccionar</option>
                        <option value="Alemana">Alemana</option>
                        <option value="Argentina">Argentina</option>
                        <option value="Australiana">Australiana</option>
                        <option value="Colombiana">Colombiana</option>
                        <option value="Salvadoreña">Salvadore&ntilde;a</option>
                        <option value="Mexicana">Mexicana</option>
                        <option value="Uruguaya">Uruguaya</option>
                        <option value="Inglesa">Inglesa</option>
                        <option value="Chilena">Chilena</option>
                    </select>
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
        
        <h1>Vista Empleado</h1>
        
        
        <%
            if(request.getAttribute("autores")==null)
                response.sendRedirect("ControlAutor?mostrar=1");
                
        %>
        <div class="col-md-9">
            <form name="f1" id="f1" action="ControlAutor">
                <div id="ocultar">
                    <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);$('#btnModificar').attr('disabled',true);$('#btnEliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
                    <a class="btn btn-primary" href="reporte.jsp?id=3">Reporte</a>
            </form>
                <br>
                <table class="table table-hover">
                    <tr><th>ID</th><th>Nombre</th><th>Seudónimo</th><th>Género</th><th>Nacionalidad</th><th>Acción</th></tr>
                    <%
                        if(request.getAttribute("autores")!=null){
                            ArrayList<Autor> a= new ArrayList<Autor>();
                            a.addAll((Collection)request.getAttribute("autores"));
                            for(Autor v:a){
                                
                                out.println("<tr><td>"+v.getId_autor()+"</td><td>"+v.getNombre()+"</td>"
                                        + "<td>"+v.getSeudonimo()+"</td><td>"+v.getGenero()+"</td><td>"+v.getNacionalidad()+"</td>"
                                        + "<td><a href='#ModalExample' class='btn btn-danger' data-toggle='modal' onclick=$('#id_autor').val('"+v.getId_autor()+"');"
                                                + "$('#nombre').val('"+v.getNombre()+"');$('#seudonimo').val('"+v.getSeudonimo()+"');$('#genero').val('"+v.getGenero()+"');"
                                                        + "$('#nacionalidad').val('"+v.getNacionalidad()+"');$('#btnModificar').attr('disabled',false);$('#btnEliminar').attr('disabled',false);$('#btnEliLog').attr('disabled',false); />Editar</td></tr>");
                                
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
