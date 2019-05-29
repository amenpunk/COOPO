<%-- 
    Document   : Modificación_Activos_Fijos
    Created on : 8/05/2019, 04:04:58 PM
    Author     : Richard
--%>

<%@page import="umg.analisisdesistemas1.com.objeto.CuentaContable"%>
<%@page import="umg.analisisdesistemas1.com.objeto.SubMenu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="umg.analisisdesistemas1.com.objeto.Menu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<style type="text/css">
    #bodyprincipal{
        position: absolute;
        width: 100%;
        overflow-x: no-display;
        margin-left: 0px;
        /* background-color: #fff; */
    }
    #divcontenedor{
        position: fixed;
        width: 100%;
        height: 100%;
        margin-left: 0px;
        background-color: #fff; /* #d1e0e0;      //el fondo era como verdecito */
    }
    #divtop{
        float: top;
        width: 100%;
        height: 15%;
        background-color: #E6E6E6;
    }
    #divlogo{
        float: left;
        width: 20%;
        height: 100%;
        background-image: url("/imagenes/logo.png");
        background-repeat: no-repeat;
        background-size: 100%;
        margin-left: 2%;
        background-position-y: center;
        /* background-color: #FF0000; */
    }
    #divlogueo{
        position: relative;
        float: right;
        width: 20%;
        height: 50%;
        margin-top: 3%;
        margin-bottom: 0;
        text-align: left;
    }
    #divmedio{
        float: next;
        width: 100%;
        height: 100%;
    }
    #divleft{
        position: relative;
        float: left;
        width: 22%;
        height: 85%;
        margin-left: 5px;
        background-color: /*#FF0000;*/ #d1e0e0; /*#01A9DB;*/  /* color de fondo del menu */
        /* border-right: #ccc 10px solid; */
        border-right: #ccc 1px solid;
        /* z-index: 0; */
    }
    #divcontenido{
        position: relative;
        float: right;
        margin-right: 2px;
        width: 76%;
        height: 85%;
        border-left: solid #A4A4A4;
        overflow-y: auto;
        overflow-x: hidden;
        /* background-color: black; */
    }
    #divtitulo{
        float: top;
        margin-top: 0px;
        width: 100%;
        height: 5%;
        text-align: justify;
        vertical-align: top;
        margin-left: 10%;
        font-size: larger;
        font-weight: bold;
        color: #A4A4A4;
    }
    #divformulario{
        float: next;
        width: 100%;
        height: 90%;
        margin-top: 20px;
    }
    #divdown{
        float: bottom;
        width: 100%;
        height: 10%;
    }
    .hrs{
        background-color: #F2F2F2;
    }
    #divtitulos{
        /* position: relative; */
        float: left;
        width: 100%;
        text-align: center;
        /* background-color: #fff; */
        margin-top: 1%;
        color: #A4A4A4;
        /* background-color: #fff; */
    }
    h3{
        width: 100%;
    }
    #divcontrolesinfoactivo{
        float: left;
        width: 100%;
        height: 100%;
        margin-top: 10px;
        margin-left: 20px;
        background-color: #fff;
    }
    table{
        /* border: 1px solid #E6E6E6; */
        /* width: 95%; */
    }
    tr{
        height: 25px;
    }
    td{
        /* border: 1px solid #E6E6E6; */
        /* width: 10%; */
    }
    #trUsuario, #trSubmit{
        height: 15px;
    }
    caption{
        color: #A4A4A4;
        text-align: left; 
        width: 500px; 
        padding-bottom: 10px; 
        font-weight: bold; 
        font-size: larger;"
    }
    .cb{
        width: 173px;
    }
   
</style>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificación de Activos</title>
        
        
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="css/menu.css">
        <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
        
        <script type="text/javascript">
            //script con el que voy a manejar los combobox de las cuentas contables
            //con el siguiente codigo mando a traer la info en formato json del servlet y lleno el cbCuentasActivos
           //por default se procesa en el metodo doGet del servlet
           
     $.getJSON("/ControladorActivosAlta", //nombre del servlet que me devuelve el json
                { opcion : 1 },    //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                function(respuesta_servlet){
                    $.each(respuesta_servlet, 
                        function(key, value){
                            $("#cbnombreactivo").append("<option value='"+ value.codigo_activo +"'>" + value.nombre_activo + "</option>");   
                        });
                });
               
            $.getJSON("/ControladorDepartamento", //nombre del servlet que me devuelve el json
            { codigo_compania : 1 },    //le envio el codigo de la compania que es 1
            function(respuesta_servlet){
                $.each(respuesta_servlet, 
                    function(key, value){
                        $("#cbDepartamento").append("<option value='"+ value.codigo_departamento +"'>" + value.nombre_departamento + "</option>");
                        $("#cbUbicacion").append("<option value='"+ value.codigo_departamento +"'>" + value.nombre_departamento + "</option>");
                    });
            });
        
                
             //con el siguiente codigo uso el jquery y utilizo el evento change del combobox   
            $(document).ready(function(){
                //evento change para el combobox de activos
                  $("#cbcodigoactivo").change(function(event){
                      var nombre_activo = $("#cbcodigoactivo :selected").text(); //con esto obtengo el nombre de la cuenta
                    if($("#cbcodigoactivo :selected").text() === "Seleccione una cuenta") //valido el primer elemento del combobox
                        $("#txtNombreActivo").val('');
                      $.getJSON("/ControladorCodigoActivo", { codigo : $("cbcodigoactivo").val() }, function(respuesta){
                            $.each(respuesta, function(key, valor){
                              //  console.log("Estoy enviando datos desde la consola: " + valor.codigo_ref);
                                $("#txtNombreActivo").val(valor.nuevo_nombre);
                                $("#txtEstadoActivo").val(valor.nuevo_estado);
                                $("#tdDescripcionmodificacion").val(valor.nueva_descripcion);
				$("#txtEstadoActivo").val(valor.nuevo_estado);
				$("#txtValorAgregado").val(valor.nuevo_valor);
                                $("#tdDescripcionlarga").val(valor.nueva_observacion);

                            });
                        });
                    
                }); 
               
              
                $("#txtCodigoEmpleado").keydown(function(event){  //evento de presionar la tecla
                    if(event.keyCode == 9){ //codigo de la tecla tab
                        //alert("Presiono la tecla tab");
                        if($("#txtCodigoEmpleado").val() !== ""){
                            $.getJSON("/ControladorDatosInstitucionalesEmpleado",//nombre del servlet que me devuelve el json
                            { codigo_empleado : $("#txtCodigoEmpleado").val() },    //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                            function(respuesta_servlet){
                                $.each(respuesta_servlet, function(key, value){
                                    //asigno los valores que trae el json a los controles input del html
                                    $("#txtEmpleadoResponsable").val(value.nombre_empleado);
                                    $("#txtPuestoEmpleado").val(value.puesto);
                                    $("#txtDepartamento").val(value.departamento);
                                    $("#txtCentroCosto").val(value.centro_costo);
                                    $("#txtUbicacion").val(value.ubicacion);
                                });
                            });
                        } else {
                            alert("¡Debe ingresar el código del empleado!");
                            //alert("El valor es: "+$("#txtReferenciaActivo").val());
                        }
                    }
                });
            });
        </script>
        <script type="text/javascript">
         /*   if(history.forward(1)){
                location.replace( history.forward(1) );
            } */
        </script>
    </head>
    <%
        String usuario = "";
        //listas que me ayudan a armar el menu
        ArrayList<Menu> listaMenu = new ArrayList<Menu>();
        ArrayList<SubMenu> listaSubMenuProcesos = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSubMenuReportes = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSubMenuMantenimientos = new ArrayList<SubMenu>();
        //valido que la lista menu no este vacio, obtengo el valor de las variables de sesion y las guardo en los arraylist
        if(request.getSession().getAttribute("listaMenu") != null){
            listaMenu = (ArrayList<Menu>)request.getSession().getAttribute("listaMenu");//request.getAttribute("LISTAMENU");
            listaSubMenuProcesos = (ArrayList<SubMenu>)request.getSession().getAttribute("listaSubMenuProcesos");//request.getAttribute("LISTASUBMENUPROCESOS");
            listaSubMenuReportes = (ArrayList<SubMenu>)request.getSession().getAttribute("listaSubMenuReportes");//request.getAttribute("LISTASUBMENUREPORTES");
            listaSubMenuMantenimientos = (ArrayList<SubMenu>)request.getSession().getAttribute("listaSubMenuMantenimientos");//request.getAttribute("LISTASUBMENUMANTENIMIENTOS");
        }
    %>
    <body>
         <body id="bodyprincipal">
        <div id="divcontenedor">
            <div id="divtop">
                <div id="divlogo"></div>
                <div id="divlogueo">
                    <%
                        HttpSession sesion_usuario = request.getSession();
                        
                        if(sesion_usuario.getAttribute("sesUsuario") != null){
                            usuario = sesion_usuario.getAttribute("sesUsuario").toString().toUpperCase();
                        } else {
                            usuario = "";
                            response.sendRedirect("/Pagina_Login.jsp");
                        }
                    %>
                    <form action="ControladorSesion" method="post">
                        <table id="tblCerrarSesion">
                            <tr id="trUsuario">
                                <td><label>Bienvenido: <%= usuario %></label></td>
                            </tr>
                            <tr id="trSubmit">
                                <td><input type="submit" value="Cerrar sesion" name="btnCerrarSesion"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <hr class="hrs">
            <div id="divcontenido">
                <div id="divtitulos">
                    <h3>MODIFICACIÓN DE ACTIVOS</h3>
                </div>
                <form action="ControladorModificacion" method="POST">
                    <div id="divcontrolesinfoactivo">
                        <table>
                            <caption>1. Información del Activo</caption>
                           
                            <tr>
                                <td><label>Activo:</label></td>
                                <td>
                                    <select id="cbnombreactivo" name="cbnombreactivo" required="true" style="width: 173px;">
                                        <option></option>
                                        <!--<option>Seleccione una cuenta</option>-->
                                    </select>
                                </td>
                            </tr>

                            <tr>
                                <td><label>Descripción modificación:</label></td>
                                <td id="taDescripcionmodificacion" colspan="3"><textarea class="input" rows="3" cols="90" id="taDescripcionModificacion" name="taDescripcionModificacion" required="true"></textarea></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label>Departamento:</label></td>
                                <td>
                                    <select id="cbDepartamento" name="cbDepartamento" style="width: 173px;">
                                        <option></option>
                                    </select>
                                </td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label>Valor Agregado: Q.</label></td>
                                <td><input class="input" type="text" id="txtValorAgregado" name="txtValorAgregado" required="true"></td>
                            </tr> 
                            <tr>
                                <td><label>Imagen Activo:</label></td>
                               <td> <!-- <select id="cbCuentasActivos" name="cbCuentasActivos" required="true" style="width: 173px;"> -->
                                        <option></option></td> 
                        
                            </table>
                        <table>
                            <caption style="text-align: left; width: 500px; padding-bottom: 10px; padding-top: 20px; font-weight: bold; font-size: larger;">2. Datos de Responsable y Custodia</caption>
                            <tr>
                                <td><label>Código empleado:</label></td>
                                <td><input class="input" type="text" id="txtCodigoEmpleado" name="txtCodigoEmpleado" required="true"></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td style="width: 225px;"><label>Empleado responsable:</label></td>
                                <td style="width: 180px;"><input type="text" id="txtEmpleadoResponsable" name="txtEmpleadoResponsable" readonly="true"></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label>Puesto empleado:</label></td>
                                <td><input type="text" id="txtPuestoEmpleado" name="txtPuestoEmpleado" readonly="true"></td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label>Departamento:</label></td>
                                <td><input type="text" id="txtDepartamento" name="txtDepartamento" readonly="true"></td>
                                <td style="width: 130px;"><label>Centro de costo:</label></td>
                                <td><input type="text" id="txtCentroCosto" name="txtCentroCosto" readonly="true"></td>
                            </tr>
                            <tr>
                                <td><label>Ubicación:</label></td>
                                <td>
                                    <select id="cbUbicacion" name="cbUbicacion" style="width: 173px;">
                                        <option></option>
                                    </select>
                                </td>
                                <!--<td><input type="text" id="txtUbicacion" name="txtUbicacion" readonly="true"></td>-->
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td><label>Observaciones:</label></td>
                                <td id="taObservaciones" colspan="3"><textarea rows="3" cols="90" id="taObservaciones" name="taObservaciones" required="true"></textarea></td>
                                <td></td>
                                <td></td>
                            </tr>
                           <tr>
                                <td></td>
                                <td id="Actualizar" style="padding-top: 20px;"><input type="submit" value="Actualizar" name="btnActualizar" style="width: 165px; height: 35px;"></td>
                                <td></td>
                                <td></td>
                            </tr> 
                        </table>
                        <br>
                        <br>
                    </div>
                </form>
            </div>
                              <!--  <td></td>
                                   <!-- 
                                        
                                     <!--           MENU               -->         
                                     
                <div class="contenedor-menu">
                <a href="Pagina_Inicio.jsp" class="btn-menu">Menu<i class="icono fas fa-igloo"></i></a>
                <ul class="menu">
                    <% if(listaMenu != null){ %>
                    <% for(Menu menu : listaMenu){ %>
                    <!--LISTA DE ELEMENTOS DE MENU-->
                    <li>
                        <% if(menu.getNombre_menu().equals("PROCESOS")){ %>
                        <a href="#"><i class="icono izquierda fas fa-microchip"></i><%= menu.getNombre_menu() %><i class="icono derecha fas fa-chevron-down"></i></a>
                        <% } %>
                        <% if(menu.getNombre_menu().equals("REPORTES")){ %>
                        <a href="#"><i class="icono izquierda fas fa-paste"></i><%= menu.getNombre_menu() %><i class="icono derecha fas fa-chevron-down"></i></a>
                        <% } %>
                        <% if(menu.getNombre_menu().equals("MANTENIMIENTOS")){ %>
                        <a href="#"><i class="icono izquierda fas fa-oil-can"></i><%= menu.getNombre_menu() %><i class="icono derecha fas fa-chevron-down"></i></a>
                        <% } %>
                    </li>
                    <!--AQUI EMPIEZA LA LISTA DE ELEMENTOS POR MENU-->
                    <ul>
                    <!--LISTA DE ELEMENTOS PROCESOS-->    
                    <% if(menu.getNombre_menu().equals("PROCESOS")){ %>
                        <% if(listaSubMenuProcesos != null){ %>
                            <% for(SubMenu subMenu : listaSubMenuProcesos){ %>
                                <li><a href="<%= subMenu.getNombre_recurso() %>" title=""><%= subMenu.getNombre_submenu() %></a></li>
                            <% } %>
                        <% } %>
                    <% } %>
                    </ul>    
                    <!--LISTA DE ELEMENTOS REPORTES-->
                    <ul>    
                    <% if(menu.getNombre_menu().equals("REPORTES")){ %>
                        <% if(listaSubMenuReportes != null){ %>
                            <% for(SubMenu subMenu : listaSubMenuReportes){ %>
                                <li><a href="<%= subMenu.getNombre_recurso() %>" title=""><%= subMenu.getNombre_submenu() %></a></li>
                            <% } %>
                        <% } %>
                    <% } %>
                    </ul>  
                    <!--LISTA DE ELEMENTOS MANTENIMIENTOS-->
                    <ul>
                    <% if(menu.getNombre_menu().equals("MANTENIMIENTOS")){ %>
                        <% if(listaSubMenuMantenimientos != null){ %>
                            <% for(SubMenu subMenu : listaSubMenuMantenimientos){ %>
                                <li><a href="<%= subMenu.getNombre_recurso() %>" title=""><%= subMenu.getNombre_submenu() %></a></li>
                            <% } %>
                        <% } %>
                    <% } %>
                    </ul>
                    
                    <% } %>
                    <% } %>
                </ul>
            </div>
        </div>
    </body>
</html>

