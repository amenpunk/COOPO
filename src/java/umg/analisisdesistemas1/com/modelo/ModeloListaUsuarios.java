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
import java.util.ArrayList;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author Neon
 */
public class ModeloListaUsuarios extends Conexion {

    private DataSource ds;
    private Usuario usuario;
    private ArrayList<Usuario> ListaUsuarios = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ArrayList<Usuario> ObtenerUsuarios() throws Exception {

        ResultSet rs = null;
        ListaUsuarios = new ArrayList<Usuario>();
        try {
            st = conn.createStatement();
            //conexion = ds.getConnection();
            String sql = "{call sp_obtener_lista_usuarios}";
            //cs = conexion.prepareCall(sql);
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs.setInt(1, cod);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo = rs.getInt("usu_codigo");
                String nombre = rs.getString("usu_user");

                usuario = new Usuario(codigo, nombre);
                ListaUsuarios.add(usuario);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return ListaUsuarios;
    }

}
