<%-- 
    Document   : PAGINA_PRUEBAS
    Created on : 3/04/2019, 09:14:20 PM
    Author     : DELLMAYORGA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
        <script type="text/javascript">
           //con el siguiente codigo mando a traer la info en formato json del servlet
           //por default se procesa en el metodo doGet del servlet
            /*$.getJSON("/ControladorCuentaContable", //nombre del servlet que me devuelve el json
                { tipo_cuenta : 1 },    //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                function(respuesta_servlet){
                    $.each(respuesta_servlet, 
                        function(key, value){
                            $("#opt").append("<option value='"+ value.referencia_cuenta +"'>" + value.nombre_cuenta + "</option>");
                        });
                });
             //con el siguiente codigo uso el jquery y utilizo el evento change del combobox   
            $(document).ready(function(){
                $("#opt").change(function(event){
                    var referencia_cuenta = $("select#opt").val();      //con esto obtengo el codigo de la cuenta
                    var nombre_cuenta = $("#opt :selected").text(); //con esto obtengo el nombre de la cuenta
                    if($("#opt :selected").text() === "Seleccione una cuenta"){
                        //alert('entro al if');
                        $("#txtTexto").val('');
                    } else {
                        $("#txtTexto").val($("select#opt").val()); //al control txtTexto le pongo el nombre seleccionado
                    }
                });
            });*/
        </script>
    </head>
    <body>
    <select id="opt">
        <option>Seleccione una cuenta</option>
    </select>
        <input type="text" id="txtTexto">
    </body>
</html>
