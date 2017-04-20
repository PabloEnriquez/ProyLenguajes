package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Maestro {
	
	private String nombre;
	private Estudiante estudiante;
	private Materia materiaImpartida;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Materia getMateriaImpartida() {
		return materiaImpartida;
	}
	public void setMateriaImpartida(Materia materiaImpartida) {
		this.materiaImpartida = materiaImpartida;
	}
	
	@Override
	public String toString() {
		return "Maestro [nombre=" + nombre + ", estudiante=" + estudiante + ", materiaImpartida=" + materiaImpartida
				+ "]";
	}
}
