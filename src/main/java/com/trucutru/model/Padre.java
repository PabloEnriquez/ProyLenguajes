/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author salaboy
 */
@XmlRootElement
public class Padre {
    
    private String padre;
    private String hijo;

    public Padre() {
    }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String name) {
        this.padre = name;
    }

    public String getHijo() {
        return hijo;
    }

    public void setHijo(String name) {
        this.hijo = name;
    }
   
    @Override
    public String toString() {
        return "Padre{" + "padre=" + padre + ", hijo=" + hijo + "}";
    }

   
    
    
}
