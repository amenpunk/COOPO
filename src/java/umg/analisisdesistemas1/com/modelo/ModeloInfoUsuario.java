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
import umg.analisisdesistemas1.com.objeto.Conexion;
import umg.analisisdesistemas1.com.objeto.infoEmpleado;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Neon
 */
public class ModeloInfoUsuario extends Conexion {

    private DataSource ds;
    private infoEmpleado info;
    private ArrayList<infoEmpleado> listaInfo = null;
    //public Conexion conc = new Conexion();
    //Connection cnx = null;
    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;
    //public Connection conn = conc.getConexion();

    public ModeloInfoUsuario(DataSource ds) {
        this.ds = ds;
    }

    public ModeloInfoUsuario() throws SQLException {
        this.st = conn.createStatement();
    }

    public ArrayList<infoEmpleado> obtenerInfo(int cod) throws Exception {

        //Connection conexion = null;
        //Statement st = null;
        //CallableStatement cs = null;
        ResultSet rs = null;

        listaInfo = new ArrayList<infoEmpleado>();
        try {

            //String connectionUrl = "jdbc:sqlserver://testcoopo.database.windows.net:1433;databaseName=ACTIVOS_FIJOS;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_info_empleado(?)}";
            //ResultSet rs = st.executeQuery(sql);
            PreparedStatement ps = conn.prepareStatement(sql);

            //cs = conc.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            ps.setInt(1, cod);
            //4 ejecutar la consulta
            ps.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = ps.getResultSet();
            while (rs.next()) {
                String nombre = rs.getString("emp_nombres");
                String apellidos = rs.getString("emp_apellidos");
                String direccion = rs.getString("emp_direccion");
                String fecha_alta = rs.getString("emp_fecha_alta");
                String fecha_baja = rs.getString("emp_fecha_baja");
                info = new infoEmpleado(nombre, apellidos, direccion, fecha_alta, fecha_baja);
                listaInfo.add(info);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaInfo;
    }
}
