/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.objeto;

/**
 *
 * @author DELLMAYORGA
 */
public class CuentaContable {
    private int codigo_cuenta;
    private String nombre_cuenta;
    private String referencia_cuenta;
    private float porcentaje_depreciacion;

    public CuentaContable() {
        
    }

    public CuentaContable(int codigo_cuenta, String nombre_cuenta, String referencia_cuenta, float porcentaje_depreciacion) {
        this.codigo_cuenta = codigo_cuenta;
        this.nombre_cuenta = nombre_cuenta;
        this.referencia_cuenta = referencia_cuenta;
        this.porcentaje_depreciacion = porcentaje_depreciacion;
    }

    public int getCodigo_cuenta() {
        return codigo_cuenta;
    }

    public void setCodigo_cuenta(int codigo_cuenta) {
        this.codigo_cuenta = codigo_cuenta;
    }

    public String getNombre_cuenta() {
        return nombre_cuenta;
    }

    public void setNombre_cuenta(String nombre_cuenta) {
        this.nombre_cuenta = nombre_cuenta;
    }

    public String getReferencia_cuenta() {
        return referencia_cuenta;
    }

    public void setReferencia_cuenta(String referencia_cuenta) {
        this.referencia_cuenta = referencia_cuenta;
    }

    public float getPorcentaje_depreciacion() {
        return porcentaje_depreciacion;
    }

    public void setPorcentaje_depreciacion(float porcentaje_depreciacion) {
        this.porcentaje_depreciacion = porcentaje_depreciacion;
    }
}
