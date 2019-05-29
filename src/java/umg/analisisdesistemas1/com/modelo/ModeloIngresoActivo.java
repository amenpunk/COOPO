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
import javax.sql.DataSource;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloIngresoActivo {
    private DataSource ds;
    private String mensaje = "";
    
    public ModeloIngresoActivo(DataSource ds) {
        this.ds = ds;
    }
    
    public String obtenerMensajeIngresoActivo(String cod_clasificacion, String nombre_activo, String descripcion,
            String cuenta_activo, String cuenta_gasto, String cuenta_depre_acumulada, int cod_empleado,
            String fec_adquisicion, float valor_adquisicion, String fec_inicio_depre, float porc_depre,
            float valor_inicial_libros, float depre_mensual, float depre_anual, String factura, float monto_factura,
            String observaciones, String estado, int cod_departamento, int cod_ubicacion, int cod_proveedor){
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_inserta_datos_activo(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, cod_clasificacion);
            cs.setString(2, nombre_activo);
            cs.setString(3, descripcion);
            cs.setString(4, cuenta_activo);
            cs.setString(5, cuenta_gasto);
            cs.setString(6, cuenta_depre_acumulada);
            cs.setInt(7, cod_empleado);
            cs.setString(8, fec_adquisicion);
            cs.setFloat(9, valor_adquisicion);
            cs.setString(10, fec_inicio_depre);
            cs.setFloat(11, porc_depre);
            cs.setFloat(12, valor_inicial_libros);
            cs.setFloat(13, depre_mensual);
            cs.setFloat(14, depre_anual);
            cs.setString(15, factura);
            cs.setFloat(16, monto_factura);
            cs.setString(17, observaciones);
            cs.setString(18, estado);
            cs.setInt(19, cod_departamento);
            cs.setInt(20, cod_ubicacion);
            cs.setInt(21, cod_proveedor);
            cs.registerOutParameter(22, Types.VARCHAR);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un String
            mensaje = cs.getString(22);
        } catch(Exception e){
            
        }
        
        return mensaje;
    }
}
