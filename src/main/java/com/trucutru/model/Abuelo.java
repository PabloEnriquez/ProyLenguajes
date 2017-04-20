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
public class Abuelo {
    
    private String padre;
    private String nieto;

    public Abuelo() {
    }
    
    public Abuelo(String persona1, String persona2) {
    	this.padre = persona1;
    	this.nieto = persona2;
        }

    public String getPadre() {
        return padre;
    }

    public void setPadre(String name) {
        this.padre = name;
    }

    public String getNieto() {
        return nieto;
    }

    public void setNieto(String name) {
        this.nieto = name;
    }
   
    @Override
    public String toString() {
        return "Abuelo{" + "abuelo=" + padre + ", nieto=" + nieto + "}";
    }

   
    
    
}
