package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {
	
	private String nombre;
	private Double promedioGlobal;
	private List<Materia> materiasCursando;
	private Materia materiaAInscribir;
	
	public Double getPromedioTotal(List<Materia> materias){
		for(int i = 0; i < materias.size(); i++){
			Materia m = materias.get(i);
			m.setPromedioAlumno(0.0);
			List<Tema> temas = m.getTemas();
			double aux = m.getPromedioMateria(temas);
			m.setPromedioAlumno(aux);
			promedioGlobal += aux;
		}
		promedioGlobal = (promedioGlobal / materias.size());
		return promedioGlobal;
	}
	
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

	public List<Materia> getMateriasCursando() {
		return materiasCursando;
	}

	public void setMateriasCursando(List<Materia> materiasCursando) {
		this.materiasCursando = materiasCursando;
	}

	@Override
	public String toString() {
		return "Estudiante [nombre=" + nombre + ", promedioGlobal=" + promedioGlobal + ", materiasCursando="
				+ materiasCursando + "]";
	}

	public Materia getMateriaAInscribir() {
		return materiaAInscribir;
	}

	public void setMateriaAInscribir(Materia materiaAInscribir) {
		this.materiaAInscribir = materiaAInscribir;
	}

}
