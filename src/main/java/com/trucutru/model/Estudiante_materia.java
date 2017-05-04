package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante_materia {
	private int id_materia;
	private int id_estudiante;
	private double promedioAlumno;
	private double porcentajeCompletado;
	
	public Estudiante_materia() {
	}
	public Estudiante_materia(int id_materia, int id_estudiante, double promedioAlumno, double porcentajeCompletado) {
		this.id_materia = id_materia;
		this.id_estudiante = id_estudiante;
		this.promedioAlumno = promedioAlumno;
		this.porcentajeCompletado = porcentajeCompletado;
	}
	public int getId_materia() {
		return id_materia;
	}
	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
	}
	public int getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	public double getPromedioAlumno() {
		return promedioAlumno;
	}
	public void setPromedioAlumno(double promedioAlumno) {
		this.promedioAlumno = promedioAlumno;
	}
	public double getPorcentajeCompletado() {
		return porcentajeCompletado;
	}
	public void setPorcentajeCompletado(double porcentajeCompletado) {
		this.porcentajeCompletado = porcentajeCompletado;
	}
	@Override
	public String toString() {
		return "Estudiante_materia [id_materia=" + id_materia + ", id_estudiante=" + id_estudiante + ", promedioAlumno="
				+ promedioAlumno + ", porcentajeCompletado=" + porcentajeCompletado + "]";
	}
	
}
