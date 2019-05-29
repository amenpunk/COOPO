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

import umg.analisisdesistemas1.com.objeto.Rol;

/**
 *
 * @author Neon
 */
public class ModeloRol {

    private DataSource ds;
    private Rol rol;
    private ArrayList<Rol> ListaRol = null;

    public ModeloRol(DataSource ds) {
        this.ds = ds;
    }

    public ArrayList<Rol> obtenerRol() throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        ListaRol = new ArrayList<Rol>();
        try {
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_rol}";
            cs = conexion.prepareCall(sql);
            cs.execute();
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nombre = rs.getString("nombre");
                rol = new Rol(codigo, nombre);
                ListaRol.add(rol);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return ListaRol;
    }

}
