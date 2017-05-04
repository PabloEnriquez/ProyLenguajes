package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Tema_estudiante {
	private int id_tema;
	private int id_estudiante;
	private double promedio_ejercicios;
	
	public Tema_estudiante() {
	}
	public Tema_estudiante(int id_tema, int id_estudiante, double promedio_ejercicios) {
		this.id_tema = id_tema;
		this.id_estudiante = id_estudiante;
		this.promedio_ejercicios = promedio_ejercicios;
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
	public double getPromedio_ejercicios() {
		return promedio_ejercicios;
	}
	public void setPromedio_ejercicios(double promedio_ejercicios) {
		this.promedio_ejercicios = promedio_ejercicios;
	}
	@Override
	public String toString() {
		return "Tema_estudiante [id_tema=" + id_tema + ", id_estudiante=" + id_estudiante + ", promedio_ejercicios="
				+ promedio_ejercicios + "]";
	}
}
