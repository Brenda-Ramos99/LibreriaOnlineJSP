<%-- 
    Document   : vistaAutor
    Created on : 27-sep-2019, 12:55:15
    Author     : BymerGomez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Vista Autores</title>
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
                            $("#formAutor").submit();
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
                            <h4 class="modal-title text-xs-center">Registro de Autor</h4>
                        </div>
                        <div class="modal-body">
                            <form name="f1" id="formAutor" method="post" action="ControlAutor"><div id="ocultar"></div>
                                <input type="hidden">
                                <div class="form-group" hidden="true">
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
        </div>      
        <h1>Vista Autor</h1>
        <c:if test="${autores==null}">
            <c:redirect url="ControlAutor?mostrar=1"/>
        </c:if>
        <div class="col-md-9">
            <a href="#ModalExample" type="reset" id="btnNuevo" onclick="$('#btnGuardar').attr('disabled',false);$('#btnModificar').attr('disabled',true);$('#Eliminar').attr('disabled',true);$('#btnEliLog').attr('disabled',true);" class="btn btn-primary" data-toggle="modal">Nuevo</a>
            <a class="btn btn-primary" href="Reporte/rAutor.jsp?id=3">Reporte</a><br>
            <div class="table-responsive mt-3" >
                <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Seudónimo</th>
                        <th>Género</th>
                        <th>Nacionalidad</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                    </tr>
                    </tfoot>
                    <tbody>
                        <c:if test="${autores!=null}">
                            <c:forEach var="v" items="${autores}">
                                <tr>
                                    <td>${v.getId_autor()}</td>
                                    <td>${v.getNombre()}</td>
                                    <td>${v.getSeudonimo()}</td>
                                    <td>${v.getGenero()}</td>
                                    <td>${v.getNacionalidad()}</td>
                                    <td>
                                        <a href='#ModalExample' class='btn btn-danger editar' data-toggle='modal'
                                           onclick="$('#id_autor').val('${v.getId_autor()}');
                                           $('#nombre').val('${v.getNombre()}');
                                           $('#seudonimo').val('${v.getSeudonimo()}');
                                           $('#genero').val('checked','${v.getGenero()}');
                                           $('#nacionalidad').val('${v.getNacionalidad()}');">Editar</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </div>
            <c:if test="${r!=null}">
                <script>Swal.fire('Confirmacion','${r}','info')</script>
            </c:if>
            <c:if test="${error!=null}">
                <script>Swal.fire('error','${error}','warning')</script>
            </c:if>
        </div>
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
    </body>
</html>
