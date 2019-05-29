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
import umg.analisisdesistemas1.com.objeto.Conexion;
import umg.analisisdesistemas1.com.objeto.CuentaContable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloCodigoActivo extends Conexion {

    private DataSource ds;
    private String codigo_activo = "";

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloCodigoActivo(DataSource ds) {
        this.ds = ds;
    }

    public ModeloCodigoActivo() throws SQLException {
        this.st = conn.createStatement();
    }

    public String obtenerCodigoActivo(String codigo_referencia) {

        ResultSet rs = null;

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{? = call fn_genera_codigo_activo(?)}";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            //3 setear los parametros de salida de la funcion, y de entrada ya que devuelve el codigo esta funcion
            //cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, codigo_referencia);
            cs.execute();
            while (rs.next()) {
                codigo_activo = rs.getString(1);
            }
            //5 Asigno el valor de la consulta a la variable

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return codigo_activo;
    }
}
