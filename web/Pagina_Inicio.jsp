<%--
    Document   : Pagina_Inicio
    Created on : 26/02/2019, 08:20:28 PM
    Author     : DELLMAYORGA
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
    }
    #divcontenedor{
        position: fixed;
        width: 100%;
        height: 100%;
        margin-left: 0px;
        background-color: #d1e0e0;
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
        //background-color: #FF0000;
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
        background-color: /*#FF0000;*/ #d1e0e0; /*#01A9DB;*/  //color de fondo del menu
        //border-right: #ccc 10px solid;
        border-right: #ccc 1px solid;
        //z-index: 0;
    }
    #divcontenido{
        position: relative;
        float: right;
        margin-right: 2px;
        width: 76%;
        height: 85%;
        //background-color: black;
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


    //este es el CSS del menu
    /*#divmenu{
        width: 100%;
        height: 100%;
        //border-right: #ccc 1px solid;
    }
    #divleft ul {
        list-style-type: none;
        margin: 0px;
        padding: 0px;
        width: 98%;
        font-family: Arial, sans-serif;
        font-size: 11pt;
    }
    #divleft ul li {
        background-color: #d1e0e0;//#E6E6E6;  //color de fondo del menu
    }
    #divleft ul li a {
        color: black;//#ccc;
        text-decoration: none;
        text-transform: uppercase;
        display: block;
        padding: 10px 10px 10px 20px;
        vertical-align: middle;
    }
    #divleft ul li a:hover {
        background: #01A9DB;//#000;
        border-left: 10px solid #F78181;
        color: #fff;
    }*/
</style>


<html>
    <head>

        <link rel="stylesheet" href="https://code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
        <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="css/menu.css">
        <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
        <script src="js/main.js" type="text/javascript"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
        <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
        <!--El contenido de este script no funciona, lo quería hacer como acordeon, pero no me funciono-->
        <script type="text/javascript">
            /*if(history.forward(1)){
             location.replace( history.forward(1) );
             }*/

        </script>

    </head>
    <%
        String usuario = "";
        ArrayList<Menu> listaMenu = new ArrayList<Menu>();
        ArrayList<SubMenu> listaSubMenuProcesos = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSubMenuReportes = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSubMenuMantenimientos = new ArrayList<SubMenu>();

        //obtengo el valor de las variables de sesion y las guardo en los arraylist
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
                            response.sendRedirect("Pagina_Login.jsp");
                        }
                    %>
                    <form action="ControladorSesion" method="post">
                        <table>
                            <tr>
                                <td><label>Bienvenido: <%= usuario%></label></td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="Cerrar sesion" name="btnCerrarSesion"></td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
            <hr class="hrs">
            <div id="divcontenido">

            </div>

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
                        <!--<li><a href="<%= subMenu.getNombre_recurso()%>" onclick="document.getElementById('formprocesos').submit()" title=""><%= subMenu.getNombre_submenu()%></a></li>-->
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
