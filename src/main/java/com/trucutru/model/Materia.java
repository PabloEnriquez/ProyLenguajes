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
	private Tema tema;
	
//	public Materia(String nombre, int nivelCurso) {
//		super();
//		this.nombre = nombre;
//		this.nivelCurso = nivelCurso;
//	}

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

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	//	public Nivel getNivelCurso() {
//		return nivelCurso;
//	}
//
//	public void setNivelCurso(Nivel nivelCurso) {
//		this.nivelCurso = nivelCurso;
//	}
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
				+ ", porcentajeCompl=" + porcentajeCompl + ", nivelCurso=" + nivelCurso + ", tema=" + tema + "]";
	}
}
