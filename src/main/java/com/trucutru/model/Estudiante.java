package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {
	
	private String nombre;
	private Double promedioGlobal;
	private Materia materiaCursando;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPromedioGlobal() {
		return promedioGlobal;
	}

	public void setPromedioGlobal(Double promedioGlobal) {
		this.promedioGlobal = promedioGlobal;
	}

	public Materia getMateriaCursando() {
		return materiaCursando;
	}

	public void setMateriaCursando(Materia materiaCursando) {
		this.materiaCursando = materiaCursando;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", promedioGlobal=" + promedioGlobal + ", materiaCursando="
				+ materiaCursando + "]";
	}
}
