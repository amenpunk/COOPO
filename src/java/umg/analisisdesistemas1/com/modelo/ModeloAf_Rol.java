/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Types;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.AF_ROL;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author Neon
 */
public class ModeloAf_Rol extends Conexion {

    private DataSource ds;
    private String mensaje = "";

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public String ingresarRol(String nombre) throws Exception {

        ResultSet rs = null;

        try {
            st = conn.createStatement();
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_ingresar_rol(?,?)}";
            PreparedStatement cs = conn.prepareStatement(sql);
            //cs = conexion.prepareCall(sql);
            cs.setString(1, nombre);
            //cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
            }
            //mensaje = cs.getString(2);
            //rs = cs.getResultSet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mensaje;
    }

}
