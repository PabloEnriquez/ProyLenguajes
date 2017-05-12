package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Estudiante {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private Double promedioGlobal;
	public List<String> recomendaciones;
	
	public Estudiante(){
		id = count.incrementAndGet();
	}
	
	public Estudiante(String nombre, Double promedioGlobal, List<String> recomendaciones) {
		id = count.incrementAndGet();
		this.nombre = nombre;
		this.promedioGlobal = promedioGlobal;
		this.recomendaciones = recomendaciones;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPromedioGlobal() {
		return promedioGlobal;
	}

	public void setPromedioGlobal(Double promedioGlobal) {
		this.promedioGlobal = promedioGlobal;
	}

	public List<String> getRecomendaciones() {
		return recomendaciones;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", promedioGlobal=" + promedioGlobal
				+ ", recomendaciones=" + recomendaciones + "]";
	}

	public void setRecomendaciones(List<String> recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
}
