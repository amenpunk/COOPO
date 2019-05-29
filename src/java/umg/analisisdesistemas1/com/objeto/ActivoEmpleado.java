/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.objeto;

/**
 *
 * @author Neon
 */
public class ActivoEmpleado {

    private String codigo_clas;
    private String nombre;
    private String descripcion;
    private String cuenta_activo;
    private String fecha_adqui;
    private String valor_inicial;

    public ActivoEmpleado(String codigo_clas, String nombre, String descripcion, String cuenta_activo, String fecha_adqui, String valor_inicial) {
        this.codigo_clas = codigo_clas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cuenta_activo = cuenta_activo;
        this.fecha_adqui = fecha_adqui;
        this.valor_inicial = valor_inicial;
    }

    public String getCodigo_clas() {
        return codigo_clas;
    }

    public void setCodigo_clas(String codigo_clas) {
        this.codigo_clas = codigo_clas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuenta_activo() {
        return cuenta_activo;
    }

    public void setCuenta_activo(String cuenta_activo) {
        this.cuenta_activo = cuenta_activo;
    }

    public String getFecha_adqui() {
        return fecha_adqui;
    }

    public void setFecha_adqui(String fecha_adqui) {
        this.fecha_adqui = fecha_adqui;
    }

    public String getValor_inicial() {
        return valor_inicial;
    }

    public void setValor_inicial(String valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

}
