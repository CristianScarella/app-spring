package com.projecthairdresser.app.springboothd.converters;

import org.springframework.stereotype.Component;

import com.projecthairdresser.app.springboothd.entities.Local;
import com.projecthairdresser.app.springboothd.models.LocalModel;

@Component("localConverter")
public class LocalConverter {

	public LocalModel entityToModel(Local local) {
		return new LocalModel(local.getId(),local.getTelefono(),local.getDireccion(),local.getLatitud(),local.getLongitud());
	}
	
	public Local ModelToEntity(LocalModel localModel) {
		return new Local(localModel.getId(),localModel.getTelefono(),localModel.getDireccion(),localModel.getLatitud(),localModel.getLongitud());
	}
}
