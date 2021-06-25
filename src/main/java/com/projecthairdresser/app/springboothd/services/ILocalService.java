package com.projecthairdresser.app.springboothd.services;

import java.util.List;

import com.projecthairdresser.app.springboothd.entities.Local;
import com.projecthairdresser.app.springboothd.models.LocalModel;

public interface ILocalService {

	public List<Local> getAll();
	
	public LocalModel insertOrUpdate(LocalModel localModel);
	
	public LocalModel findById(int id);
}
