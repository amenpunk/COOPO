<%--
    Document   : Reporte_Ficha_Activos
    Created on : 13/04/2019, 04:47:20 PM
    Author     : DELLMAYORGA
--%>

<%@page import="umg.analisisdesistemas1.com.objeto.SubMenu"%>
<%@page import="umg.analisisdesistemas1.com.objeto.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <style type="text/css">
        #bodyprincipal{
            position: absolute;
            width: 100%;
            overflow-x: no-display;
            margin-left: 0px;
        }
        #divcontenedor{
            position: fixed;
            width: 100%;
            height: 100%;
            margin-left: 0px;
            background-color: #fff;
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
            background-color: #d1e0e0;
            border-right: #ccc 1px solid;
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
            float: left;
            width: 100%;
            text-align: center;
            margin-top: 1%;
            color: #A4A4A4;
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

        }
        tr{
            height: 25px;
        }
        td{

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
            font-size: larger;
        }
        .cb{
            width: 173px;
        }
        input{
            margin-left:5px;
        }
    </style>


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Ficha de Activos</title>

    <link rel="stylesheet" href="https://code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
    <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
    <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
    <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <link rel="stylesheet" href="css/menu.css">
    <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
</head>



<%
    String usuario = "";
    //listas que me ayudan a armar el menu
    ArrayList<Menu> listaMenu = new ArrayList<Menu>();
    ArrayList<SubMenu> listaSubMenuProcesos = new ArrayList<SubMenu>();
    ArrayList<SubMenu> listaSubMenuReportes = new ArrayList<SubMenu>();
    ArrayList<SubMenu> listaSubMenuMantenimientos = new ArrayList<SubMenu>();
    //valido que la lista menu no este vacio, obtengo el valor de las variables de sesion y las guardo en los arraylist
    if (request.getSession().getAttribute("listaMenu") != null) {
        listaMenu = (ArrayList<Menu>) request.getSession().getAttribute("listaMenu");//request.getAttribute("LISTAMENU");
        listaSubMenuProcesos = (ArrayList<SubMenu>) request.getSession().getAttribute("listaSubMenuProcesos");//request.getAttribute("LISTASUBMENUPROCESOS");
        listaSubMenuReportes = (ArrayList<SubMenu>) request.getSession().getAttribute("listaSubMenuReportes");//request.getAttribute("LISTASUBMENUREPORTES");
        listaSubMenuMantenimientos = (ArrayList<SubMenu>) request.getSession().getAttribute("listaSubMenuMantenimientos");//request.getAttribute("LISTASUBMENUMANTENIMIENTOS");
    }
%>
<body id="bodyprincipal">
    <div id="divcontenedor">
        <div id="divtop">
            <div id="divlogo"></div>
            <div id="divlogueo">
                <%
                    HttpSession sesion_usuario = request.getSession();

                    if (sesion_usuario.getAttribute("sesUsuario") != null) {
                        usuario = sesion_usuario.getAttribute("sesUsuario").toString().toUpperCase();
                    } else {
                        usuario = "";
                        response.sendRedirect("/Pagina_Login.jsp");
                    }
                %>
                <form action="ControladorSesion" method="post">
                    <table id="tblCerrarSesion">
                        <tr id="trUsuario">
                            <td><label>Bienvenido: <%= usuario%></label></td>
                        </tr>
                        <tr id="trSubmit">
                            <td><input type="submit" value="Cerrar sesion" name="btnCerrarSesion"></td>

                        </tr>
                    </table>
                </form>
            </div>
        </div>

        <script>
            $(document).ready(function () {

                alert("JQUERY ON");
                $.getJSON("/https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorListaEmpleado", function (respuesta) {
                    $.each(respuesta, function (key, value) {
                        $("#empleados").append("<option value='" + value.codigo_empleado + "'>" + value.nombre_empleado + " " + value.apellido_empleado + "</option>");
                    });
                });


                $.getJSON("/https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorRol", function (respuesta) {
                    $.each(respuesta, function (key, value) {
                        //console.log(value.codigo);
                        //alert(value.nombre);
                        $("#nombre_rol").append("<option value='" + value.codigo + "'>" + value.nombre + "</option>");
                    });
                });


                //alert("hola mundo");

                $.getJSON("/https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorListaUsuarios", function (respuesta) {
                    $.each(respuesta, function (key, value) {
                        //console.log(value.codigo);
                        //alert(value.nombre);
                        $("#nombre_usuario").append("<option value='" + value.usu_codigo + "'>" + value.usu_user + "</option>");
//$("#nombre_usuario").append("<option value='" + value.usu_codigo + " data-price='" + value.usu_codigo + "'>" + value.usu_user + "</option>");
                        //$('#nombre_usuario').append("<option value='" + value.usu_codigo + "' data-price='" + value.codigo"' >" + value.usu_user + "</option>");
                    });
                });


            });
            // $.getJSON("/ControladorCuentasActivo",
        </script>


        <hr class="hrs">
        <div id="divcontenido">
            <div id="divtitulos">
                <h3>Mantenimiento de Usuarios</h3>
            </div>
            </br></br>





            </br></br></br>


            <form action="ControladorIngresoUsuarioNuevo" method="POST">
                <label >Empleado: </label>
                <select id="empleados" name="id_empleado" style="margin-left: 17px; width: 300px;">
                    <option></option>
                </select>

                </br></br>

                <label for="nombre_rol">Rol: </label>
                <select id="nombre_rol" name="id_rol" style="margin-left: 67px; width: 250px">
                    <option></option>
                </select>

                </br></br>

                <label for="estado">Estado: </label>
                <select id="estado" name="id_estado" style="width: 173px; margin-left: 40px">
                    <option value="A">Activo</option>
                    <option value="B">De baja</option>
                </select>

                </br></br>
                <hr width="100%" style="color: #1e1e1e;"/>
                </br></br>
                <label for="nombre">Usuario: </label>
                <input type="text" id="nombre" name="usu_nombre" style="margin-left:33px">
                </br></br>
                <label for="pass">Contraseña: </label>
                <input type="text" id="pass" name="usu_password">
                </br></br>

                <input type="submit" value="Actualizar Datos" style="margin-left:168px; height: 25px;">

            </form>



        </div>
        <script>

            /*
             $('.found').on('click', function () {
             var selected = $('#nombre_usuario');
             var value = selected.val();
             //alert("valor:" + value + " price: " + price + "color" + color);

             });
             */
            /*
             $('#nombre_empleado').change(function (event) {
             var selec = $('#nombre_empleado');
             var valor = selec.val();
             $.getJSON("/ControladorListaEmpleado",
             function(data){
             $.each(data,function(key,value){

             });
             });
             });

             $('#nombre_usuario').change(function (event) {
             var selected = $('#nombre_usuario');
             var value = selected.val();
             $.getJSON("/ControladorUsuarioRol",
             {opcion: value},
             function (data) {

             $.each(data, function (key, value) {
             $('#nombre').val(value.usu_user);
             $('#pass').val(value.usu_password);
             $('#alta').val(value.usu_fecha_alta);
             $('#baja').val(value.usu_fecha_baja);
             $('#rol_codigo').val(value.rol_codigo);
             });
             //$('#tabla_empleado').append(data_empleado);
             });
             });
             $('#nombre_rol').change(function (event) {
             var varSec = $('#nombre_rol');
             var valor = varSec.val();
             $('#codigo_rol').val(valor);
             });

             */



        </script>

        <!--Aqui comienza el menu-->
        <div class="contenedor-menu">
            <a href="Pagina_Inicio.jsp" class="btn-menu">Menu<i class="icono fas fa-igloo"></i></a>
            <ul class="menu">
                <% if (listaMenu != null) { %>
                <% for (Menu menu : listaMenu) { %>
                <!--LISTA DE ELEMENTOS DE MENU-->
                <li>
                    <% if (menu.getNombre_menu().equals("PROCESOS")) {%>
                    <a href="#"><i class="icono izquierda fas fa-microchip"></i><%= menu.getNombre_menu()%><i class="icono derecha fas fa-chevron-down"></i></a>
                            <% } %>
                            <% if (menu.getNombre_menu().equals("REPORTES")) {%>
                    <a href="#"><i class="icono izquierda fas fa-paste"></i><%= menu.getNombre_menu()%><i class="icono derecha fas fa-chevron-down"></i></a>
                            <% } %>
                            <% if (menu.getNombre_menu().equals("MANTENIMIENTOS")) {%>
                    <a href="#"><i class="icono izquierda fas fa-oil-can"></i><%= menu.getNombre_menu()%><i class="icono derecha fas fa-chevron-down"></i></a>
                            <% } %>
                </li>
                <!--AQUI EMPIEZA LA LISTA DE ELEMENTOS POR MENU-->
                <ul>
                    <!--LISTA DE ELEMENTOS PROCESOS-->
                    <% if (menu.getNombre_menu().equals("PROCESOS")) { %>
                    <% if (listaSubMenuProcesos != null) { %>
                    <% for (SubMenu subMenu : listaSubMenuProcesos) {%>
                    <li><a href="<%= subMenu.getNombre_recurso()%>" title=""><%= subMenu.getNombre_submenu()%></a></li>
                        <% } %>
                        <% } %>
                        <% } %>
                </ul>
                <!--LISTA DE ELEMENTOS REPORTES-->
                <ul>
                    <% if (menu.getNombre_menu().equals("REPORTES")) { %>
                    <% if (listaSubMenuReportes != null) { %>
                    <% for (SubMenu subMenu : listaSubMenuReportes) {%>
                    <li><a href="<%= subMenu.getNombre_recurso()%>" title=""><%= subMenu.getNombre_submenu()%></a></li>
                        <% } %>
                        <% } %>
                        <% } %>
                </ul>
                <!--LISTA DE ELEMENTOS MANTENIMIENTOS-->
                <ul>
                    <% if (menu.getNombre_menu().equals("MANTENIMIENTOS")) { %>
                    <% if (listaSubMenuMantenimientos != null) { %>
                    <% for (SubMenu subMenu : listaSubMenuMantenimientos) {%>
                    <li><a href="<%= subMenu.getNombre_recurso()%>" title=""><%= subMenu.getNombre_submenu()%></a></li>
                        <% } %>
                        <% } %>
                        <% } %>
                </ul>

                <% } %>
                <% }%>
            </ul>
        </div>
    </div>
</body>
</html>
