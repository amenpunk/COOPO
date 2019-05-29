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
public class Proveedor {
    private int codigo_proveedor;
    private String nombre_proveedor;

    public Proveedor() {
    }

    public Proveedor(int codigo_proveedor, String nombre_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
        this.nombre_proveedor = nombre_proveedor;
    }

    /**
     * @return the codigo_proveedor
     */
    public int getCodigo_proveedor() {
        return codigo_proveedor;
    }

    /**
     * @param codigo_proveedor the codigo_proveedor to set
     */
    public void setCodigo_proveedor(int codigo_proveedor) {
        this.codigo_proveedor = codigo_proveedor;
    }

    /**
     * @return the nombre_proveedor
     */
    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    /**
     * @param nombre_proveedor the nombre_proveedor to set
     */
    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }
}
