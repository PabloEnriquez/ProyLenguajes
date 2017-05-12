package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante_materia {
	private int idMateria;
	private int idEstudiante;
	private double promedioAlumno;
	private double porcentajeCompletado;
	
	public Estudiante_materia() {
	}
	
	public Estudiante_materia(int idMateria, int idEstudiante, double promedioAlumno, double porcentajeCompletado) {
		super();
		this.idMateria = idMateria;
		this.idEstudiante = idEstudiante;
		this.promedioAlumno = promedioAlumno;
		this.porcentajeCompletado = porcentajeCompletado;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public int getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(int idEstudiante) {
		this.idEstudiante = idEstudiante;
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
		return "Estudiante_materia [idMateria=" + idMateria + ", idEstudiante=" + idEstudiante + ", promedioAlumno="
				+ promedioAlumno + ", porcentajeCompletado=" + porcentajeCompletado + "]";
	}
}
