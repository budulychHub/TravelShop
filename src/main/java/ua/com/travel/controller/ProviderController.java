package ua.com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.travel.entity.Provider;
import ua.com.travel.service.ProviderService;

@Controller
public class ProviderController {

	@Autowired
	private ProviderService  providerService;
	
	@RequestMapping(value="/addProvider", method=RequestMethod.GET)
	public String newProvider(Model model){
		model.addAttribute("provider", new Provider());
		return "views-base-addProvider";
	}
	
	@RequestMapping(value="/addProvider", method=RequestMethod.POST)
	public String addProvider(@ModelAttribute Provider provider,
			Model model){
		try {
			providerService.save(provider);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage()+" !!!! ");
			return "views-base-addProvider";
		}
		return "redirect:/addProvider";
	}
}
