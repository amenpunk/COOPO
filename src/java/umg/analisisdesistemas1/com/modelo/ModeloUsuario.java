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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloUsuario extends Conexion {

    private DataSource ds;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloUsuario(Conexion conc) {
        this.conc = conc;
    }

    public ModeloUsuario() throws SQLException {
        this.st = conn.createStatement();
    }

    public String mensajeLogueo(String usuario, String password) throws Exception {

        ResultSet rs = null;
        String mensaje = "";

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_logueo_usuario(?, ?, ?)}";
            //cs = conexion.prepareCall(sql);
            PreparedStatement cs = conn.prepareStatement(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, usuario);
            cs.setString(2, password);
            //4 registro el parametro de salida
            //cs.registerOutParameter(3, Types.VARCHAR);
            //5 ejecutar la consulta
            cs.execute();
            while (rs.next()) {
                mensaje = rs.getString("mensaje");
            }

            //6 obtener el valor que devuelve la funcion y asignarse a una variable
            //mensaje = cs.getString(3);
        } catch (Exception e) {
            System.out.println("Mensaje de error: " + e.getMessage());
        }

        return mensaje;
    }
}
