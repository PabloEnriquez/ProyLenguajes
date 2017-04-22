package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Tarea {
	
	private String nombre;
	private Double calif;
	private int dificultad;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getCalif() {
		return calif;
	}
	public void setCalif(Double calif) {
		this.calif = calif;
	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}
	@Override
	public String toString() {
		return "Tarea [nombre=" + nombre + ", calif=" + calif + ", dificultad=" + dificultad + "]";
	}
}
