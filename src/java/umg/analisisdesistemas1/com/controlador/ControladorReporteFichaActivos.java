/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.controlador;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.j2ee.servlets.BaseHttpServlet;
import umg.analisisdesistemas1.com.modelo.ModeloReporte;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorReporteFichaActivos extends HttpServlet {
    private ModeloReporte modeloReporte = null;
    @javax.annotation.Resource(name = "pool_conexiones")
    private DataSource ds;
    private String otro = "";
    
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try{
            modeloReporte = new ModeloReporte(ds);
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorReporte</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorReporte at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        JasperReport reporte = null;
        JasperDesign disenio = null;
        Map<String, Object> parametros = new HashMap<String, Object>();
        String codigo_activo = null;
        String descripcion_corta = null;
        String referencia_activo = null;
        String fecha_inicial = null;
        String fecha_final = null;
        String codigo_proveedor = null;
        String factura = null;
        String codigo_empleado = null;
        String mensaje = null;
        
        try{
            if(request.getParameter("txtCodigoActivo") != null && !request.getParameter("txtCodigoActivo").toString().equals("")){
                codigo_activo = request.getParameter("txtCodigoActivo");
            }
            if(request.getParameter("txtDescripcionCorta") != null && !request.getParameter("txtDescripcionCorta").toString().equals("")){
                descripcion_corta = request.getParameter("txtDescripcionCorta");
            }
            if(request.getParameter("cbCuentasActivos") != null && !request.getParameter("cbCuentasActivos").toString().equals("")){
                referencia_activo = request.getParameter("cbCuentasActivos");
            }
            if(request.getParameter("dtFechaAdquisicionIni") != null && !request.getParameter("dtFechaAdquisicionIni").toString().equals("")){
                String fechaI = request.getParameter("dtFechaAdquisicionIni");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //este es el formato que me devuelve el datepicker
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd"); //este es el formato que quiero obtener y guardar en la BDD
                fecha_inicial = sdf2.format(sdf.parse(fechaI));
            }
            if(request.getParameter("dtFechaAdquisicionFin") != null && !request.getParameter("dtFechaAdquisicionFin").toString().equals("")){
                String fechaF = request.getParameter("dtFechaAdquisicionFin");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  //este es el formato que me devuelve el datepicker
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMdd"); //este es el formato que quiero obtener y guardar en la BDD
                fecha_final = sdf2.format(sdf.parse(fechaF));
            }
            if(request.getParameter("cbProveedor") != null && !request.getParameter("cbProveedor").toString().equals("")){
                codigo_proveedor = request.getParameter("cbProveedor");
            }
            if(request.getParameter("txtFactura") != null && !request.getParameter("txtFactura").toString().equals("")){
                factura = request.getParameter("txtFactura");
            }
            if(request.getParameter("cbResponsable") != null && !request.getParameter("cbResponsable").toString().equals("")){
                codigo_empleado = request.getParameter("cbResponsable");
            }
            
            String path = getServletContext().getRealPath("//");
            disenio = JRXmlLoader.load(path + "/reportes/rptFichaActivosFijos.jrxml");
            reporte = JasperCompileManager.compileReport(disenio);
            parametros.put("codigo_activo", codigo_activo);
            parametros.put("descripcion_corta", descripcion_corta);
            parametros.put("referencia_activo", referencia_activo);
            parametros.put("fecha_adquisicion_desde", fecha_inicial);
            parametros.put("fecha_adquisicion_hasta", fecha_final);
            parametros.put("codigo_proveedor", codigo_proveedor);
            parametros.put("factura", factura);
            parametros.put("codigo_empleado", codigo_empleado);
            byte[] byteStream = JasperRunManager.runReportToPdf(reporte, parametros, modeloReporte.obtenerConexion());
            response.setContentType("application/pdf");
            response.setContentLength(byteStream.length);
            ServletOutputStream outStream = response.getOutputStream();
            outStream.write(byteStream, 0, byteStream.length);
            outStream.flush();
            outStream.close();
        } catch(Exception e){
            mensaje = e.getMessage();
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
