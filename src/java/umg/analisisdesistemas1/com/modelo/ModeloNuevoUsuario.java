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

/**
 *
 * @author Neon
 */
public class ModeloNuevoUsuario {

    private DataSource ds;
    private String mensaje = "";

    public ModeloNuevoUsuario(DataSource ds) {
        this.ds = ds;
    }

    public String ingresarUsuario(String usu_user, String usu_password, int emp_codigo, int rol_codigo) {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            conexion = ds.getConnection();
            String sql = "{call sp_ingresar_nuevo_usuario(?, ?, ?, ?, ?)}";
            cs = conexion.prepareCall(sql);
            cs.setString(1, usu_user);
            cs.setString(2, usu_password);
            cs.setInt(3, emp_codigo);
            cs.setInt(4, rol_codigo);

            cs.registerOutParameter(5, Types.VARCHAR);
            cs.execute();
            mensaje = cs.getString(5);
        } catch (Exception e) {

        }

        return mensaje;
    }

}
