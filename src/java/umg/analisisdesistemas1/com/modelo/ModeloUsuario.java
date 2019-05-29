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
public class ModeloUsuario {
    private DataSource ds;
    
    public ModeloUsuario(DataSource ds) {
        this.ds = ds;
    }
    
    public String mensajeLogueo(String usuario, String password) throws Exception {
        Connection conexion = null;
        Statement st = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        String mensaje = "";
        
        try{
            //1 Primero, establezco la conexion
            conexion = ds.getConnection();
            //2 Crear la consulta o la sentencia SQL o el procedimiento almacenado
            String sql = "{call sp_logueo_usuario(?, ?, ?)}";
            cs = conexion.prepareCall(sql);
            //3 setear los parametros de entrada o los parametros que pide la funcion
            cs.setString(1, usuario);
            cs.setString(2, password);
            //4 registro el parametro de salida
            cs.registerOutParameter(3, Types.VARCHAR);
            //5 ejecutar la consulta
            cs.execute();
            //6 obtener el valor que devuelve la funcion y asignarse a una variable
            mensaje = cs.getString(3);
        } catch(Exception e){
            System.out.println("Mensaje de error: " + e.getMessage());
        }
        
        return mensaje;
    }
}
