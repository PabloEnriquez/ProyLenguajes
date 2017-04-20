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
public class Hermano {
    
    private String persona1;
    private String persona2;

    public Hermano() {
    }

    public String getPersona1() {
        return persona1;
    }

    public void setPersona1(String name) {
        this.persona1 = name;
    }

    public String getPersona2() {
        return persona2;
    }

    public void setPersona2(String name) {
        this.persona2 = name;
    }
   
    @Override
    public String toString() {
        return "Hermano{" + "persona1=" + persona1 + "es hermano de persona2=" + persona2 + "}";
    }

    public Hermano(String persona1, String persona2) {
	this.persona1 = persona1;
	this.persona2 = persona2;
    }
    
}
