package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tema {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id_tema;
	private int id_materia;
	private String nombre;
	private int nivel;
//	private List<Tarea> ejercicios;
//	private Double promedioEjer;
	
	//double promedio;
	
	public Tema(){
		id_tema = count.incrementAndGet();
		id_materia = 0;
	}
	
	public Tema(int id_materia, String nombre, int nivel) {
		id_tema = count.incrementAndGet();
		this.id_materia = id_materia;
		this.nombre = nombre;
		this.nivel = nivel;
	}

//	public Double getPromedioTareas(List<Tarea> ejercicios){
//		for(int i = 0; i < ejercicios.size(); i++){
//			Tarea t = ejercicios.get(i);
//			promedioEjer += t.getCalif();
//		}
//		promedioEjer = (promedioEjer / ejercicios.size());
//		return promedioEjer;	
//	}

//	public Double getPromedioEjer() {
//		return promedioEjer;
//	}
//
//	public void setPromedioEjer(Double promedioEjer) {
//		this.promedioEjer = promedioEjer;
//	}

	public String getNombre() {
		return nombre;
	}

	public int getId_tema() {
		return id_tema;
	}

	public int getId_materia() {
		return id_materia;
	}

	public void setId_materia(int id_materia) {
		this.id_materia = id_materia;
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

	@Override
	public String toString() {
		return "Tema [id_tema=" + id_tema + ", id_materia=" + id_materia + ", nombre=" + nombre + ", nivel=" + nivel
				+ "]";
	}

//	public List<Tarea> getEjercicios() {
//		return ejercicios;
//	}
//
//	public void setEjercicios(List<Tarea> ejercicios) {
//		this.ejercicios = ejercicios;
//	}
	
}
