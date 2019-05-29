<%-- 
    Document   : plantilla_menu
    Created on : 27/02/2019, 07:37:57 PM
    Author     : DELLMAYORGA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style type="text/css">
    #divmenu{
        width: 100%;
        height: 100%;
        border-right: #ccc 1px solid;
    }
    #divmenu ul {
        list-style-type: none;
        margin: 0px;
        padding: 0px;
        width: 98%;
        font-family: Arial, sans-serif;
        font-size: 11pt;
    }
    #divmenu ul li {
        background-color: #d1e0e0;//#E6E6E6;  //color de fondo del menu
    }
    #divmenu ul li a {
        color: black;//#ccc;
        text-decoration: none;
        text-transform: uppercase;
        display: block;
        padding: 10px 10px 10px 20px;
        vertical-align: middle;
    }
    #divmenu ul li a:hover {
        background: #01A9DB;//#000;
        border-left: 10px solid #F78181;
        color: #fff;
    }
    /*#hrv{
        float: right;
        width: 1px;
        height: 100%;
    }*/
</style>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <div id="divmenu">
            <ul>
                <li><a href="Pagina_Catalogo_Productos.jsp" title=""><img src="/imagenes/flechaderecha.png" width="18px;" style="vertical-align: top; margin-right: 10px;">Procesos</a></li>
                <li><a href="Pagina_Agregar_Productos.jsp" title=""><img src="/imagenes/flechaderecha.png" width="18px;" style="vertical-align: top; margin-right: 10px;">Reportes</a></li>
                <li><a href="Pagina_Actualizar_Productos.jsp" title=""><img src="/imagenes/flechaderecha.png" width="18px;" style="vertical-align: top; margin-right: 10px;">Mantenimientos</a></li>
                <li><a href="Pagina_Eliminar_Productos.jsp" title=""><img src="/imagenes/flechaderecha.png" width="18px;" style="vertical-align: top; margin-right: 10px;">Parametros</a></li>
            </ul>
        </div>
    </body>
</html>
