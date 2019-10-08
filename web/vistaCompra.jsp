<%-- 
    Document   : vistaCompra
    Created on : 01-oct-2019, 21:59:33
    Author     : BymerGomez
--%>

<%@page session="true" import="java.util.*" import="com.entidades.*" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <title>Vista Compras</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootsrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootsrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="bootsrap/js/bootstrap.js" type="text/javascript"></script>
        <script src="jquery.js" type="text/javascript"></script>
        <script src="sweetalert2.all.min.js" type="text/javascript"></script>
        <script src="jquery-1.12.4.min.js" type="text/javascript"></script>
        <script src="bootsrap/js/bootstrap.min.js" type="text/javascript"></script>
      <!-- Custom fonts for this template-->
    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <script src="resources/compra.js" type="text/javascript"></script>
    <!-- Custom styles for this template-->
    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet" type="text/css">
    <link href="resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css">
       <script>
           var libros = new Array();
            $(document).ready(function(){
                $("#id_libro").on('change',function(){
                   for(let i=0;i<libros.length;i++){
                       if($(this).val()==libros[i][0]){
                           $("#precio").val(libros[i][1]);
                           break;
                       }else{
                           $("#precio").val(0);
                       }
                   }
                });
                $("#cantidad").on('keyup',function(){
                    if($(this).val()==''){
                        $("#s").val(0);
                    }else{
                        $("#s").val(parseFloat($(this).val())*parseFloat($("#precio").val()));
                    }
                })
            });
                /*$('#Eliminar').click(function(){
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
                });*/
            //});
        </script>
    </head>
    <body>
        <h1 align="center">Realizar Compra</h1><br>
        <div class="container-fluid">
            <div class="row">
                <%! 
                    ArrayList<Libro> libs;
                %>
                <%
                    if(request.getAttribute("libros")==null)
                        response.sendRedirect("ControlCompra?mostrar=1");
                %>
            <div class="col-md-6">
                <h1>Detalle Compra</h1>
                <div class="row">
                    <div class="form-group col-6">
                        <label class="control-label">Libro</label>
                        <div>
                            <select type="text" name="id_libro" id="id_libro" value="" class="form-control">
                            <option></option>
                            <%
                                if(request.getAttribute("libros")!=null){
                                    libs = new ArrayList<Libro>();
                                    libs.addAll((Collection)request.getAttribute("libros"));
                                    for(Libro ob:libs){
                                        out.println("<option value='"+ob.getId_libro()+"'>"+ob.getTitulo()+"</option>");
                                        out.println("<script>var fila = ["+ ob.getId_libro()+","+ob.getPrecio()+"];"+
                                        "libros.push(fila)</script>");
                                    }
                                }

                            %>
                        </select>
                        </div>
                    </div>
                    <div class="form-group col-6">
                        <label class="control-label">Cantidad</label>
                        <div>
                            <input type="number" name="cantidad" id="cantidad" value="0" class="form-control"/>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                        <div class="form-group col-4">
                            <label class="control-label">Precio</label>
                            <div>
                                <input type="text" name="precio" id="precio" value="0.0" class="form-control" disabled/>
                            </div>
                        </div>
                        <div class="form-group col-4">
                            <label class="control-label">Subtotal</label>
                            <div>
                                <input type="text" name="subtotal" id="s" value="0.0" class="form-control" disabled/>
                            </div>
                        </div>
                        <div class="form-group col-4">
                            <label class="control-label">Total</label>
                            <div>
                                <input id="total" type="text" value="0.0" class="form-control" disabled />
                            </div>
                        </div>
                </div>
                <input type="button" id="agregarLib" value="Agregar" name="btnGuardar" class="btn btn-success"/>
                <input type="button" id="modificarLib" value="Modificar" name="btnModificar" class="btn btn-success"/>
                <input type="button" id="btnlimpiar" value="limpiar" name="btnEliLog" class="btn btn-success"/>
                <div class="table-responsive mt-3" >
                    <table class="table table-bordered" id="data" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>ID Libro</th>
                                <th>Libro</th>
                                <th>Cantidad</th>
                                <th>Precio</th>
                                <th>Subtotal</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr id="remov">
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                            </tr>
                        <%
                        if(request.getAttribute("detalleLibro")!=null){
                            ArrayList<DetalleCompra> a= new ArrayList<DetalleCompra>();
                            a.addAll((Collection)request.getAttribute("detalleLibro"));
                            for(DetalleCompra ob:a){
                                out.println("<tr>"+
                                    "<td>"+ob.getId_detalle_compra()+"</td>"+
                                    "<td>"+ob.getLibro().getId_libro()+"</td>]"+
                                    "<td>"+ob.getLibro().getTitulo()+"</td>]"+
                                    "<td>"+ob.getCantidad()+"</td>]"+
                                    "<td>"+ob.getPrecio()+"</td>]"+
                                    "<td>"+ob.getSubtotal()+"</td>]"+
                                    "<td>"+
                                        "<button  class='editar btn btn-secondary'>"+
                                            "<i class='far fa-edit'></i>"+
                                        "</button>"+
                                        "<button type='button' class='eliminar btn btn-danger'>"+
                                            "<i class='far fa-trash-alt'></i>"+
                                        "</button>"+
                                    "</td>"+
                                "</tr>");
                                out.println("<script>prepararDatos()</script>");
                            }
                        }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-6">
                <h1>Compra</h1>
                <form name="detalle" action="#" id="frmCompra">
                <!-- campos ocultos -->
                    <div hidden>
                        opcion
                        <input id="opcion" name="opcion" type="text">
                        nuevos
                        <input id="nuevosL" name="nuevosL" type="text"><br>
                        eliminados
                        <input id="eliminarL" name="eliminarL" type="text">
                        modificados
                        <input id="modificarL" name="modificarL" type="text"><br>
                        total
                        <input id="total2" name="total" type="text">
                    </div>
                    <!-- fin campos ocultos -->
                    <div class="form-group">
                        <label class="control-label">ID compra</label>
                        <div>
                            <input type="text" class="form-control" name="id_compra" id="id_detalle_compra">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">ID cliente</label>
                        <div>
                            <input type="text" name="id_cliente" id="id_cliente" value="<%%>" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Fecha</label>
                    <div>
                        <input type="date" name="fecha_compra" id="fecha_compra" value="" class="form-control"/>
                    </div>
                    </div>
                    <a href="ControlCompra?mostrar=1" class="btn btn-primary">Nuevo</a>
                    <input type="button" id="btnNuevo" value="Guardar" name="btnGuardar" class="btn btn-success"/>
                    <input type="button" id="btnModificar" value="Modificar" name="btnModificar" class="btn btn-success"/>
                    <input type="submit" id="Eliminar" value="Eliminar" name="btnEliminar" class="btn btn-success"/>
                    <input type="submit" id="btnEliLog" value="Logico" name="btnEliLog" class="btn btn-success"/>
                </form>
                <div class="table-responsive mt-3" >
                <table class="table table-bordered" id="data2" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Fecha</th>
                            <th>IVA</th>
                            <th>Total</th>
                            <th>id Usuario</th>
                            <th>Usuario</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tfoot>
                    </tfoot>
                    <tbody>
                        <%
                            if(request.getAttribute("compra")!=null){
                                ArrayList<Compra> a = new ArrayList<Compra>();
                                a.addAll((Collection)request.getAttribute("compra"));
                                for(Compra v:a){
                                    out.println("<tr>"
                                        + "<td>"+v.getId_compra()+"</td>"
                                        + "<td>"+v.getFecha_compra()+"</td>"
                                        + "<td>"+v.getIVA()+"</td>"
                                        + "<td>"+v.getTotal()+"</td>"
                                        + "<td>"+v.getUsuario().getId_usuario()+"</td>"
                                        + "<td>"+v.getUsuario().getUsuario()+"</td>"
                                        + "<td>"
                                            + "<a href='ControlCompra?cargar="+v.getId_compra()+"&idUsuario="+v.getUsuario().getId_usuario()+"' class='btn btn-secondary text-light' >Cargar</a>"
                                        + "</td>"
                                    + "</tr>");
                                }
                            }
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
        <%
          if(request.getAttribute("id")!=null){
        %>
    <script>
        $("#id_detalle_compra").val(<%= request.getAttribute("id")%>);
        $("#id_cliente").val(<%= request.getAttribute("idUsuario")%>);
    </script>
    <%
        }
    %>
    </body>
</html>