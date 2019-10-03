<%-- 
    Document   : vistaCompra
    Created on : 01-oct-2019, 21:59:33
    Author     : BymerGomez
--%>

<%@page import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Vista Compras</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="bootsrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
       <link href="bootsrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <script src="bootsrap/js/bootstrap.js" type="text/javascript"></script>
       <script src="jquery.js" type="text/javascript"></script>
       <script src="sweetalert2.all.min.js" type="text/javascript"></script>
       <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
       <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
       <script src="bootsrap/js/bootstrap.min.js" type="text/javascript"></script>-->
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
let prepararDatos=()=>{
	$("#tablaAu .editar").on('click', function(event) {
		let values = ciclo($(this));
		$('#id_autor').val(values[0]);
                $('#nombre').val(values[1]);
                $('#seudonimo').val(values[2]);
                $('#genero').val(values[3]);
                $('#nacionalidad').val(values[4]);
                
                $('#btnGuardar').attr('disabled',true);
                $('#btnModificar').attr('disabled',false);
                $('#Eliminar').attr('disabled',false);
                $('#btnEliLog').attr('disabled',false);
	});
	
}
let ciclo=(selector)=>{/*recorre la fila de los datos que se desean hacerle crud*/
    let datos = [];
    $(selector).parents('tr').find('td').each(function(i) {
        if(i<6){/*6 significa total columnas existentes*/
            datos[i]=$(this).text();
        }else{
            return false;
        }
    });
    return datos;
}
        </script>
    </head>
    <body>
        <h1 align="center">Realizar Compra</h1>
        <br>
<div class="container-fluid">
    <div class="row">
        
        <%/*
            if(request.getAttribute("autores")==null)
                response.sendRedirect("ControlAutor?mostrar=1");
                */
        %>
    <div class="col-md-6">
            
                
                    <h1>Compra</h1>
                    <form name="detalle" action="#"><div id="ocultar"></div>
                    <input type="hidden">
                    <div class="form-group hidden">
                        <label class="control-label">ID</label>
                        <div>
                            <input type="text" class="form-control" name="id_compra" id="id_compra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Fecha</label>
                        <div>
                            <input type="date" name="fecha_compra" id="fecha_compra" value="" class="form-control"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label">Total</label>
                        <div>
                            <input type="text" name="total" value="" disabled="disabled" />
                        </div>
                    </div>
                    </form>
                <input type="submit" id="btnGuardar" value="Guardar" disabled="true" name="btnGuardar" class="btn btn-success"/>
                <input type="submit" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                <input type="button" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                <div class="table-responsive mt-3" >
                <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Libro</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>Subtotal</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    </tfoot>
                    <tbody>
                    <%/*
                        if(request.getAttribute("autores")!=null){
                            ArrayList<Autor> a= new ArrayList<Autor>();
                            a.addAll((Collection)request.getAttribute("autores"));
                            for(Autor v:a){
                                
                                out.println("<tr>"
                                                    + "<td>"+v.getId_autor()+"</td><td>"+v.getNombre()+"</td>"
                                                    + "<td>"+v.getSeudonimo()+"</td><td>"+v.getGenero()+"</td><td>"+v.getNacionalidad()+"</td>"
                                                    + "<td>"
                                                        + "<a href='#ModalExample' class='btn btn-danger editar' data-toggle='modal'>Editar</a>"
                                                    + "</td>"
                                            + "</tr>");
                                
                            }
                            out.println("<script>prepararDatos()</script>");
                        }*/
                    %>
                    </tbody>
                    
                </table>
                </div>
        
    </div>
    <div class="col-md-6">
                <h1>Detalle Compra</h1>
                <form name="detalle" action="#">
                    <input type="hidden">
                    <div class="form-group hidden">
                        <label class="control-label">ID</label>
                        <div>
                            <input type="text" class="form-control" name="id_detalle_compra" id="id_detalle_compra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">ID compra</label>
                        <div>
                            <input type="text" name="id_compra" id="id_compra" value="" class="form-control"/>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label class="control-label">ID Libro</label>
                        <div>
                            <input type="text" name="id_libro" id="id_libro" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Cantidad</label>
                        <div>
                            <input type="text" name="cantidad" id="cantidad" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Precio</label>
                        <div>
                            <input type="text" name="precio" id="precio" value="" class="form-control"/>
                        </div>
                    </div>
                     <div class="form-group">
                        <label class="control-label">Subtotal</label>
                        <div>
                            <input type="text" name="subtotal" id="subtotal" value="" class="form-control"/>
                        </div>
                    </div>
                    </form>
                <input type="submit" id="btnGuardar" value="Guardar" disabled="true" name="btnGuardar" class="btn btn-success"/>
                <input type="submit" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                <input type="button" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                <div class="table-responsive mt-3" >
                <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Fecha</th>
                        <th>IVA</th>
                        <th>Total</th>
                        <th>Usuario</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tfoot>
                    </tfoot>
                    <tbody>
                    <%/*
                        if(request.getAttribute("autores")!=null){
                            ArrayList<Autor> a= new ArrayList<Autor>();
                            a.addAll((Collection)request.getAttribute("autores"));
                            for(Autor v:a){
                                
                                out.println("<tr>"
                                                    + "<td>"+v.getId_autor()+"</td><td>"+v.getNombre()+"</td>"
                                                    + "<td>"+v.getSeudonimo()+"</td><td>"+v.getGenero()+"</td><td>"+v.getNacionalidad()+"</td>"
                                                    + "<td>"
                                                        + "<a href='#ModalExample' class='btn btn-danger editar' data-toggle='modal'>Editar</a>"
                                                    + "</td>"
                                            + "</tr>");
                                
                            }
                            out.println("<script>prepararDatos()</script>");
                        }*/
                    %>
                    </tbody>
                    
                </table>
                </div>
        
    </div>
    </div>
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