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
import java.util.ArrayList;
import javax.sql.DataSource;
import umg.analisisdesistemas1.com.objeto.DatosEmpleado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloDatosEmpleado extends Conexion {

    private DataSource ds;
    private DatosEmpleado datosEmpleado = null;
    private ArrayList<DatosEmpleado> listaDatosEmpleado = null;
    private String mensaje_error = "";

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ArrayList<DatosEmpleado> obtenerDatosResponsableActivo(int codigo_empleado) {

        ResultSet rs = null;
        listaDatosEmpleado = new ArrayList<DatosEmpleado>();

        try {
            st = conn.createStatement();
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_datos_empleado_responsable(?, ?, ?, ?, ?, ?)}";
            //cs = conexion.prepareCall(sql);
            PreparedStatement cs = conn.prepareStatement(sql);
            //3 setear los parametros de salida de la funcion, y de entrada ya que devuelve el codigo esta funcion
            cs.setInt(1, codigo_empleado);
            /*
            cs.registerOutParameter(2, Types.VARCHAR);
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, Types.VARCHAR);
            cs.registerOutParameter(5, Types.VARCHAR);
            cs.registerOutParameter(6, Types.VARCHAR);
            //4 ejecutar la consulta
             */
            cs.execute();
            //5 Asigno el valor de la consulta a la variable
            rs = cs.getResultSet();
            while (rs.next()) {
                String nombre_empleado = rs.getString("nombre_empleado");
                String departamento = rs.getString("departamento");
                String puesto = rs.getString("puesto");
                String centro_costo = rs.getString("centro_costo");
                String mensaje = rs.getString("mensaje");
                datosEmpleado = new DatosEmpleado(nombre_empleado, departamento, puesto, centro_costo, mensaje);
                listaDatosEmpleado.add(datosEmpleado);
            }
        } catch (Exception e) {
            mensaje_error = e.getMessage();
        }

        return listaDatosEmpleado;
    }
}
