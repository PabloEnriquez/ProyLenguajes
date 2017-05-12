package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tema_estudiante {
	private int idTema;
	private int idEstudiante;
	private double promedioEjercicios;
	
	public Tema_estudiante() {
	}
	
	public Tema_estudiante(int idTema, int idEstudiante, double promedioEjercicios) {
		super();
		this.idTema = idTema;
		this.idEstudiante = idEstudiante;
		this.promedioEjercicios = promedioEjercicios;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public double getPromedioEjercicios() {
		return promedioEjercicios;
	}
	public void setPromedioEjercicios(double promedioEjercicios) {
		this.promedioEjercicios = promedioEjercicios;
	}

	@Override
	public String toString() {
		return "Tema_estudiante [idTema=" + idTema + ", idEstudiante=" + idEstudiante + ", promedioEjercicios="
				+ promedioEjercicios + "]";
	}
	
}
