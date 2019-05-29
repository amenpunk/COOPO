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

import umg.analisisdesistemas1.com.objeto.Empleado;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloEmpleado extends Conexion {

    private DataSource ds;
    private Empleado empleado;
    private ArrayList<Empleado> listaEmpleado = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloEmpleado(DataSource ds) {
        this.ds = ds;
    }

    public ModeloEmpleado() throws SQLException {
        this.st = conn.createStatement();
    }

    public ArrayList<Empleado> obtenerListaEmpleado(int opcion) throws Exception {

        ResultSet rs = null;
        listaEmpleado = new ArrayList<Empleado>();

        try {
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_empleado(?)}";
            //cs = conexion.prepareCall(sql);
            PreparedStatement cs = conn.prepareStatement(sql);

            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo_empleado = rs.getInt("codigo_empleado");
                String nombre_empleado = rs.getString("nombre_empleado");
                empleado = new Empleado(codigo_empleado, nombre_empleado);
                listaEmpleado.add(empleado);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaEmpleado;
    }
}
