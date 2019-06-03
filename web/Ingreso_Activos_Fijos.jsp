<%--
    Document   : Ingreso_Activos_Fijos.jsp
    Created on : 29/03/2019, 06:35:39 PM
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
        //background-color: #fff;
    }
    #divcontenedor{
        position: fixed;
        width: 100%;
        height: 100%;
        margin-left: 0px;
        background-color: #fff; //#d1e0e0;      //el fondo era como verdecito
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
        border-left: solid #A4A4A4;
        overflow-y: auto;
        overflow-x: hidden;
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
    #divtitulos{
        //position: relative;
        float: left;
        width: 100%;
        text-align: center;
        //background-color: #fff;
        margin-top: 1%;
        color: #A4A4A4;
        //background-color: #fff;
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
        //border: 1px solid #E6E6E6;
        //width: 95%;
    }
    tr{
        height: 25px;
    }
    td{
        //border: 1px solid #E6E6E6;
        //width: 10%;
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

            <link rel="stylesheet" href="https://code.jquery.com/ui/1.8.10/themes/smoothness/jquery-ui.css" type="text/css">
            <script type="text/javascript" src="https://ajax.aspnetcdn.com/ajax/jquery.ui/1.8.10/jquery-ui.min.js"></script>
            <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
            <meta http-equiv="Content-Type" content="application/json; charset=UTF-8">
            <title>Inicio</title>
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
            <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
            <link rel="stylesheet" href="css/menu.css">
            <script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
            <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
            <script type="text/javascript">
                //script con el que voy a manejar los combobox de las cuentas contables
                //con el siguiente codigo mando a traer la info en formato json del servlet y lleno el cbCuentasActivos
                //por default se procesa en el metodo doGet del servlet
                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorCuentasActivo", //nombre del servlet que me devuelve el json
                        {tipo_cuenta: 1}, //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                        function (respuesta_servlet) {
                            $.each(respuesta_servlet,
                                    function (key, value) {
                                        $("#cbCuentasActivos").append("<option value='" + value.referencia_cuenta + "'>" + value.nombre_cuenta + "</option>");
                                    });
                        });
                //llenando el combo de las cuentas de pasivo
                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorCuentasPasivo", //nombre del servlet que me devuelve el json
                        {tipo_cuenta: 2}, //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                        function (respuesta_servlet) {
                            $.each(respuesta_servlet,
                                    function (key, value) {
                                        $("#cbCuentasPasivo").append("<option value='" + value.referencia_cuenta + "'>" + value.nombre_cuenta + "</option>");
                                    });
                        });
                //llenando el combo de las cuentas de gasto
                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorCuentasGasto", //nombre del servlet que me devuelve el json
                        {tipo_cuenta: 3}, //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                        function (respuesta_servlet) {
                            $.each(respuesta_servlet,
                                    function (key, value) {
                                        $("#cbCuentasGasto").append("<option value='" + value.referencia_cuenta + "'>" + value.nombre_cuenta + "</option>");
                                    });
                        });
                //llenando el combo de los departamentos
                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorDepartamento", //nombre del servlet que me devuelve el json
                        {codigo_compania: 1}, //le envio el codigo de la compania que es 1
                        function (respuesta_servlet) {
                            $.each(respuesta_servlet,
                                    function (key, value) {
                                        $("#cbDepartamento").append("<option value='" + value.codigo_departamento + "'>" + value.nombre_departamento + "</option>");
                                        $("#cbUbicacion").append("<option value='" + value.codigo_departamento + "'>" + value.nombre_departamento + "</option>");
                                    });
                        });
                //llenando el combo de los proveedores
                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorProveedor", //nombre del servlet que me devuelve el json
                        {opcion: 1}, //le envio la opcion al servlet
                        function (respuesta_servlet) {
                            $.each(respuesta_servlet,
                                    function (key, value) {
                                        $("#cbProveedor").append("<option value='" + value.codigo_proveedor + "'>" + value.nombre_proveedor + "</option>");
                                    });
                        });


                //con el siguiente codigo uso el jquery y utilizo el evento change del combobox
                $(document).ready(function () {
                    //evento change para el combobox de activos
                    $("#cbCuentasActivos").change(function (event) {
                        var referencia_cuenta = $("select#cbCuentasActivos").val();      //con esto obtengo el codigo de la cuenta
                        var nombre_cuenta = $("#cbCuentasActivos :selected").text(); //con esto obtengo el nombre de la cuenta
                        //swal("Good job!", "You clicked the button!", "success");
                        if ($("#cbCuentasActivos :selected").text() === "Seleccione una cuenta") { //valido el primer elemento del combobox
                            $("#txtReferenciaActivo").val('');
                        } else {
                            $("#txtReferenciaActivo").val($("select#cbCuentasActivos").val()); //al control txtTexto le pongo el nombre seleccionado
                            //Le pongo el codigo del activo al campo codigo activo
                            $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorCodigoActivo", {codigo_referencia: $("#txtReferenciaActivo").val()}, function (respuesta) {
                                $.each(respuesta, function (key, valor) {
                                    console.log("Estoy enviando datos desde la consola: " + valor.codigo_ref);
                                    $("#txtCodigoActivo").val(valor.codigo_ref);
                                });
                            });
                            /*$.ajax({
                             url: "/ControladorCodigoActivo",
                             dataType: 'json',
                             type: 'GET',
                             data: { codigo_referencia : $("#txtReferenciaActivo").val() },
                             success: function(json){
                             alert("SI TRAE DATOS EL SERVLET");
                             console.log("Estoy enviando datos desde la consola: " + json.codigo_ref);
                             }
                             });*/
                        }
                    });
                    //evento change para el combobox de pasivo
                    $("#cbCuentasPasivo").change(function (event) {
                        var referencia_cuenta = $("select#cbCuentasPasivo").val();      //con esto obtengo el codigo de la cuenta
                        var nombre_cuenta = $("#cbCuentasPasivo :selected").text(); //con esto obtengo el nombre de la cuenta
                        if ($("#cbCuentasPasivo :selected").text() === "Seleccione una cuenta") { //valido el primer elemento del combobox
                            $("#txtRefDepreAcumulada").val('');
                        } else {
                            $("#txtRefDepreAcumulada").val($("select#cbCuentasPasivo").val()); //al control txtTexto le pongo el nombre seleccionado
                        }
                    });
                    //evento change para el combobox de cuentas gasto
                    $("#cbCuentasGasto").change(function (event) {
                        var referencia_cuenta = $("select#cbCuentasGasto").val();      //con esto obtengo el codigo de la cuenta
                        var nombre_cuenta = $("#cbCuentasGasto :selected").text(); //con esto obtengo el nombre de la cuenta
                        if ($("#cbCuentasGasto :selected").text() === "Seleccione una cuenta") { //valido el primer elemento del combobox
                            $("#txtRefCuentaGasto").val('');
                        } else {
                            $("#txtRefCuentaGasto").val($("select#cbCuentasGasto").val()); //al control txtTexto le pongo el nombre seleccionado
                        }
                    });
                    //evento de la tecla tab sobre el input del valor de adquisicion
                    $("#txtValorAdquisicion").keydown(function (event) {  //evento de presionar la tecla
                        if (event.keyCode == 9) { //codigo de la tecla tab
                            //alert("Presiono la tecla tab");
                            var txtReferenciaActivo = document.getElementById("txtReferenciaActivo");
                            if ($("#txtReferenciaActivo").val() !== "") {
                                if ($("#txtValorAdquisicion").val() !== "") {
                                    //alert("El valor de la aquisicione es: " + $("#txtValorAdquisicion").val());
                                    $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorCalculosContables", //nombre del servlet que me devuelve el json
                                            {opcion: 1, referencia_activo: $("#txtReferenciaActivo").val(), valor_adquisicion: $("#txtValorAdquisicion").val()}, //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                                            function (respuesta_servlet) {
                                                $.each(respuesta_servlet,
                                                        function (key, value) {
                                                            //asigno los valores que trae el json a los controles input del html
                                                            $("#txtValorInicialLibros").val(value.valor_libros_incial);
                                                            $("#txtPorcentajeDepreciacion").val(value.porcentaje_depreciacion);
                                                            $("#txtDepreciacionAnual").val(value.valor_depreciacion_anual);
                                                            $("#txtDepreciacionMensual").val(value.valor_depreciacion_mensual);
                                                        });
                                            });
                                } else {
                                    alert("¡Debe ingresar el valor de la adquisicion!");
                                }
                            } else {
                                alert("¡Debe seleccionar una cuenta de activo!");
                                //alert("El valor es: "+$("#txtReferenciaActivo").val());
                            }
                        }
                    });

                    //evento de la tecla tab sobre el input del valor de codigo de empleado
                    $("#txtCodigoEmpleado").keydown(function (event) {  //evento de presionar la tecla
                        if (event.keyCode == 9) { //codigo de la tecla tab
                            //alert("Presiono la tecla tab");
                            if ($("#txtCodigoEmpleado").val() !== "") {
                                $.getJSON("https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorDatosInstitucionalesEmpleado", //nombre del servlet que me devuelve el json
                                        {codigo_empleado: $("#txtCodigoEmpleado").val()}, //parametro tipo_cuenta que le envio al servlet lleva llaves por es json
                                        function (respuesta_servlet) {
                                            $.each(respuesta_servlet, function (key, value) {
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
                /*if(history.forward(1)){
                 location.replace( history.forward(1) );
                 }*/
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
                        <form action="https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorSesion" method="post">
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
                <hr class="hrs">
                <div id="divcontenido">
                    <div id="divtitulos">
                        <h3>INGRESO DE ACTIVOS</h3>
                    </div>
                    <form action="https://coopoprueba.azurewebsites.net/ActivosFijosCopo/ControladorIngresoActivo" method="POST">
                        <div id="divcontrolesinfoactivo">
                            <table>
                                <caption>1. Información del Activo</caption>
                                <tr>
                                    <td style="width: 225px;"><label>Código:</label></td>
                                    <td style="width: 180px;"><input class="input" type="text" id="txtCodigoActivo" name="txtCodigoActivo" readonly="true" required="true"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Descripción corta:</label></td>
                                    <td><input class="input" type="text" id="txtDescripcionCorta" name="txtDescripcionCorta" required="true" autofocus="true"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Descripción larga:</label></td>
                                    <td id="tdDescripcionlarga" colspan="3"><textarea class="input" rows="3" cols="90" id="taDescripcionLarga" name="taDescripcionLarga" required="true"></textarea></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Cuenta de activo:</label></td>
                                    <td>
                                        <select id="cbCuentasActivos" name="cbCuentasActivos" required="true" style="width: 173px;">
                                            <option></option>
                                            <!--<option>Seleccione una cuenta</option>-->
                                        </select>
                                    </td>
                                    <td><label>Referencia activo:</label></td>
                                    <td><input class="input" type="text" id="txtReferenciaActivo" name="txtReferenciaActivo" readonly="true" required="true"></td>
                                </tr>
                                <tr>
                                    <td><label>Cuenta Depreciacion Acum.:</label></td>
                                    <td>
                                        <select id="cbCuentasPasivo" name="cbCuentasPasivo" required="true" style="width: 173px;">
                                            <option></option>
                                            <!--<option>Seleccione una cuenta</option>-->
                                        </select>
                                    </td>
                                    <td style="width: 200px;"><label>Ref. depre. acumulada:</label></td>
                                    <td style="width: 200px;"><input class="input" type="text" id="txtRefDepreAcumulada" name="txtRefDepreAcumulada" readonly="true" required="true"></td>
                                </tr>
                                <tr>
                                    <td><label>Cuenta de gasto:</label></td>
                                    <td>
                                        <select id="cbCuentasGasto" name="cbCuentasGasto" required="true" style="width: 173px;">
                                            <option></option>
                                            <!--<option>Seleccione una cuenta</option>-->
                                        </select>
                                    </td>
                                    <td style="width: 200px;"><label>Ref. cuenta gasto:</label></td>
                                    <td style="width: 200px;"><input class="input" type="text" id="txtRefCuentaGasto" name="txtRefCuentaGasto" readonly="true" required="true"></td>
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
                                    <td><label>Fecha adquisición:</label></td>
                                    <td><input type="date" id="dtFechaAdquisicion" name="dtFechaAdquisicion" required="true" style="width: 173px;"></td>
                                    <td><label>Fecha inicio depreciación:</label></td>
                                    <td><input type="date" id="dtFechaInicioDepreciacion" name="dtFechaInicioDepreciacion" required="true" style="width: 173px;"></td>
                                </tr>
                                <tr>
                                    <td><label>Valor adquisición:</label></td>
                                    <td><input class="input" type="text" id="txtValorAdquisicion" name="txtValorAdquisicion" required="true"></td>
                                    <td><label>Valor inicial libros:</label></td>
                                    <td><input type="text" id="txtValorInicialLibros" name="txtValorInicialLibros" readonly="true"></td>
                                </tr>
                                <tr>
                                    <td><label>% Depreciación:</label></td>
                                    <td><input type="text" id="txtPorcentajeDepreciacion" name="txtPorcentajeDepreciacion" readonly="true"></td>
                                    <td><label>Depreciación mensual</label></td>
                                    <td><input type="text" id="txtDepreciacionMensual" name="txtDepreciacionMensual" readonly="true"></td>
                                </tr>
                                <tr>
                                    <td><label>Depreciación anual:</label></td>
                                    <td><input type="text" id="txtDepreciacionAnual" name="txtDepreciacionAnual" readonly="true"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                            <table>
                                <caption style="text-align: left; width: 500px; padding-bottom: 10px; padding-top: 20px; font-weight: bold; font-size: larger;">2. Datos de Adquisición del Activo</caption>
                                <tr>
                                    <td style="width: 225px;"><label>Proveedor:</label></td>
                                    <!--<td style="width: 180px;"><input class="input" type="text" id="txtProveedor" name="txtProveedor" required="true"></td>-->
                                    <td>
                                        <select id="cbProveedor" name="cbProveedor" style="width: 173px;">
                                            <option></option>
                                        </select>
                                    </td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Fecha factura:</label></td>
                                    <td><input type="date" id="dtFechaFactura" name="dtFechaFactura" required="true" style="width: 173px;"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Número y serie factura:</label></td>
                                    <td><input class="input" type="text" id="txtNumeroSerieFactura" name="txtNumeroSerieFactura" required="true"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td><label>Monto(IVA incluído):</label></td>
                                    <td><input class="input" type="text" id="txtMontoFactura" name="txtMontoFactura" required="true"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                            <table>
                                <caption style="text-align: left; width: 500px; padding-bottom: 10px; padding-top: 20px; font-weight: bold; font-size: larger;">3. Datos de Responsable y Custodia</caption>
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
                                    <td id="tdDescripcionlarga" colspan="3"><textarea rows="3" cols="90" id="taDescripcionLarga" name="taDescripcionLarga" required="true"></textarea></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <tr>
                                    <td></td>
                                    <td style="padding-top: 20px;"><input type="submit" value="Guardar" name="btnGuardar" style="width: 165px; height: 35px;"></td>
                                    <td></td>
                                    <td></td>
                                </tr>
                            </table>
                            <br>
                            <br>
                        </div>
                    </form>
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

