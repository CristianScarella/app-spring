package com.projecthairdresser.app.springboothd.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class LocalModel {

	private int id;
	@NotEmpty
	//@Pattern(regexp = "[0-9]{10}")
	private String telefono;
	@NotNull
	//@Pattern(regexp = "[a-zA-Z0-9]{4,}")
	private String direccion;
	@NotNull
	private Double latitud;
	@NotNull
	private Double longitud;
	
	public LocalModel() {}

	public LocalModel(int id,String telefono, String direccion, Double latitud, Double longitud) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.direccion = direccion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}


	
	
}
