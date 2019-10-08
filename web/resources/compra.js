var elemSelect;
var colocarFecha = true;
let tabla = new Array();
let modificar = new Array();
let eliminados = new Array();

$(document).ready(function(){
    if(colocarFecha){
            var f = new Date();
            var mes = "";
            var dia="";
            if(f.getMonth() +1<10){
                mes = "0"+(f.getMonth() +1);
            }else{
                mes = (f.getMonth() +1);
            }
            if(f.getDate()<10){
                dia = "0"+(f.getDate());
            }else{
                dia = (f.getDate());
            }
            $("#fecha_compra").val(f.getFullYear() + "-" + mes + "-" + dia);
        }
        
        $("#btnNuevo").on("click",function(){
            libNuevos();
            $("#nuevosL").val(tabla);
            $("#opcion").val("nuevo");
            $("#total2").val($("#total").val());
            
//            $("#frmCompra").submit();
        });
        $("#btnModificar").on("click",function(){
        libNuevos();
        borrarRepetido();
        $("#nuevosL").val(tabla);
        $("#modificarL").val(modificar);
        $("#eliminarL").val(eliminados);
        $("#opcion").val("modificar");
        $("#total2").val($("#total").val());
        $("#frmCompra").submit();
    }); 
    $("#agregarLib").on('click', function(evt) {
		if(validacionLibro()){                   
			$("#data tbody").append(''+
				'<tr>'+
					'<td></td>'+
					'<td>'+$("#id_libro").val()+'</td>'+
					'<td>'+$("#id_libro option[value='"+$("#id_libro").val()+"']").text()+'</td>'+
					'<td>'+$("#cantidad").val()+'</td>'+
					'<td>'+$("#precio").val()+'</td>'+
					'<td>'+$("#s").val()+'</td>'+
					'<td>'+
						'<button title="" class="editar btn btn-secondary">'+
	                        '<i class="far fa-edit"></i>'+
	                    '</button>'+
						'<button title="" type="button" class="eliminar btn btn-danger">'+
	                        '<i class="far fa-trash-alt"></i>'+
	                    '</button></td>'+
				'</tr>');
			prepararDatos();
			limpiar();
                        calcularTotal();
		}
    });
    $("#modificarLib").on('click', function(event) {
		if(validacionLibro()){
                    let ban = false;
                    let fila = new Array();
			elemSelect.find('td').each(function(index) {
                                
                                if(index==0 && $(this).text()!=''){
                                    ban = true;
                                }
                                if(index==1){
					$(this).text($("#id_libro").val());
				}else if(index==2){
					$(this).text($("#id_libro option[value='"+$("#id_libro").val()+"']").text());
				}else if(index==3){
					$(this).text($("#cantidad").val());
				}else if(index==4){
					$(this).text($("#precio").val());
				}else if(index==5){
					$(this).text($("#s").val());
				}else if(index>5){
                                    if(ban){
                                        modificar.push(fila);
                                    }
                                    return false;
				}
                                if(ban){
                                    fila.push($(this).text());
                                }
			});
			limpiar();
                        calcularTotal();
		}
	});
});
let validacionLibro=()=>{
	if($("#id_libro").val()!='' && $("#cantidad").val()!='' && $("#cantidad").val()!='0'){
		return true;
	}else{
		alert('fail!!')
		return false;
	}
}
let limpiar=()=>{
    $("#id_libro").val('');
    $("#cantidad").val('0');
    $("#precio").val('0.0');
    $("#s").val('0.0');
}
let prepararDatos=()=>{
    let ban = 0;
	$("#data .editar").on('click', function(event) {
		let values = ciclo($(this));
		$("#id_libro").val(values[1]);
		$("#cantidad").val(values[3]);
                $("#precio").val(values[4]);
		$("#s").val(values[5]);

		
		elemSelect = $(this).parents('tr');
                calcularTotal();
	});
	$("#data .eliminar").on('click', function(event) {
                $(this).parents('tr').find('td').each(function(indice){
                    if(indice==0 && $(this).text()!='' ){
                        eliminados.push($(this).text());
                    }
                });
		$(this).parents('tr').remove();
                calcularTotal();
	});
        $("#remov").remove();
        
}
let ciclo=(selector)=>{/*recorre la fila de los datos que se desean hacerle crud*/
	let datos = [];
	$(selector).parents('tr').find('td').each(function(i) {
		if(i<6){/*5 significa total columnas existentes*/
			datos[i]=$(this).text();
		}else{
			return false;
		}
	});
	return datos;
}
let libNuevos=()=>{
    $("#data tbody tr").each(function(i,evt){
                let fila = new Array();
                let ban = false;
                $(this).find("td").each(function(index){
                    if(index==0 && $(this).text()==''){
                        ban = true;
                    }
                    if(index>0 && index<6 && ban){
                        fila.push($(this).text());
                    }
                });
                if(ban){
                    tabla.push(fila)
                }
     });
}
let borrarRepetido=()=>{
    let total = eliminados.length;
    for(let i = 0;i<total;i++){
        for(let j = i+1;j<total;j++){
            if(eliminados[j]==eliminados[i]){
                var elementoEliminado = eliminados.splice(j, 1);
                total--;
                j--;
            }
        }
    }
}
let calcularTotal=()=>{
    var total = 0.0;
    $("#data tbody tr").each(function(i){
        $(this).find('td').each(function(j){
            if(j==5){
                total+= parseFloat($(this).text());
            }else if (j>5){
                return false;
            }
        });
    });
    $("#total").val(total);
}


