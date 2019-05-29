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
 * @author Neon
 */
public class ModeloListaEmpleado extends Conexion {

    private DataSource ds;
    private Empleado empleado;
    private ArrayList<Empleado> ListaEmpleado = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ModeloListaEmpleado(DataSource ds) {
        this.ds = ds;
    }

    public ModeloListaEmpleado() throws SQLException {
        this.st = conn.createStatement();
    }

    public ArrayList<Empleado> ObtenerEmpleados() throws Exception {

        ResultSet rs = null;
        ListaEmpleado = new ArrayList<Empleado>();
        try {
            //conexion = ds.getConnection();
            String sql = "{call sp_obtener_lista_empleados }";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            //cs.setInt(1, cod);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo = rs.getInt("emp_codigo");
                String nombre = rs.getString("emp_nombres");
                String apellido = rs.getString("emp_apellidos");
                empleado = new Empleado(codigo, nombre, apellido);
                ListaEmpleado.add(empleado);
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ListaEmpleado;
    }

}
