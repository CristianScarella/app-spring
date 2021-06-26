package com.projecthairdresser.app.springboothd.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecthairdresser.app.springboothd.converters.LocalConverter;
import com.projecthairdresser.app.springboothd.entities.Local;
import com.projecthairdresser.app.springboothd.models.LocalModel;
import com.projecthairdresser.app.springboothd.repositories.ILocalRepository;
import com.projecthairdresser.app.springboothd.services.ILocalService;

@Service("localService")
public class LocalService implements ILocalService {

	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
	@Autowired
	@Qualifier("localConverter")
	private LocalConverter localConverter;
	
//	@Autowired
//	@Qualifier("localRepository")
//	private LocalConverter localConverter;
	
	
	@Override
	public List<Local> getAll() {
		return localRepository.findAll();
	}

	@Override
	public LocalModel insertOrUpdate(LocalModel localModel) {
		Local local = localRepository.save(localConverter.ModelToEntity(localModel));
		return localConverter.entityToModel(local);
	}

	@Override
	public LocalModel findById(int id) {
		return localConverter.entityToModel(localRepository.findById(id));
	}

	@Override
	public boolean remove(int id) {
		try {
			localRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

}
