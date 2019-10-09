<%-- 
    Document   : registro
    Created on : 10-06-2019, 12:14:01 PM
    Author     : william Villatoro
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.entidades.*"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Vista Registro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootsrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
       <link href="bootsrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <script src="bootsrap/js/bootstrap.js" type="text/javascript"></script>
       <script src="jquery.js" type="text/javascript"></script>
       <script src="sweetalert2.all.min.js" type="text/javascript"></script>
       <!--<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
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
                            $("#formUser").submit();
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <!-- Modal HTML Markup -->
            <!--<div id="ModalExample" class="modal fade">-->
                <div class="modal-dialog modal-xl">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title text-xs-center">Registro de Usuario</h4>
                        </div>
                        <div class="modal-body">
                            <form name="f1" id="formUser" action="ControlRegistro"><div id="ocultar">
                                <input type="hidden">
                                <div class="form-group hidden">
                                    <label class="control-label">ID</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_user" id="id_user">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">ID Rol</label>
                                    <div>
                                        <input type="text" class="form-control" name="id_rol" id="id_rol">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Tipo Membresia</label>
                                    <div>
                                        <input type="text" name="tipo_membresia" id="tipo_membresia" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Nombre Usuario</label>
                                    <div>
                                        <input type="text" name="user" id="user" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Contraseña</label>
                                    <div>
                                        <input type="text" name="pass" id="pass" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Edad</label>
                                    <div>
                                        <input type="text" name="edad" id="edad" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Direccion</label>
                                    <div>
                                        <input type="text" name="dir" id="dir" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">Tarjeta</label>
                                    <div>
                                        <input type="text" name="tar" id="tar" value="" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label">CVC</label>
                                    <div>
                                        <input type="text" name="cvc" id="cvc" value="" class="form-control"/>
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer text-xs-center">
                            <input type="submit" id="btnGuardar" value="Guardar" disabled="" name="btnGuardar" class="btn btn-success"/>
                            <input type="submit" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                            <input type="button" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                            <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            </form>
                        </div>
                    </div><!-- /.modal-content -->
                </div>
            </div>
       <!-- </div>-->
        
        <h1>Vista Usuario</h1>
        <c:if test="${usuario==null}">
            <c:redirect url="ControlRegistro?mostrar=1"/>
        </c:if>
        <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);
                $('#btnModificar').attr('disabled',true);$('#Eliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
            <a class="btn btn-primary" href="Reporte/rAutor.jsp?id=3">Reporte</a><br>
            <form name="form1" action="Reporte/rAutor_1.jsp" target="_black">
                <br>
                <input type="text" class="col-sm-auto" name ="parametro" size="10"/>
                <input type="submit" class="btn btn-primary" value="Filtrar por Seudonimo" />
            </form>
            
                <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>ROL</th>
                        <th>Tipo Membresia</th>
                        <th>Usuario</th>
                        <th>Edad</th>
                        <th>Direccion</th>
                        <th>Tarjeta</th>
                        <th>CVC</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                    </tr>
                    </tfoot>
                    <tbody>
                        <c:if test="${usuario!=null}">
                            <c:forEach var="v" items="${usuario}">
                                <tr>
                                    <td>${v.getId_usuario()}</td>
                                    <td>${v.getRol().getRol()}</td>
                                    <td>${v.getMembresia().getTipo_membresia()}</td>
                                    <td>${v.getUsuario()}</td>
                                    <td>${v.getEdad()}</td>
                                    <td>${v.getDireccion()}</td>
                                    <td>${v.getTarjeta()}</td>
                                    <td>${v.getCvc()}</td>
                                    <td>
                                        <a href='#ModalExample' class='btn btn-danger editar' data-toggle='modal'
                                           onclick="$('#id_user').val('${v.getId_usuario()}');
                                           $('#id_rol').val('${v.getRol().getRol()}');
                                           $('#tipo_membresia').val('${v.getMembresia().getTipo_membresia()}');
                                           $('#user').val('${v.getUsuario()}');
                                           $('#edad').val('${v.getEdad()}');
                                           $('#dir').val('${v.getDireccion()}');
                                           $('#tar').val('${v.getTarjeta()}');
                                           $('#cvc').val('${v.getCvc()}');
                                           $('#btnGuardar').attr('disabled',true);
                                           $('#btnModificar').attr('disabled',false);
                                           $('#Eliminar').attr('disabled',false);
                                           $('#btnEliLog').attr('disabled',false);">Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            <c:if test="${r!=null}">
                <script>Swal.fire('Confirmacion','${r}','info')</script>
            </c:if>
            <c:if test="${error!=null}">
                <script>Swal.fire('error','${error}','warning')</script>
            </c:if>
        </div>
    </body>
</html>
