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
import umg.analisisdesistemas1.com.objeto.Proveedor;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import umg.analisisdesistemas1.com.objeto.Conexion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloProveedor extends Conexion {

    private DataSource ds;
    private Proveedor proveedor;
    private ArrayList<Proveedor> listaProveedor = null;

    public Conexion conc = new Conexion();
    public Connection conn = conc.getConexion();
    Statement st;

    public ArrayList<Proveedor> obtenerListaProveedor(int opcion) throws Exception {

        ResultSet rs = null;
        listaProveedor = new ArrayList<Proveedor>();

        try {
            st = conn.createStatement();
            //1 Primero, establezco la conexion
            //conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_proveedores(?)}";
            //cs = conexion.prepareCall(sql);
            PreparedStatement cs = conn.prepareStatement(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while (rs.next()) {
                int codigo_proveedor = rs.getInt("codigo_proveedor");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                proveedor = new Proveedor(codigo_proveedor, nombre_proveedor);
                listaProveedor.add(proveedor);
            }
        } catch (Exception e) {

        }

        return listaProveedor;
    }
}
