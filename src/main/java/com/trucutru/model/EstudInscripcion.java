package com.trucutru.model;
import com.trucutru.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EstudInscripcion {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private Double promedioGlobal;
	private Materia materiaAInscribir;
	private List<String> recomendaciones;
	
	public EstudInscripcion(){
		id = count.incrementAndGet();
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
	public Materia getMateriaAInscribir() {
		return materiaAInscribir;
	}
	public void setMateriaAInscribir(Materia materiaAInscribir) {
		this.materiaAInscribir = materiaAInscribir;
	}
	@Override
	public String toString() {
		return "EstudInscripcion [nombre=" + nombre + ", promedioGlobal=" + promedioGlobal + ", materiaAInscribir="
				+ materiaAInscribir + "]";
	}
	public List<String> getRecomendaciones() {
		return recomendaciones;
	}
	public void setRecomendaciones(List<String> recomendaciones) {
		this.recomendaciones = recomendaciones;
	}
}
