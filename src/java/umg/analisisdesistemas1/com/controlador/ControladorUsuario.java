/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.modelo.ModeloCuentaContable;
import umg.analisisdesistemas1.com.modelo.ModeloMenu;
import umg.analisisdesistemas1.com.modelo.ModeloUsuario;
import umg.analisisdesistemas1.com.objeto.Conexion;
import umg.analisisdesistemas1.com.objeto.CuentaContable;
import umg.analisisdesistemas1.com.objeto.Menu;
import umg.analisisdesistemas1.com.objeto.SubMenu;

/**
 *
 * @author DELLMAYORGA
 */
public class ControladorUsuario extends HttpServlet {

    private ModeloUsuario modeloUsuario = null;
    private ModeloMenu modeloMenu = null;
    //private Conexion con = new Conexion();
    private ModeloCuentaContable modeloCuentaContable = null;
    //@javax.annotation.Resource(name = "pool_conexiones")
    //private DataSource ds;
    private String mensaje = "";

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        try {
            modeloUsuario = new ModeloUsuario();
            modeloMenu = new ModeloMenu();
            modeloCuentaContable = new ModeloCuentaContable();
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
            out.println("<title>Servlet ControladorUsuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ControladorUsuario at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        ArrayList<Menu> listaMenu = new ArrayList<Menu>();
        ArrayList<SubMenu> listaSuMenuProcesos = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSuMenuReportes = new ArrayList<SubMenu>();
        ArrayList<SubMenu> listaSuMenuMantenimientos = new ArrayList<SubMenu>();

        if (!request.getParameter("txtUsuario").toString().equals("") && !request.getParameter("txtPassword").toString().equals("")) {  //valido que se hallan rellenado los campos de usuario y contraseña
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtPassword");

            try {
                mensaje = modeloUsuario.mensajeLogueo(usuario, password);

                //creo una sesion que se va a llamar sesUsuario
                request.getSession().setAttribute("sesUsuario", usuario);
                //obtengo la lista opciones del menu al que tiene acceso el usuario.
                listaMenu = modeloMenu.obtenerListaMenu(usuario);
                //obtengo la lista de submenu del menu al que tiene acceso el usuario.
                listaSuMenuProcesos = modeloMenu.obtenerListaSubMenu(usuario, 1);           //submenu procesos
                listaSuMenuReportes = modeloMenu.obtenerListaSubMenu(usuario, 2);           //submenu reportes
                listaSuMenuMantenimientos = modeloMenu.obtenerListaSubMenu(usuario, 3);     //submenu mantenimientos
                //guardo los arraylist en variables de sesion
                request.getSession().setAttribute("listaMenu", listaMenu);
                request.getSession().setAttribute("listaSubMenuProcesos", listaSuMenuProcesos);
                request.getSession().setAttribute("listaSubMenuReportes", listaSuMenuReportes);
                request.getSession().setAttribute("listaSubMenuMantenimientos", listaSuMenuMantenimientos);
                //agrego las listas de menu y submenu al request
                request.setAttribute("LISTAMENU", listaMenu);
                request.setAttribute("LISTASUBMENUPROCESOS", listaSuMenuProcesos);
                request.setAttribute("LISTASUBMENUREPORTES", listaSuMenuReportes);
                request.setAttribute("LISTASUBMENUMANTENIMIENTOS", listaSuMenuMantenimientos);

                RequestDispatcher rd = request.getRequestDispatcher("/Pagina_Inicio.jsp");
                rd.forward(request, response);

            } catch (Exception e) {
                System.out.println("Mensaje de error:" + e.getMessage());
            }
        } else {
            request.setAttribute("mensaje", "¡Debe ingresar su usuario y contraseña!");
            RequestDispatcher rd = request.getRequestDispatcher("/Pagina_Login.jsp");
            rd.forward(request, response);
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
