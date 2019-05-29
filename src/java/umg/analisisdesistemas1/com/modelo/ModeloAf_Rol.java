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
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.AF_ROL;

/**
 *
 * @author Neon
 */
public class ModeloAf_Rol {

    private DataSource ds;
    private String mensaje = "";

    public ModeloAf_Rol(DataSource ds) {
        this.ds = ds;
    }

    public String ingresarRol(String nombre) throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;

        try {
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_ingresar_rol(?,?)}";
            cs = conexion.prepareCall(sql);
            cs.setString(1, nombre);
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.execute();
            mensaje = cs.getString(2);
            //rs = cs.getResultSet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return mensaje;
    }

}
