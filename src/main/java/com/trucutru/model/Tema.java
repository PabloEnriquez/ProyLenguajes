package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tema {
	
	private String nombre;
	private int nivel;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	@Override
	public String toString() {
		return "Tema [nombre=" + nombre + ", nivel=" + nivel + "]";
	}
	
}
