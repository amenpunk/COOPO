/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.modelo.ModeloActivo;

/**
 *
 * @author Richard
 */
public class ControladorModificacion extends HttpServlet {

    private ModeloActivo modeloActivo = null;
    //@javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String mensaje = "";

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try {
            modeloActivo = new ModeloActivo();
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorModificacion</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorModificacion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int opcion;
        int codigo_activo;
        String descripcion = "";
        int codigo_empleado;
        float valor_adquisicion;
        String observaciones = "";
        int codigo_departamento;
        int ubicacion;
        mensaje = "";

        try {
            opcion = 1;
            codigo_activo = Integer.parseInt(request.getParameter("cbnombreactivo"));
            descripcion = request.getParameter("taDescripcionModificacion");
            codigo_empleado = Integer.parseInt(request.getParameter("txtCodigoEmpleado"));
            valor_adquisicion = Float.parseFloat(request.getParameter("txtValorAgregado"));
            observaciones = request.getParameter("taObservaciones");
            codigo_departamento = Integer.parseInt(request.getParameter("cbDepartamento"));
            ubicacion = Integer.parseInt(request.getParameter("cbUbicacion"));

            mensaje = modeloActivo.mensajeModificacionActivo(opcion, codigo_activo, descripcion, codigo_empleado, valor_adquisicion, observaciones, codigo_departamento, ubicacion);

            if (mensaje.equals("ACTUALIZADO")) {   //si el mensaje es
                /*Enviamos un mensaje de que se guardo el activo, para esto usamos sweetalert
                enviando desde este servlet el script que contiene jquery y sweetalert, para mostrar un bonti
                mensaje de alerta en la página JSP*/
                pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                pw.println("<script>");
                pw.println("$(document).ready(function(){");
                pw.println("swal('GUARDADO','¡El activo fué guardado con éxito!', 'success');");  //alert estilo sweetalert exito
                //pw.println("swal('ERROR','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert error
                //pw.println("swal('ADVERTENCIA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert warning
                //pw.println("swal('INFORMACION','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert info
                //pw.println("swal('PREGUNTA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert question
                pw.println("});");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("/Pagina_Inicio.jsp");
                rd.include(request, response);
            } else if (mensaje.equals("NO SE PUDO ACTUALIZAR")) {     //si el mensaje es de fallo
                pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
                pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
                pw.println("<script>");
                pw.println("$(document).ready(function(){");
                //pw.println("swal('WELCOME','successfull !', 'success');");
                pw.println("swal('ERROR','¡Ocurrio un error al guardar el activo!', 'error');");  //alert estilo sweetalert error
                //pw.println("swal('ADVERTENCIA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert warning
                //pw.println("swal('INFORMACION','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert info
                //pw.println("swal('PREGUNTA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert question
                pw.println("});");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("/Pagina_Inicio.jsp");
                rd.include(request, response);
            }
        } catch (Exception e) {
            pw.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
            pw.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
            pw.println("<script>");
            pw.println("$(document).ready(function(){");
            //pw.println("swal('WELCOME','successfull !', 'success');");
            pw.println("swal('ERROR','¡Ocurrio un error al guardar el activo! Por favor, vuelva a intentarlo.', 'error');");  //alert estilo sweetalert error
            //pw.println("swal('ADVERTENCIA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert warning
            //pw.println("swal('INFORMACION','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert info
            //pw.println("swal('PREGUNTA','El activo fué guardado con éxito', 'success');");  //alert estilo sweetalert question
            pw.println("});");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("/Pagina_Inicio.jsp");
            rd.include(request, response);
        } finally {

        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
