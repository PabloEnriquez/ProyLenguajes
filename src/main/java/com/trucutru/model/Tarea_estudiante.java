package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tarea_estudiante {
	private int id_tarea;
	private int id_tema;
	private int id_estudiante;
	private double calificacion;
	private boolean completed;
	
	public Tarea_estudiante() {
	}
	public Tarea_estudiante(int id_tarea, int id_tema, int id_estudiante, double calificacion, boolean completed) {
		super();
		this.id_tarea = id_tarea;
		this.id_tema = id_tema;
		this.id_estudiante = id_estudiante;
		this.calificacion = calificacion;
		this.completed = completed;
	}
	public int getId_tarea() {
		return id_tarea;
	}
	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}
	public int getId_tema() {
		return id_tema;
	}
	public void setId_tema(int id_tema) {
		this.id_tema = id_tema;
	}
	public int getId_estudiante() {
		return id_estudiante;
	}
	public void setId_estudiante(int id_estudiante) {
		this.id_estudiante = id_estudiante;
	}
	@Override
	public String toString() {
		return "Tarea_estudiante [id_tarea=" + id_tarea + ", id_tema=" + id_tema + ", id_estudiante=" + id_estudiante
				+ ", calificacion=" + calificacion + ", completed=" + completed + "]";
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
	
}
