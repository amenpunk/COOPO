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
public class Departamento {
    private int codigo_departamento;
    private String nombre_departamento;
    private String telefono_departamento;
    private int codigo_compania;

    public Departamento() {
    }

    public Departamento(int codigo_departamento, String nombre_departamento, String telefono_departamento, int codigo_compania) {
        this.codigo_departamento = codigo_departamento;
        this.nombre_departamento = nombre_departamento;
        this.telefono_departamento = telefono_departamento;
        this.codigo_compania = codigo_compania;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }

    public void setCodigo_departamento(int codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }

    public String getNombre_departamento() {
        return nombre_departamento;
    }

    public void setNombre_departamento(String nombre_departamento) {
        this.nombre_departamento = nombre_departamento;
    }

    public String getTelefono_departamento() {
        return telefono_departamento;
    }

    public void setTelefono_departamento(String telefono_departamento) {
        this.telefono_departamento = telefono_departamento;
    }

    public int getCodigo_compania() {
        return codigo_compania;
    }

    public void setCodigo_compania(int codigo_compania) {
        this.codigo_compania = codigo_compania;
    }
}
