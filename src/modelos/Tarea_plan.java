/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Master Kaizen - MK
 */
public class Tarea_plan {
    
    private Integer a1;
    private String a2;
    private String a3;

    
    public Tarea_plan() {
        this.a1 = null;
        this.a2 = null;
        this.a3 = null;
    }

    public Tarea_plan(Integer a1, String a2, String a3) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
    }

    public Integer getA1() {
        return a1;
    }

    public String getA2() {
        return a2;
    }

    public String getA3() {
        return a3;
    }


    public void setA1(Integer a1) {
        this.a1 = a1;
    }
    
    public void setA2(String a2) {
        this.a2 = a2;
    }

    public void setA3(String a3) {
        this.a3 = a3;
    }

    
    @Override
    public String toString() {
        return "Tarea_plan{" + "a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + '}';
    }
    
}
