package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tarea {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private int idTema;
	private String nombre;
	private int dificultad;
	
	public Tarea(){
		id = count.incrementAndGet();
	}
	
	public Tarea(int idTema, String nombre, int dificultad) {
		id = count.incrementAndGet();
		this.idTema = idTema;
		this.nombre = nombre;
		this.dificultad = dificultad;
	}
	
	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
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
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Tarea [id=" + id + ", idTema=" + idTema + ", nombre=" + nombre + ", dificultad="
				+ dificultad + "]";
	}
	
}
