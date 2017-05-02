package com.trucutru.model;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tarea {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	public final int id;
	private String nombre;
	private Double calif;
	private int dificultad;
	
	public Tarea(){
		id = count.incrementAndGet();
	}
	
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
