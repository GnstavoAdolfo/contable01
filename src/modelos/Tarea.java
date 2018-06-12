/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 * 
 * @author Fernando
 */
public class Tarea {
    
    private final Integer uno;
    private String dos;
    private String tres;
    private Integer cuatro;
    private String cinco;
    
    public Tarea() {
        this.uno = null;
        this.dos = null;
        this.tres = null;
        this.cuatro = null;
        this.cinco = null;
    }

    public Tarea(Integer uno, String dos, String tres, Integer cuatro, String cinco) {
        this.uno = uno;
        this.dos = dos;
        this.tres = tres;
        this.cuatro = cuatro;
        this.cinco = cinco;
    }

    public Integer getUno() {
        return uno;
    }

    public String getDos() {
        return dos;
    }

    public String getTres() {
        return tres;
    }

    public Integer getCuatro() {
        return cuatro;
    }
    
    public String getCinco() {
        return cinco;
    }

    public void setDos(String dos) {
        this.dos = dos;
    }

    public void setTres(String tres) {
        this.tres = tres;
    }

    public void setCuatro(Integer cuatro) {
        this.cuatro = cuatro;
    }

    public void setCinco(String cinco) {
        this.cinco = cinco;
    }
    
    @Override
    public String toString() {
        return "Tarea{" + "uno" + uno + ", dos=" + dos + ", tres=" + tres + ", cuatro=" + cuatro + ",cinco=" + cinco + '}';
    }
    
}