package com.trucutru.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.trucutru.model.*;

@XmlRootElement
public class Tema {
	
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private int idMateria;
	private String nombre;
	private int nivel;
	
	public Tema(){
		id = count.incrementAndGet();
		idMateria = 0;
	}
	
	public Tema(int idMateria, String nombre, int nivel) {
		id = count.incrementAndGet();
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.nivel = nivel;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getId() {
		return id;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
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
		return "Tema [id=" + id + ", idMateria=" + idMateria + ", nombre=" + nombre + ", nivel=" + nivel
				+ "]";
	}
	
}
