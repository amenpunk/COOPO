<%--
    Document   : index
    Created on : 25/02/2019, 10:23:23 PM
    Author     : DELLMAYORGA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
    #bodylogin{
        position: absolute;
        width: 100%;
        overflow-x: no-display;
        margin-left: 0px;
    }
    #divgeneral{
        position: fixed;
        width: 100%;
        height: 100%;
        overflow-x: no-display;
    }
    #divcontenidologin{
        position: relative;
        width: 100%;
        height: 70%;
        background-color: #d1e0e0;//#f3da0b;//#d1e0e0;
        overflow-x: no-display;
        text-align: center;
        vertical-align: middle;
    }
    #divlogin{
        position: relative;
        width: 30%;
        height: 100%;
        margin: 0px auto;
    }
    #diva{
        position: relative;
        float: left;
        width: 100%;
        height: 20%;
    }
    #divb{
        position: relative;
        float: left;
        width: 100%;
        height: 60%;
    }
    #divc{
        position: relative;
        float: left;
        width: 100%;
        height: 20%;
    }
    #tbllogin{
        width: 100%;
    }
    /*#divimg{
        width: 100%;
        height: 100%;
        background-image: url("/imagenes/logo.png");
        background-repeat: no-repeat;
        background-size: 40%;
        padding-top: 5px;
        background-position-y: center;
    }*/
</style>

<html>
    <head>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
        <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
        <link rel="stylesheet" href="//code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
        <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
        <script type="text/javascript" src="//ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
        <!--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="css/menu.css">
        <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>-->
        <!--<script src="js/main.js" type="text/javascript"></script>-->
    </head>
    <%
        String mensaje_logueo = "";
        if (request.getAttribute("mensaje") != null) {
            mensaje_logueo = request.getAttribute("mensaje").toString();
        } else {
            mensaje_logueo = "";
        }
    %>
    <body id="bodylogin">
        <div id="divgeneral">
            <%@include file="/plantillas/plantilla_encabezado.jsp" %>
            <div id="divcontenidologin">
                <div id="divlogin">
                    <div id="diva">

                    </div>
                    <div id="divb">
                        <form action="ControladorUsuario" method="post">
                            <table id="tbllogin" style="border-style: solid; border-bottom-left-radius: 10px; border-bottom-right-radius: 10px; border-top-left-radius: 10px; border-top-right-radius: 10px;">
                                <tr style="height: 10px;"><div id="divimg"></div></tr>
                                <tr>
                                    <td colspan="6" style="height: 50px; font-weight: bold; font">INICIO DE SESION</td>
                                </tr>
                                <tr style="text-align: right;">
                                    <th><img src="<%= request.getContextPath()%>/imagenes/usuario.png" style="width: 24px;" /></th>
                                    <th style="text-align: left; width: 75px;"><label>Usuario:</label></th>
                                    <th style="text-align: left; width: 100px;"><input type="text" name="txtUsuario" value="" autofocus="" /></th>
                                    <th></th>
                                </tr>
                                <tr style="text-align: right;">
                                    <th><img src="<%= request.getContextPath()%>/imagenes/password.png" style="width: 24px;" /></th>
                                    <th style="text-align: left;">Password:</th>
                                    <th style="text-align: left; font-size: larger;"><input type="password" name="txtPassword" value="" /></th>
                                    <th></th>
                                </tr>
                                <tr style="">
                                    <td colspan="4" style="text-align: right; color: #FF0000"><%=mensaje_logueo%></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th style="text-align: right; padding-top: 10px;"><input type="submit" value="Ingresar" /></th>
                                    <th></th>
                                </tr>
                                <tr style="height: 10px;"></tr>
                            </table>
                        </form>
                    </div>
                    <div id="divc">

                    </div>
                </div>
            </div>
            <%@include file="/plantillas/plantilla_footer.jsp" %>
        </div>
    </body>
</html>
