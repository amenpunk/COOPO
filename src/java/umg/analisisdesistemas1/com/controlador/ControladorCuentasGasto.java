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
import umg.analisisdesistemas1.com.modelo.ModeloCuentaContable;
import umg.analisisdesistemas1.com.objeto.CuentaContable;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorCuentasGasto extends HttpServlet {

    private ModeloCuentaContable modeloCuentaContable = null;
    //@javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String mensaje = "";

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try {
            modeloCuentaContable = new ModeloCuentaContable(ds);
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
        int tipo_cuenta = 0;    //1. activos, 2. pasivos, 3. gastos
        String listaGastos = "";

        try {
            tipo_cuenta = Integer.valueOf(request.getParameter("tipo_cuenta"));

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            //Hago una eleccion de lo que va a enviar el controlador al javascript
            if (tipo_cuenta == 3) {   //si el tipo de cuenta es gasto
                ArrayList<CuentaContable> listaCuentaGastos = new ArrayList<CuentaContable>();
                listaCuentaGastos = modeloCuentaContable.obtenerListaCuentaContable(tipo_cuenta);     //obtengo la lista de cuenta de gastos
                Gson gsonGastos = new Gson();
                listaGastos = gsonGastos.toJson(listaCuentaGastos);
                response.getWriter().write(listaGastos);
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
