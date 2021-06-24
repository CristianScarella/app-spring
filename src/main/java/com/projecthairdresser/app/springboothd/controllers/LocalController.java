package com.projecthairdresser.app.springboothd.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projecthairdresser.app.springboothd.helpers.ViewRouteHelper;
import com.projecthairdresser.app.springboothd.models.LocalModel;
import com.projecthairdresser.app.springboothd.services.ILocalService;

@Controller
@RequestMapping("/local")
public class LocalController {

	@Autowired
	private ILocalService localService;
	
	@GetMapping("/listar")
	public ModelAndView index() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.LISTAR_LOCAL);			
		mAV.addObject("locales", localService.getAll());
		return mAV;
	}
	
	@InitBinder
	public void myBinder(WebDataBinder binder) {
		StringTrimmerEditor recortaEspaciosBlanco = new StringTrimmerEditor(true);
		
		binder.registerCustomEditor(String.class, recortaEspaciosBlanco);
	}
	
//	@GetMapping("/add")
//	public String degree(Model model) {
//		model.addAttribute("local", new LocalModel());
//		return ViewRouteHelper.LOCAL;
//	}
//
//	@PostMapping("/newlocal")
//	public ModelAndView newLocal(@Valid @ModelAttribute("local") LocalModel local,
//			BindingResult bindingResult) {
//		ModelAndView mV = new ModelAndView();
//		if(bindingResult.hasErrors()) {
//			mV.setViewName(ViewRouteHelper.LOCAL);
//		}else {
//			mV.setViewName(ViewRouteHelper.NEW_LOCAL);
//			mV.addObject("local", local);
//		}
//		return mV;
//	}
	
	
}
