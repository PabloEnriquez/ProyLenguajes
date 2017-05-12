package com.trucutru.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.xml.bind.annotation.XmlRootElement;
import com.trucutru.model.*;

@XmlRootElement
public class Materia {

	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private String maestro;
	private int nivelCurso;
	
	public Materia(){
		id = count.incrementAndGet();
	}
	
	public Materia(String nombre, String maestro, int nivelCurso) {
		id = count.incrementAndGet();
		this.nombre = nombre;
		this.maestro = maestro;
		this.nivelCurso = nivelCurso;
	}

	public Materia(String nombre, int nivelCurso) {
		super();
		id = count.incrementAndGet();
		this.nombre = nombre;
		this.nivelCurso = nivelCurso;
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

	public int getNivelCurso() {
		return nivelCurso;
	}

	public void setNivelCurso(int nivelCurso) {
		this.nivelCurso = nivelCurso;
	}
	
	public String getMaestro() {
		return maestro;
	}

	public void setMaestro(String maestro) {
		this.maestro = maestro;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombre=" + nombre + ", maestro=" + maestro + ", nivelCurso=" + nivelCurso + "]";
	}
}
