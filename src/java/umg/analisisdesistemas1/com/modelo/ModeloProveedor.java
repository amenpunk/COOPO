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

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloProveedor {
    private DataSource ds;
    private Proveedor proveedor;
    private ArrayList<Proveedor> listaProveedor = null;
    
    public ModeloProveedor(DataSource ds) {
        this.ds = ds;
    }
    
    public ArrayList<Proveedor> obtenerListaProveedor(int opcion) throws Exception{
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaProveedor = new ArrayList<Proveedor>();
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_proveedores(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while(rs.next()){
                int codigo_proveedor = rs.getInt("codigo_proveedor");
                String nombre_proveedor = rs.getString("nombre_proveedor");
                proveedor = new Proveedor(codigo_proveedor, nombre_proveedor);
                listaProveedor.add(proveedor);
            }
        } catch(Exception e){
            
        }
        
        return listaProveedor;
    }
}
