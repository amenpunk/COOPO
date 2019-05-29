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
import umg.analisisdesistemas1.com.objeto.Activo;

/**
 *
 * @author Richard
 */
public class ModeloActivo {
    private DataSource ds;
    private Activo activo;
    private Activo detalle; 
    private ArrayList<Activo> listaActivo = null;
    private ArrayList<Activo> listaActivoAlta = null; 
    
    
    public ModeloActivo(DataSource ds) {
        this.ds = ds;
    }
    
    public ArrayList<Activo> obtenerListaActivoAlta(int opcion) throws Exception{
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaActivoAlta = new ArrayList<Activo>();
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtiene_activos_alta(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while(rs.next()){
                int codigo_activo = rs.getInt("codigo_activo");
                String nombre_activo = rs.getString("nombre_activo");
                activo = new Activo(codigo_activo, nombre_activo);
                listaActivoAlta.add(activo);
            }
        }catch(Exception ex){
            
        }
        
        return listaActivoAlta;
    }
    
    public ArrayList<Activo> obtenerListaActivo(int opcion) throws Exception{
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaActivo = new ArrayList<Activo>();
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_obtiene_todos_activos(?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while(rs.next()){
                int codigo_activo = rs.getInt("codigo_activo");
                String nombre_activo = rs.getString("nombre_activo");
                activo = new Activo(codigo_activo, nombre_activo);
                listaActivo.add(activo);
            }
        }catch(Exception ex){
            
        }
        
        return listaActivo;
    }
    
    public String mensajeBajaActivo(int opcion, int codigo_activo, int motivo_baja, String descripcion_baja){
        String mensaje = "";
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_baja_activos(?,?,?,?,?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            cs.setInt(2, codigo_activo);
            cs.setInt(3, motivo_baja);
            cs.setString(4, descripcion_baja);
            cs.registerOutParameter(5, Types.VARCHAR);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un String
            mensaje = cs.getString(5);
        } catch(Exception ex){
            mensaje = ex.getMessage();
        }
        
        return mensaje;
    }
    
    public String mensajeModificacionActivo(int opcion, int codigo_activo, String descripcion, int codigo_empleado, float valor_adquisicion, String observaciones, int codigo_departamento, int ubicacion){
        String mensaje = "";
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_modificar_activo(?,?,?,?,?,?,?,?,?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setInt(1, opcion);
            cs.setInt(2, codigo_activo);
            cs.setString(3, descripcion);
            cs.setInt(4, codigo_empleado);
            cs.setFloat(5, valor_adquisicion);
            cs.setString(6,observaciones);
            cs.setInt(7, codigo_departamento);
            cs.setInt(8, ubicacion);
            cs.registerOutParameter(9, Types.VARCHAR);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un String
            mensaje = cs.getString(9);
        } catch(Exception ex){
            mensaje = ex.getMessage();
        }
        
        return mensaje;
    }
    
}
