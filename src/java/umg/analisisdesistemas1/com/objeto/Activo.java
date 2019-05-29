/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umg.analisisdesistemas1.com.objeto;

/**
 *
 * @author Richard
 */
public class Activo {
    
    private int codigo_activo;
    private String activo_codigo;
    private String nombre_activo;
    private String descripcion;
    private String cuenta_activo;
    private String cuenta_gasto;
    private String cuenta_depre_acumulada;
    private int codigo_empleado;
    private String fecha_adquisicion;
    private float valor_adquisicion;
    private String fecha_ini_depreciacion;
    private float porc_depreciacion;
    private float valor_ini_libros;
    private float depreciacion_mensual;
    private float depreciacion_anual;
    private String factura;
    private float monto_factura;
    private String observaciones;
    private char estado;
    private String imagen_factura;
    private int codigo_departamento;
    private int ubicacion;

    public Activo(int codigo_activo, String descripcion, int codigo_empleado, float valor_adquisicion, String observaciones, int codigo_departamento, int ubicacion) {
        this.codigo_activo = codigo_activo;
        this.descripcion = descripcion;
        this.codigo_empleado = codigo_empleado;
        this.valor_adquisicion = valor_adquisicion;
        this.observaciones = observaciones;
        this.codigo_departamento = codigo_departamento;
        this.ubicacion = ubicacion;
    }
    
    
    
    public Activo(int codigo_activo, String nombre_activo){
        this.codigo_activo = codigo_activo;
        this.nombre_activo = nombre_activo;
    }

    public Activo(int codigo_activo, String activo_codigo, String nombre_activo, String descripcion, String cuenta_activo, String cuenta_gasto, String cuenta_depre_acumulada, int codigo_empleado, String fecha_adquisicion, float valor_adquisicion, String fecha_ini_depreciacion, float porc_depreciacion, float valor_ini_libros, float depreciacion_mensual, float depreciacion_anual, String factura, float monto_factura, String observaciones, char estado, String imagen_factura, int codigo_departamento, int ubicacion) {
        this.codigo_activo = codigo_activo;
        this.activo_codigo = activo_codigo;
        this.nombre_activo = nombre_activo;
        this.descripcion = descripcion;
        this.cuenta_activo = cuenta_activo;
        this.cuenta_gasto = cuenta_gasto;
        this.cuenta_depre_acumulada = cuenta_depre_acumulada;
        this.codigo_empleado = codigo_empleado;
        this.fecha_adquisicion = fecha_adquisicion;
        this.valor_adquisicion = valor_adquisicion;
        this.fecha_ini_depreciacion = fecha_ini_depreciacion;
        this.porc_depreciacion = porc_depreciacion;
        this.valor_ini_libros = valor_ini_libros;
        this.depreciacion_mensual = depreciacion_mensual;
        this.depreciacion_anual = depreciacion_anual;
        this.factura = factura;
        this.monto_factura = monto_factura;
        this.observaciones = observaciones;
        this.estado = estado;
        this.imagen_factura = imagen_factura;
        this.codigo_departamento = codigo_departamento;
        this.ubicacion = ubicacion;
    }

    public Activo(int codigo_activo, String activo_codigo, String nombre_activo, String descripcion, String cuenta_activo, String cuenta_gasto, String cuenta_depre_acumulada, int codigo_empleado, String fecha_adquisicion, float valor_adquisicion, String fecha_ini_depreciacion, float porc_depreciacion, float valor_ini_libros, float depreciacion_mensual, float depreciacion_anual, String factura, float monto_factura, String observaciones, String imagen_factura, int codigo_departamento, int ubicacion) {
        this.codigo_activo = codigo_activo;
        this.activo_codigo = activo_codigo;
        this.nombre_activo = nombre_activo;
        this.descripcion = descripcion;
        this.cuenta_activo = cuenta_activo;
        this.cuenta_gasto = cuenta_gasto;
        this.cuenta_depre_acumulada = cuenta_depre_acumulada;
        this.codigo_empleado = codigo_empleado;
        this.fecha_adquisicion = fecha_adquisicion;
        this.valor_adquisicion = valor_adquisicion;
        this.fecha_ini_depreciacion = fecha_ini_depreciacion;
        this.porc_depreciacion = porc_depreciacion;
        this.valor_ini_libros = valor_ini_libros;
        this.depreciacion_mensual = depreciacion_mensual;
        this.depreciacion_anual = depreciacion_anual;
        this.factura = factura;
        this.monto_factura = monto_factura;
        this.observaciones = observaciones;
        this.imagen_factura = imagen_factura;
        this.codigo_departamento = codigo_departamento;
        this.ubicacion = ubicacion;
        
    }

     
  
    

    /**
     * @return the codigo_activo
     */
    
    
    
    public int getCodigo_activo() {
        return codigo_activo;
    }

    /**
     * @param codigo_activo the codigo_activo to set
     */
    public void setCodigo_activo(int codigo_activo) {
        this.codigo_activo = codigo_activo;
    }

    /**
     * @return the codigo_clasificacion
     */
    public String getActivo_codigo() {
        return activo_codigo;
    }

    /**
     * @param codigo_clasificacion the codigo_clasificacion to set
     */
    public void setActivo_codigo(String activo_codigo) {
        this.activo_codigo= activo_codigo;
    }

    /**
     * @return the nombre_activo
     */
    public String getNombre_activo() {
        return nombre_activo;
    }

    /**
     * @param nombre_activo the nombre_activo to set
     */
    public void setNombre_activo(String nombre_activo) {
        this.nombre_activo = nombre_activo;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the cuenta_activo
     */
    public String getCuenta_activo() {
        return cuenta_activo;
    }

    /**
     * @param cuenta_activo the cuenta_activo to set
     */
    public void setCuenta_activo(String cuenta_activo) {
        this.cuenta_activo = cuenta_activo;
    }

    /**
     * @return the cuenta_gasto
     */
    public String getCuenta_gasto() {
        return cuenta_gasto;
    }

    /**
     * @param cuenta_gasto the cuenta_gasto to set
     */
    public void setCuenta_gasto(String cuenta_gasto) {
        this.cuenta_gasto = cuenta_gasto;
    }

    /**
     * @return the cuenta_depre_acumulada
     */
    public String getCuenta_depre_acumulada() {
        return cuenta_depre_acumulada;
    }

    /**
     * @param cuenta_depre_acumulada the cuenta_depre_acumulada to set
     */
    public void setCuenta_depre_acumulada(String cuenta_depre_acumulada) {
        this.cuenta_depre_acumulada = cuenta_depre_acumulada;
    }

    /**
     * @return the codigo_empleado
     */
    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    /**
     * @param codigo_empleado the codigo_empleado to set
     */
    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    /**
     * @return the fecha_adquisicion
     */
    public String getFecha_adquisicion() {
        return fecha_adquisicion;
    }

    /**
     * @param fecha_adquisicion the fecha_adquisicion to set
     */
    public void setFecha_adquisicion(String fecha_adquisicion) {
        this.fecha_adquisicion = fecha_adquisicion;
    }

    /**
     * @return the valor_adquisicion
     */
    public float getValor_adquisicion() {
        return valor_adquisicion;
    }

    /**
     * @param valor_adquisicion the valor_adquisicion to set
     */
    public void setValor_adquisicion(float valor_adquisicion) {
        this.valor_adquisicion = valor_adquisicion;
    }

    /**
     * @return the fecha_ini_depreciacion
     */
    public String getFecha_ini_depreciacion() {
        return fecha_ini_depreciacion;
    }

    /**
     * @param fecha_ini_depreciacion the fecha_ini_depreciacion to set
     */
    public void setFecha_ini_depreciacion(String fecha_ini_depreciacion) {
        this.fecha_ini_depreciacion = fecha_ini_depreciacion;
    }

    /**
     * @return the porc_depreciacion
     */
    public float getPorc_depreciacion() {
        return porc_depreciacion;
    }

    /**
     * @param porc_depreciacion the porc_depreciacion to set
     */
    public void setPorc_depreciacion(float porc_depreciacion) {
        this.porc_depreciacion = porc_depreciacion;
    }

    /**
     * @return the valor_ini_libros
     */
    public float getValor_ini_libros() {
        return valor_ini_libros;
    }

    /**
     * @param valor_ini_libros the valor_ini_libros to set
     */
    public void setValor_ini_libros(float valor_ini_libros) {
        this.valor_ini_libros = valor_ini_libros;
    }

    /**
     * @return the depreciacion_mensual
     */
    public float getDepreciacion_mensual() {
        return depreciacion_mensual;
    }

    /**
     * @param depreciacion_mensual the depreciacion_mensual to set
     */
    public void setDepreciacion_mensual(float depreciacion_mensual) {
        this.depreciacion_mensual = depreciacion_mensual;
    }

    /**
     * @return the depreciacion_anual
     */
    public float getDepreciacion_anual() {
        return depreciacion_anual;
    }

    /**
     * @param depreciacion_anual the depreciacion_anual to set
     */
    public void setDepreciacion_anual(float depreciacion_anual) {
        this.depreciacion_anual = depreciacion_anual;
    }

    /**
     * @return the factura
     */
    public String getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(String factura) {
        this.factura = factura;
    }

    /**
     * @return the monto_factura
     */
    public float getMonto_factura() {
        return monto_factura;
    }

    /**
     * @param monto_factura the monto_factura to set
     */
    public void setMonto_factura(float monto_factura) {
        this.monto_factura = monto_factura;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param observaciones the observaciones to set
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * @return the estado
     */
    public char getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(char estado) {
        this.estado = estado;
    }

    /**
     * @return the imagen_factura
     */
    public String getImagen_factura() {
        return imagen_factura;
    }

    /**
     * @param imagen_factura the imagen_factura to set
     */
    public void setImagen_factura(String imagen_factura) {
        this.imagen_factura = imagen_factura;
    }

    /**
     * @return the codigo_departamento
     */
    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    /**
     * @param codigo_departamento the codigo_departamento to set
     */
    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    /**
     * @return the ubicacion
     */
    public int getUbicacion() {
        return ubicacion;
    }

    /**
     * @param ubicacion the ubicacion to set
     */
    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
    
}