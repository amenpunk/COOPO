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

/**
 *
 * @author Neon
 */
public class ModeloUsuarioAct {

    private DataSource ds;
    private Usuario usuario;
    private ArrayList<Usuario> ListaAct = null;

    public ModeloUsuarioAct(DataSource ds) {
        this.ds = ds;
    }

    public ArrayList<Usuario> ActualizarUsuario() throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ListaAct = new ArrayList<Usuario>();

        try {
            conexion = ds.getConnection();
            String sql = "{call sp_actualizar_usuario (?)}";

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return ListaAct;
    }

}
