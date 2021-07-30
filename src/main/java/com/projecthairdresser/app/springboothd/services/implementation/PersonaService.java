package com.projecthairdresser.app.springboothd.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.projecthairdresser.app.springboothd.entities.Peluquero;
import com.projecthairdresser.app.springboothd.repositories.IPeluqueroRepository;
import com.projecthairdresser.app.springboothd.services.IPersonaService;

@Service("personaService")
public class PersonaService implements IPersonaService{
	
	@Autowired
	@Qualifier("peluqueroRepository")
	public IPeluqueroRepository peluqueroRepository;

	@Override
	public List<Peluquero> getAll() {
		return peluqueroRepository.findAll();
	}
	
	
}
