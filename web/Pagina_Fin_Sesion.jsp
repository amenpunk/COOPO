<%-- 
    Document   : Pagina_Fin_Sesion
    Created on : 30/03/2019, 12:04:53 PM
    Author     : DELLMAYORGA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
    body{
        background-color: #d1e0e0;//#d1e0e0;
    }
    /*#divfinsesion{
        position: relative;
        width: 100%;
        height: 100%;
        text-align: center;
        background-image: url('/imagenes/logo.png'); width: 50%; height: 50%;
        opacity: 20;
    }*/
</style>
<html>
    <head>
        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <meta http-equiv="refresh" content="3; url=/Pagina_Login.jsp">  <!--Temporizador de 1 segundo para redireccionarme a la pagina Login-->
        <title>Fin de sesion</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <script type="text/javascript">
            if(history.forward(1)){
                location.replace( history.forward(1));
            }
        </script>
    </head>
    <body>
        <div>
            Cerrando sesion...
        </div>
    </body>
</html>
