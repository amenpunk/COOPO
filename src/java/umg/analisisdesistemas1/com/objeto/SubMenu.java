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
public class SubMenu {
    private String nombre_submenu;
    private String nombre_recurso;
    private String imagen;

    public SubMenu() {
    }

    public SubMenu(String nombre_submenu, String nombre_recurso, String imagen) {
        this.nombre_submenu = nombre_submenu;
        this.nombre_recurso = nombre_recurso;
        this.imagen = imagen;
    }

    /**
     * @return the nombre_submenu
     */
    public String getNombre_submenu() {
        return nombre_submenu;
    }

    /**
     * @param nombre_submenu the nombre_submenu to set
     */
    public void setNombre_submenu(String nombre_submenu) {
        this.nombre_submenu = nombre_submenu;
    }

    /**
     * @return the nombre_recurso
     */
    public String getNombre_recurso() {
        return nombre_recurso;
    }

    /**
     * @param nombre_recurso the nombre_recurso to set
     */
    public void setNombre_recurso(String nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
