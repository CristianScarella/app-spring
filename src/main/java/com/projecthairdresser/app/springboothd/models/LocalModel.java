package com.projecthairdresser.app.springboothd.models;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LocalModel {

	private int id;
	
	@NotEmpty
	@Size(min=8,max=10)
	@Pattern(regexp= "[0-9]{10}")
	private String telefono;
	
	@NotEmpty
	@Size(min=3,max=10)
//	@Pattern(regexp= "[a-zA-Z_0-9]{3,20}[\\s][0-9]{1,5}")
	private String direccion;
	
	@NotNull
	@DecimalMin(value = "0.01")
	private Double latitud;
	
	@NotNull
	@DecimalMin(value = "0.01")
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
