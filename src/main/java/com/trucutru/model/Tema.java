package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class Tema {
	
	private String nombre;
	private int nivel;
	private List<Tarea> ejercicios;
	private Double promedioEjer;
	
	//double promedio;
	
	public Double getPromedioTareas(List<Tarea> ejercicios){
		for(int i = 0; i < ejercicios.size(); i++){
			Tarea t = ejercicios.get(i);
			promedioEjer += t.getCalif();
		}
		promedioEjer = (promedioEjer / ejercicios.size());
		return promedioEjer;	
	}

	public Double getPromedioEjer() {
		return promedioEjer;
	}

	public void setPromedioEjer(Double promedioEjer) {
		this.promedioEjer = promedioEjer;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public List<Tarea> getEjercicios() {
		return ejercicios;
	}

	public void setEjercicios(List<Tarea> ejercicios) {
		this.ejercicios = ejercicios;
	}

	@Override
	public String toString() {
		return "Tema [nombre=" + nombre + ", nivel=" + nivel + ", ejercicios=" + ejercicios + ", promedioEjer="
				+ promedioEjer + "]";
	}
	
}