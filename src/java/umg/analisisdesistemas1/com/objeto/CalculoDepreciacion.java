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
public class CalculoDepreciacion {
    private float porcentaje_depreciacion;
    private float valor_libros_incial;
    private float valor_depreciacion_anual;
    private float valor_depreciacion_mensual;

    public CalculoDepreciacion() {
    }

    public CalculoDepreciacion(float porcentaje_depreciacion, float valor_libros_incial, float valor_depreciacion_anual, float valor_depreciacion_mensual) {
        this.porcentaje_depreciacion = porcentaje_depreciacion;
        this.valor_libros_incial = valor_libros_incial;
        this.valor_depreciacion_anual = valor_depreciacion_anual;
        this.valor_depreciacion_mensual = valor_depreciacion_mensual;
    }

    public float getPorcentaje_depreciacion() {
        return porcentaje_depreciacion;
    }

    public void setPorcentaje_depreciacion(float porcentaje_depreciacion) {
        this.porcentaje_depreciacion = porcentaje_depreciacion;
    }

    public float getValor_libros_incial() {
        return valor_libros_incial;
    }

    public void setValor_libros_incial(float valor_libros_incial) {
        this.valor_libros_incial = valor_libros_incial;
    }

    public float getValor_depreciacion_anual() {
        return valor_depreciacion_anual;
    }

    public void setValor_depreciacion_anual(float valor_depreciacion_anual) {
        this.valor_depreciacion_anual = valor_depreciacion_anual;
    }

    public float getValor_depreciacion_mensual() {
        return valor_depreciacion_mensual;
    }

    public void setValor_depreciacion_mensual(float valor_depreciacion_mensual) {
        this.valor_depreciacion_mensual = valor_depreciacion_mensual;
    }
}
