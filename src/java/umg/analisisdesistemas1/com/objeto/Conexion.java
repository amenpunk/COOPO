/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.objeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Neon
 */
public class Conexion {

    Connection cnx = null;

    public Conexion() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnx = DriverManager.getConnection("jdbc:sqlserver://testcoopo.database.windows.net:1433;database=ACTIVOS_FIJOS;user=emayorga@testcoopo;password=Test2019;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
            System.out.println("WORK");
            //cnx = DriverManager.getConnection("jdbc:mysql://localhost:7702/blog?user=root&password=naruto10");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: " + e);
        } catch (SQLException e) {
            System.err.println("Error: " + e);
        }
    }

    public java.sql.Connection getConexion() {
        return cnx;
    }

    public static void main(String[] args) {
        Conexion conn = new Conexion();
    }
}
