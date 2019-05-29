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
public class Menu {
    private int codigo_menu;
    private String nombre_menu;

    public Menu() {
    }
    
    public Menu(int codigo_menu, String nombre_menu) {
        this.codigo_menu = codigo_menu;
        this.nombre_menu = nombre_menu;
    }

    /**
     * @return the codigo_menu
     */
    public int getCodigo_menu() {
        return codigo_menu;
    }

    /**
     * @param codigo_menu the codigo_menu to set
     */
    public void setCodigo_menu(int codigo_menu) {
        this.codigo_menu = codigo_menu;
    }

    /**
     * @return the nombre_menu
     */
    public String getNombre_menu() {
        return nombre_menu;
    }

    /**
     * @param nombre_menu the nombre_menu to set
     */
    public void setNombre_menu(String nombre_menu) {
        this.nombre_menu = nombre_menu;
    }
}
