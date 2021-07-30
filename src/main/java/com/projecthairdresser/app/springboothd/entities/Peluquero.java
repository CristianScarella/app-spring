package com.projecthairdresser.app.springboothd.entities;

import java.time.LocalDate;

import javax.persistence.Entity;

@Entity
public class Peluquero extends Persona{

	private float sueldo;
	private float plusSuedo;
	
	public Peluquero() {
		super();
	}


	public Peluquero(int id, String nombre, String apellido, int dni, String direccion, String telefono, String email,
			LocalDate fechaNacimiento, float sueldo, float plusSuedo) {
		super(id, nombre, apellido, dni, direccion, telefono, email, fechaNacimiento);
		this.sueldo = sueldo;
		this.plusSuedo = plusSuedo;
	}


	public float getSueldo() {
		return sueldo;
	}

	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}

	public float getPlusSuedo() {
		return plusSuedo;
	}

	public void setPlusSuedo(float plusSuedo) {
		this.plusSuedo = plusSuedo;
	}
	
	
	
	
	
	
	
}
