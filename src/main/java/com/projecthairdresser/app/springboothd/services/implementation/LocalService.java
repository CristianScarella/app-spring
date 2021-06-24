package com.projecthairdresser.app.springboothd.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecthairdresser.app.springboothd.entities.Local;
import com.projecthairdresser.app.springboothd.repositories.ILocalRepository;
import com.projecthairdresser.app.springboothd.services.ILocalService;

@Service("localService")
public class LocalService implements ILocalService {

	@Autowired
	@Qualifier("localRepository")
	private ILocalRepository localRepository;
	
//	@Autowired
//	@Qualifier("localRepository")
//	private LocalConverter localConverter;
	
	
	@Override
	public List<Local> getAll() {
		return localRepository.findAll();
	}

}
