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
import umg.analisisdesistemas1.com.objeto.CalculoDepreciacion;

/**
 *
 * @author DELLMAYORGA
 */
public class ModeloCalculoContable {
    private DataSource ds;
    private CalculoDepreciacion calculoDepreciacion;
    private ArrayList<CalculoDepreciacion> listaCalculoDepreciacion = null;
    
    public ModeloCalculoContable(DataSource ds) {
        this.ds = ds;
    }
    
    public ArrayList<CalculoDepreciacion> obtenerCalculoDepreciacion(String referencia_activo, float valor_adquisicion) throws Exception{
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        listaCalculoDepreciacion = new ArrayList<CalculoDepreciacion>();
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_calculos_depreciacion_activos(?, ?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, referencia_activo);
            cs.setFloat(2, valor_adquisicion);
            //4 ejecutar la consulta
            cs.execute();
            //5 Guardo el valor devuelto por la DB en un ResultSet
            rs = cs.getResultSet();
            while(rs.next()){
                float porc_depreciacion = rs.getFloat("porcentaje_depreciacion");
                float valor_libros_inicial = rs.getFloat("valor_libros_inicial");
                float valor_depre_anual = rs.getFloat("valor_depre_anual");
                float valor_depre_mensual = rs.getFloat("valor_depre_mensual");
                calculoDepreciacion = new CalculoDepreciacion(porc_depreciacion, valor_libros_inicial, valor_depre_anual, valor_depre_mensual);
                listaCalculoDepreciacion.add(calculoDepreciacion);
            }
        } catch(Exception e){
            
        }
        
        return listaCalculoDepreciacion;
    }
}
