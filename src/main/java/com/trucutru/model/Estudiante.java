package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private Double promedioGlobal;
	private List<Materia> materiasCursando;
	public List<String> recomendaciones;
	
	public Estudiante(){
		id = count.incrementAndGet();
	}
	
//	public Estudiante(String nombre){
//		id = count.incrementAndGet();
//		this.nombre = nombre;
//	}
	
	public Estudiante(String nombre, Double promedioGlobal, List<Materia> materiasCursando,
			List<String> recomendaciones) {
		this.nombre = nombre;
		this.promedioGlobal = promedioGlobal;
		this.materiasCursando = materiasCursando;
		this.recomendaciones = recomendaciones;
		id = count.incrementAndGet();
	}
	
	public int getId() {
		return id;
	}

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

	public List<String> getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(List<String> recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
}
