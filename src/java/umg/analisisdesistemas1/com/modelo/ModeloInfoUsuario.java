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
import umg.analisisdesistemas1.com.objeto.infoEmpleado;

/**
 *
 * @author Neon
 */
public class ModeloInfoUsuario {

    private DataSource ds;
    private infoEmpleado info;
    private ArrayList<infoEmpleado> listaInfo = null;

    public ModeloInfoUsuario(DataSource ds) {
        this.ds = ds;
    }

    public ArrayList<infoEmpleado> obtenerInfo(int cod) throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaInfo = new ArrayList<infoEmpleado>();
        try {
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_info_empleado(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, cod);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
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
