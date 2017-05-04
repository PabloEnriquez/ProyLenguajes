package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tarea {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id_tarea;
	private int id_tema;
	private String nombre;
//	private Double calif;
	private int dificultad;
	
	public Tarea(){
		id_tarea = count.incrementAndGet();
		id_tema = 0;
	}
	
	public Tarea(int id_tema, String nombre, int dificultad) {
		id_tarea = count.incrementAndGet();
		this.id_tema = id_tema;
		this.nombre = nombre;
		this.dificultad = dificultad;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public int getId_tema() {
		return id_tema;
	}
	public void setId_tema(int id_tema) {
		this.id_tema = id_tema;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public Double getCalif() {
//		return calif;
//	}
//	public void setCalif(Double calif) {
//		this.calif = calif;
//	}
	public int getDificultad() {
		return dificultad;
	}
	public void setDificultad(int dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Tarea [id_Tarea=" + id_tarea + ", id_Tema=" + id_tema + ", nombre=" + nombre + ", dificultad="
				+ dificultad + "]";
	}
	
}
