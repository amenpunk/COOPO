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
public class Empleado {
    private int codigo_empleado;
    private String nombre_empleado;
    private String apellido_empleado;

    public Empleado() {
    }

    public Empleado(int codigo_empleado, String nombre_empleado) {
        this.codigo_empleado = codigo_empleado;
        this.nombre_empleado = nombre_empleado;
    }
    
    public Empleado(int codigo_empleado, String nombre_empleado, String apellido_empleado) {
        this.codigo_empleado = codigo_empleado;
        this.nombre_empleado = nombre_empleado;
        this.apellido_empleado = apellido_empleado;
    }

    public int getCodigo_empleado() {
        return codigo_empleado;
    }

    public void setCodigo_empleado(int codigo_empleado) {
        this.codigo_empleado = codigo_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }
}
