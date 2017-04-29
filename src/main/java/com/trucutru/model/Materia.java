package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Materia {
	
//	public enum Nivel{
//		ALTO, MEDIO, BAJO
//	};
	
	private String nombre;
	private String maestro;
	private Double promedioAlumno;
	private Double porcentajeCompl;
	private int nivelCurso;
	private List<Tema> temas;
	
	public Materia(){
	}
	
	public Materia(String nombre, int nivelCurso) {
		super();
		this.nombre = nombre;
		this.nivelCurso = nivelCurso;
	}
	
	public Double getPromedioMateria(List<Tema> temas){
		for(int i = 0; i < temas.size(); i++){
			Tema t = temas.get(i);
			t.setPromedioEjer(0.0);
			List<Tarea> tareas = t.getEjercicios();
			double aux = t.getPromedioTareas(tareas);
			t.setPromedioEjer(aux);
			promedioAlumno += aux;
		}
		promedioAlumno = (promedioAlumno / temas.size());
		return promedioAlumno;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Double getPromedioAlumno() {
		return promedioAlumno;
	}
	
	public void setPromedioAlumno(Double promedioAlumno) {
		this.promedioAlumno = promedioAlumno;
	}
	
	public Double getPorcentajeCompl() {
		return porcentajeCompl;
	}

	public void setPorcentajeCompl(Double porcentajeCompl) {
		this.porcentajeCompl = porcentajeCompl;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public int getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(int nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
	
	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	@Override
	public String toString() {
		return "Materia [nombre=" + nombre + ", maestro=" + maestro + ", promedioAlumno=" + promedioAlumno
				+ ", porcentajeCompl=" + porcentajeCompl + ", nivelCurso=" + nivelCurso + ", temas=" + temas + "]";
	}
}
