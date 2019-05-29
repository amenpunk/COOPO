/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.Menu;
import umg.analisisdesistemas1.com.objeto.SubMenu;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloMenu extends Conexion {

    private DataSource ds;
    private Menu menu;
    private SubMenu subMenu;
    private ArrayList<Menu> listaMenu;
    private ArrayList<SubMenu> listaSubMenu;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloMenu(Conexion conc) {

        this.conc = conc;
    }

    public ModeloMenu() throws SQLException {
        this.st = conn.createStatement();
    }

    public ArrayList<Menu> obtenerListaMenu(String usuario) throws Exception {

        listaMenu = new ArrayList<Menu>();
        ResultSet rs = null;
        String mensaje = "";

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_menu_usuario(?)}";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, usuario);
            //4 registro el parametro de salida
            //cs.registerOutParameter(3, Types.VARCHAR);
            //5 ejecutar la consulta
            cs.execute();
            //6 obtener el valor que devuelve la funcion y asignarse a una variable
            //mensaje = cs.getString(3);
            //6 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo_menu = rs.getInt("codigo_menu");
                String nombre_menu = rs.getString("menu");
                menu = new Menu(codigo_menu, nombre_menu);
                listaMenu.add(menu);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaMenu;
    }

    public ArrayList<SubMenu> obtenerListaSubMenu(String usuario, int codigo_menu) throws Exception {

        listaSubMenu = new ArrayList<SubMenu>();
        ResultSet rs = null;
        String mensaje = "";

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_submenu_usuario(?, ?)}";
            PreparedStatement cs = conn.prepareStatement(sql);
            //cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, usuario);
            cs.setInt(2, codigo_menu);
            //4 registro el parametro de salida
            //cs.registerOutParameter(3, Types.VARCHAR);
            //5 ejecutar la consulta
            cs.execute();
            //6 obtener el valor que devuelve la funcion y asignarse a una variable
            //mensaje = cs.getString(3);
            //6 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                String menu = rs.getString("menu");
                String nombre_submenu = rs.getString("submenu");
                String nombre_recurso = rs.getString("recurso");
                String imagen = rs.getString("imagen");

                subMenu = new SubMenu(nombre_submenu, nombre_recurso, imagen);
                listaSubMenu.add(subMenu);
            }
        } catch (Exception e) {
            mensaje = e.getMessage();
            System.out.println(e.getMessage());
        }

        return listaSubMenu;
    }
}
