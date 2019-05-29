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
import umg.analisisdesistemas1.com.objeto.Empleado;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloEmpleado {
    private DataSource ds;
    private Empleado empleado;
    private ArrayList<Empleado> listaEmpleado = null;
    
    public ModeloEmpleado(DataSource ds) {
        this.ds = ds;
    }
    
    public ArrayList<Empleado> obtenerListaEmpleado(int opcion) throws Exception{
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaEmpleado = new ArrayList<Empleado>();
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtener_empleado(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while(rs.next()){
                int codigo_empleado = rs.getInt("codigo_empleado");
                String nombre_empleado = rs.getString("nombre_empleado");
                empleado = new Empleado(codigo_empleado, nombre_empleado);
                listaEmpleado.add(empleado);
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return listaEmpleado;
    }
}
