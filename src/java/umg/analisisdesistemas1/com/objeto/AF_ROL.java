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
public class AF_ROL {

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    private String nombre;

    public AF_ROL(String nombre) {
        this.nombre = nombre;
    }
}
