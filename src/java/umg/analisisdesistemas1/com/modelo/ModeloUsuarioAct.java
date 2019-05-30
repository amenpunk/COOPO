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
public class ModeloUsuarioAct extends Conexion {

    private DataSource ds;
    private Usuario usuario;
    private ArrayList<Usuario> ListaAct = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ArrayList<Usuario> ActualizarUsuario() throws Exception {

        ResultSet rs = null;
        ListaAct = new ArrayList<Usuario>();

        try {
            st = conn.createStatement();
            //conexion = ds.getConnection();
            String sql = "{call sp_actualizar_usuario (?)}";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return ListaAct;
    }

}
