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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.modelo.ModeloCodigoActivo;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorCodigoActivo extends HttpServlet {
    private ModeloCodigoActivo modeloCodigoActivo = null;
    @javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String otro = "";
    
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try{
            modeloCodigoActivo = new ModeloCodigoActivo(ds);
        } catch(Exception ex){
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
        String valor_referencia = "";
        String cadenaJSON = "";
        String mensaje = "";
        
        try{
            String codigo_referencia =  request.getParameter("codigo_referencia");
            valor_referencia = modeloCodigoActivo.obtenerCodigoActivo(codigo_referencia);
            
            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            
            if(!codigo_referencia.equals("")){
                cadenaJSON = "[{\"codigo_ref\":\""+ valor_referencia +"\"}]";   //creo una cadena con formato JSON
                response.getWriter().write(cadenaJSON);
            }
        } catch(Exception e){
            mensaje = e.getMessage();
        } finally{
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
