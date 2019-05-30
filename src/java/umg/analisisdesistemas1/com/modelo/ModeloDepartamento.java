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
import umg.analisisdesistemas1.com.objeto.Departamento;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloDepartamento extends Conexion {

    private DataSource ds;
    private Departamento departamento;
    private ArrayList<Departamento> listaDepartamento = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ArrayList<Departamento> obtenerListaDepartamento(int codigo_compania) throws Exception {

        ResultSet rs = null;
        listaDepartamento = new ArrayList<Departamento>();

        try {
            st = conn.createStatement();
            //1 Primero, establezco la conexion
            // conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_departamentos(?)}";
            PreparedStatement cs = conn.prepareStatement(sql);

            //cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, codigo_compania);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo_departamento = rs.getInt("codigo_departamento");
                String nombre_departamento = rs.getString("nombre_departamento");
                String telefono_departamento = rs.getString("telefono_departamento");
                int cod_compania = rs.getInt("codigo_compania");
                departamento = new Departamento(codigo_departamento, nombre_departamento, telefono_departamento, cod_compania);
                listaDepartamento.add(departamento);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return listaDepartamento;
    }
}
