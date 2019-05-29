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
public class DatosEmpleado {
    private String nombre_empleado = "";
    private String departamento = "";
    private String puesto = "";
    private String centro_costo = "";
    private String mensaje = "";

    public DatosEmpleado() {
        
    }

    public DatosEmpleado(String nombre_empleado, String departamento, String puesto, String centro_costo, String mensaje) {
        this.nombre_empleado = nombre_empleado;
        this.departamento = departamento;
        this.puesto = puesto;
        this.centro_costo = centro_costo;
        this.mensaje = mensaje;
    }
    
    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getCentro_costo() {
        return centro_costo;
    }

    public void setCentro_costo(String centro_costo) {
        this.centro_costo = centro_costo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
