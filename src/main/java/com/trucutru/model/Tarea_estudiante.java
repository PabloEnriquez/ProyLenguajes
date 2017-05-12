package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tarea_estudiante {
	private int idTarea;
	private int idTema;
	private int idEstudiante;
	private double calificacion;
	private boolean completed;
	
	public Tarea_estudiante() {
	}
	
	public Tarea_estudiante(int idTarea, int idTema, int idEstudiante, double calificacion, boolean completed) {
		super();
		this.idTarea = idTarea;
		this.idTema = idTema;
		this.idEstudiante = idEstudiante;
		this.calificacion = calificacion;
		this.completed = completed;
	}
	
	public int getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
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

	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Tarea_estudiante [idTarea=" + idTarea + ", idTema=" + idTema + ", idEstudiante=" + idEstudiante
				+ ", calificacion=" + calificacion + ", completed=" + completed + "]";
	}
}
