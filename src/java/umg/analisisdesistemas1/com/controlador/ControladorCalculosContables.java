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
import umg.analisisdesistemas1.com.modelo.ModeloCalculoContable;
import umg.analisisdesistemas1.com.objeto.CalculoDepreciacion;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorCalculosContables extends HttpServlet {

    private ModeloCalculoContable modeloCalculoContable = null;
    //@javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String mensaje = "";
    Conexion con = new Conexion();

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try {
            modeloCalculoContable = new ModeloCalculoContable();
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
        //response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        String jsonDepreciacion = "";
        String referencia_activo = "";
        float valor_adquisicion = 0;
        int opcion = 0;

        try {
            opcion = Integer.valueOf(request.getParameter("opcion"));   //variable que viene del jsp javascript
            referencia_activo = String.valueOf(request.getParameter("referencia_activo"));  //variable que viene del jsp javascript
            valor_adquisicion = Float.valueOf(request.getParameter("valor_adquisicion"));   //variable que viene del jsp javascript

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");

            if (opcion == 1) {    //calculos de depreciaciones
                ArrayList<CalculoDepreciacion> listaCalculosDepreciacion = new ArrayList<CalculoDepreciacion>();
                listaCalculosDepreciacion = modeloCalculoContable.obtenerCalculoDepreciacion(referencia_activo, valor_adquisicion);
                Gson gsonGastos = new Gson();
                jsonDepreciacion = gsonGastos.toJson(listaCalculosDepreciacion);
                response.getWriter().write(jsonDepreciacion);
            }
        } catch (Exception e) {

        } finally {
            out.flush();
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
