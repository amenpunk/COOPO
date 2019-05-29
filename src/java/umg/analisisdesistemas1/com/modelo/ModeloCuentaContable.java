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
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.Conexion;
import umg.analisisdesistemas1.com.objeto.CuentaContable;
import java.sql.PreparedStatement;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloCuentaContable extends Conexion {

    private DataSource ds;
    private CuentaContable cuentaContable;
    private ArrayList<CuentaContable> listaCuentaContable = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloCuentaContable(Conexion conc) {
        this.conc = conc;
    }

    public ModeloCuentaContable() throws SQLException {
        this.st = conn.createStatement();
    }

    //opcion 1: activos
    public ArrayList<CuentaContable> obtenerListaCuentaContable(int opcion) throws Exception {

        ResultSet rs = null;
        listaCuentaContable = new ArrayList<CuentaContable>();

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_cuentas_contables(?)}";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo_cuenta = rs.getInt("codigo_cuenta");
                String nombre_cuenta = rs.getString("nombre_cuenta");
                String referencia_cuenta = rs.getString("referencia");
                float porcentaje_depreciacion = rs.getFloat("porcentaje_depreciacion");
                cuentaContable = new CuentaContable(codigo_cuenta, nombre_cuenta, referencia_cuenta, porcentaje_depreciacion);
                listaCuentaContable.add(cuentaContable);
            }
        } catch (Exception e) {
            String mensaje = e.getMessage();
            System.out.println(e.getMessage());
        }

        return listaCuentaContable;
    }
}
