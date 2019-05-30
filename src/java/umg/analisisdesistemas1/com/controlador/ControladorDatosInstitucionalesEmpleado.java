/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.controlador;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.modelo.ModeloDatosEmpleado;
import umg.analisisdesistemas1.com.objeto.DatosEmpleado;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorDatosInstitucionalesEmpleado extends HttpServlet {

    private ModeloDatosEmpleado modeloDatosEmpleado = null;
    //@javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String mensaje = "";

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try {
            modeloDatosEmpleado = new ModeloDatosEmpleado();
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorDatosInstitucionalesEmpleado</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorDatosInstitucionalesEmpleado at " + request.getContextPath() + "</h1>");
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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //processRequest(request, response);
        String datos_empleado = "";
        int codigo_empleado = 0;

        try {
            codigo_empleado = Integer.valueOf(request.getParameter("codigo_empleado"));

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            ArrayList<DatosEmpleado> listaDatosEmpleado = new ArrayList<DatosEmpleado>();
            listaDatosEmpleado = modeloDatosEmpleado.obtenerDatosResponsableActivo(codigo_empleado);
            Gson gson = new Gson();
            datos_empleado = gson.toJson(listaDatosEmpleado);
            response.getWriter().write(datos_empleado);
        } catch (Exception e) {

        } finally {
            out.flush();
        }
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
