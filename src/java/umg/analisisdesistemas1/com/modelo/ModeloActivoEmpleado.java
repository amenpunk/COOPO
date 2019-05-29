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
import umg.analisisdesistemas1.com.objeto.ActivoEmpleado;

/**
 *
 * @author Neon
 */
public class ModeloActivoEmpleado {

    private DataSource ds;
    private ActivoEmpleado activoEmpleado;
    private ArrayList<ActivoEmpleado> listaActivo = null;

    public ModeloActivoEmpleado(DataSource ds) {
        this.ds = ds;
    }

    public ArrayList<ActivoEmpleado> obtenerInfo(int cod) throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaActivo = new ArrayList<ActivoEmpleado>();
        try {
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_activo_empleado(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, cod);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {

                String codigo_clas = rs.getString("clas");
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descrip");
                String cuenta_activo = rs.getString("cuenta");
                String fecha_adqui = rs.getString("fecha");
                String valor_inicial = rs.getString("valor");

                activoEmpleado = new ActivoEmpleado(codigo_clas, nombre, descripcion, cuenta_activo, fecha_adqui, valor_inicial);
                listaActivo.add(activoEmpleado);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaActivo;
    }
}
