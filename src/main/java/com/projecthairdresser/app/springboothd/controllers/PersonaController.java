package com.projecthairdresser.app.springboothd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecthairdresser.app.springboothd.helpers.ViewRouteHelper;
import com.projecthairdresser.app.springboothd.services.IPersonaService;

@Controller
@RequestMapping("/persona")
public class PersonaController {

	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@GetMapping({"/index",""})
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTAR_PELUQUEROS);			
		mAV.addObject("peluqueros", personaService.getAll());
		return mAV;
	}
	
	
	
}
