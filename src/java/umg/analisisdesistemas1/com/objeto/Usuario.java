/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.objeto;

import java.util.Date;

/**
 *
 * @author DELLMAYORGA
 */
public class Usuario {
    private int usu_codigo;
    private String usu_user;
    private String usu_password;
    private Date usu_fecha_alta;
    private Date usu_fecha_baja;
    private int emp_codigo;
    private int rol_codigo;

    public Usuario() {
    }
    
    public Usuario(String usu_user, String usu_password, Date usu_fecha_alta, Date usu_fecha_baja, int emp_codigo, int rol_codigo) {
        this.usu_user = usu_user;
        this.usu_password = usu_password;
        this.usu_fecha_alta = usu_fecha_alta;
        this.usu_fecha_baja = usu_fecha_baja;
        this.emp_codigo = emp_codigo;
        this.rol_codigo = rol_codigo;
    }

    public Usuario(int usu_codigo, String usu_user, String usu_password, Date usu_fecha_alta, Date usu_fecha_baja, int emp_codigo, int rol_codigo) {
        this.usu_codigo = usu_codigo;
        this.usu_user = usu_user;
        this.usu_password = usu_password;
        this.usu_fecha_alta = usu_fecha_alta;
        this.usu_fecha_baja = usu_fecha_baja;
        this.emp_codigo = emp_codigo;
        this.rol_codigo = rol_codigo;
    }
    
    public Usuario(int usu_codigo, String usu_user, String usu_password, int emp_codigo, int rol_codigo) {
        this.usu_codigo = usu_codigo;
        this.usu_user = usu_user;
        this.usu_password = usu_password;
        this.emp_codigo = emp_codigo;
        this.rol_codigo = rol_codigo;
    }

    public Usuario(int usu_codigo, String usu_user) {
        this.usu_codigo = usu_codigo;
        this.usu_user = usu_user;
    }
    
    /**
     * @return the usu_codigo
     */
    public int getUsu_codigo() {
        return usu_codigo;
    }

    /**
     * @param usu_codigo the usu_codigo to set
     */
    public void setUsu_codigo(int usu_codigo) {
        this.usu_codigo = usu_codigo;
    }

    /**
     * @return the usu_user
     */
    public String getUsu_user() {
        return usu_user;
    }

    /**
     * @param usu_user the usu_user to set
     */
    public void setUsu_user(String usu_user) {
        this.usu_user = usu_user;
    }

    /**
     * @return the usu_password
     */
    public String getUsu_password() {
        return usu_password;
    }

    /**
     * @param usu_password the usu_password to set
     */
    public void setUsu_password(String usu_password) {
        this.usu_password = usu_password;
    }

    /**
     * @return the usu_fecha_alta
     */
    public Date getUsu_fecha_alta() {
        return usu_fecha_alta;
    }

    /**
     * @param usu_fecha_alta the usu_fecha_alta to set
     */
    public void setUsu_fecha_alta(Date usu_fecha_alta) {
        this.usu_fecha_alta = usu_fecha_alta;
    }

    /**
     * @return the usu_fecha_baja
     */
    public Date getUsu_fecha_baja() {
        return usu_fecha_baja;
    }

    /**
     * @param usu_fecha_baja the usu_fecha_baja to set
     */
    public void setUsu_fecha_baja(Date usu_fecha_baja) {
        this.usu_fecha_baja = usu_fecha_baja;
    }

    /**
     * @return the emp_codigo
     */
    public int getEmp_codigo() {
        return emp_codigo;
    }

    /**
     * @param emp_codigo the emp_codigo to set
     */
    public void setEmp_codigo(int emp_codigo) {
        this.emp_codigo = emp_codigo;
    }

    /**
     * @return the rol_codigo
     */
    public int getRol_codigo() {
        return rol_codigo;
    }

    /**
     * @param rol_codigo the rol_codigo to set
     */
    public void setRol_codigo(int rol_codigo) {
        this.rol_codigo = rol_codigo;
    }
}
