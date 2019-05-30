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
import javax.sql.DataSource;
import java.sql.Types;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author Neon
 */
public class ModeloNuevoUsuario extends Conexion {

    private DataSource ds;
    private String mensaje = "";

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public String ingresarUsuario(String usu_user, String usu_password, int emp_codigo, int rol_codigo) {

        ResultSet rs = null;
        try {
            st = conn.createStatement();
            //conexion = ds.getConnection();
            String sql = "{call sp_ingresar_nuevo_usuario(?, ?, ?, ?, ?)}";
            PreparedStatement cs = conn.prepareStatement(sql);
            //cs = conexion.prepareCall(sql);
            cs.setString(1, usu_user);
            cs.setString(2, usu_password);
            cs.setInt(3, emp_codigo);
            cs.setInt(4, rol_codigo);

            //cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
            }

            //mensaje = cs.getString(5);
        } catch (Exception e) {

        }

        return mensaje;
    }

}
