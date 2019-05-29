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
public class infoEmpleado {

    String nombres;
    String apellidos;
    String direccion;
    String fecha_alta;
    String fcha_baja;

    public infoEmpleado(String nombres, String apellidos, String direccion, String fecha_alta, String fcha_baja) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fecha_alta = fecha_alta;
        this.fcha_baja = fcha_baja;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(String fecha_alta) {
        this.fecha_alta = fecha_alta;
    }

    public String getFcha_baja() {
        return fcha_baja;
    }

    public void setFcha_baja(String fcha_baja) {
        this.fcha_baja = fcha_baja;
    }

}
