/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.modelo;

import umg.analisisdesistemas1.com.objeto.Usuario;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Date;
import javax.sql.DataSource;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author Neon
 */
public class ModeloUsuarioRol extends Conexion {

    private DataSource ds;
    private Usuario usuario;
    private ArrayList<Usuario> ListaUserRol = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloUsuarioRol(DataSource ds) {
        this.ds = ds;
    }

    public ModeloUsuarioRol() throws SQLException {
        this.st = conn.createStatement();
    }

    public ArrayList<Usuario> ObtenerUsuario(int cod) throws Exception {

        ResultSet rs = null;
        ListaUserRol = new ArrayList<Usuario>();
        try {
            //conexion = ds.getConnection();
            String sql = "{call sp_obtener_usuario (?)}";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            cs.setInt(1, cod);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {

                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                String pass = rs.getString("pass");
                Date alta = rs.getDate("alta");
                Date baja = rs.getDate("baja");
                int emp_codigo = rs.getInt("em_cod");
                int rol_codigo = rs.getInt("rol_cod");

                usuario = new Usuario(codigo, nombre, pass, alta, baja, emp_codigo, rol_codigo);
                ListaUserRol.add(usuario);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ListaUserRol;
    }

}
