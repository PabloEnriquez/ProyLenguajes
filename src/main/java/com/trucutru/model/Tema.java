package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tema {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private int nivel;
	private List<Tarea> ejercicios;
	private Double promedioEjer;
	
	//double promedio;
	
	public Tema(){
		id = count.incrementAndGet();
	}
	
	public Tema(String nombre, int nivel, List<Tarea> ejercicios, Double promedioEjer) {
		id = count.incrementAndGet();
		this.nombre = nombre;
		this.nivel = nivel;
		this.ejercicios = ejercicios;
		this.promedioEjer = promedioEjer;
	}

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
