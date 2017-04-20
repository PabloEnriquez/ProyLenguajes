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
public class Ancestro {
    
    private String ancestro;
    private String descendiente;

    public Ancestro() {
    }
    
    public Ancestro(String persona1, String persona2) {
    	this.ancestro = persona1;
    	this.descendiente = persona2;
    }

	public String getAncestro() {
		return ancestro;
	}

	public void setAncestro(String ancestro) {
		this.ancestro = ancestro;
	}

	public String getDescendiente() {
		return descendiente;
	}

	public void setDescendiente(String descendiente) {
		this.descendiente = descendiente;
	} 
	
	 @Override
	    public String toString() {
	        return "Ancestro{" + "ancestro=" + ancestro + ", descendiente=" + descendiente + "}";
	    }
}
