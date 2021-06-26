package com.projecthairdresser.app.springboothd.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.projecthairdresser.app.springboothd.helpers.ViewRouteHelper;
import com.projecthairdresser.app.springboothd.models.LocalModel;
import com.projecthairdresser.app.springboothd.services.ILocalService;

@Controller
@SessionAttributes("local")
@RequestMapping("/local")
public class LocalController {

	@Autowired
	@Qualifier("localService")
	private ILocalService localService;
	
	@GetMapping({"/index",""})
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
	
	@GetMapping("/crear")
	public ModelAndView create() {
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.NEW_LOCAL);
		mAV.addObject("local", new LocalModel());
		return mAV;
	}
	
	
	@PostMapping("/save")
	public String create(@Valid @ModelAttribute("local") LocalModel LocalModel, BindingResult bindingResult, SessionStatus sessionStatus) {

		if(bindingResult.hasErrors()) {
			return ViewRouteHelper.NEW_LOCAL;
		}
		localService.insertOrUpdate(LocalModel);
		sessionStatus.setComplete();
		return ViewRouteHelper.LOCAL_REDIRECT;
	}
	
//	@GetMapping("/edit/{id}")
//	public String edit(@PathVariable int id, Model model) {
//		
//		LocalModel local=localService.findById(id);
//		model.addAttribute("local", local);
//		return "local/crear";
//	}
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable int id) {
		ModelAndView mV = new ModelAndView(ViewRouteHelper.NEW_LOCAL);
		LocalModel local=localService.findById(id);
		mV.addObject("local", local);
		//model.addAttribute("local", local);
		return mV;
	}
	
	@GetMapping("/eliminar/{id}")
	public RedirectView eliminar(@PathVariable int id, Model model) {
		
		localService.remove(id);
		return new RedirectView(ViewRouteHelper.LOCAL_ROOT);
	}
	
}
