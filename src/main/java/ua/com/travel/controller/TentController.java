package ua.com.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.com.travel.dto.DtoUtilMapper;
import ua.com.travel.editor.ProviderEditor;
import ua.com.travel.entity.Provider;
import ua.com.travel.entity.Tent;
import ua.com.travel.service.ProviderService;
import ua.com.travel.service.TentService;

@Controller
public class TentController {

	@Autowired
	private TentService tentService;
	
	@Autowired
	private ProviderService providerService;
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
		binder.registerCustomEditor(Provider.class, new ProviderEditor(providerService));
	}
	
	@RequestMapping(value="/addTent", method=RequestMethod.GET)
	public String newTent (Model model){
		model.addAttribute("tent", new Tent());
		model.addAttribute("providers", providerService.findAll());
		return "views-base-addTent";
	}
	
	@RequestMapping(value="/addTent", method=RequestMethod.POST)
	public String addTent(@ModelAttribute Tent tent, Model model){
		try {
			tentService.save(tent);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage()+" !!!! ");
			return "views-base-addTent";
		}
		return "redirect:/addTent";
	}
	
	
	
	@RequestMapping(value="/shopTent", method=RequestMethod.GET)
	public String shopTent(Model model){
		model.addAttribute("tents", 
				DtoUtilMapper.tentToTentDtos(tentService.findAll()));
		return "views-shop-shopTent";
	}
	
	@RequestMapping(value="/showTent", method=RequestMethod.GET)
	public String showTent(Model model){
		model.addAttribute("tents",tentService.findTentWithProvider());
		return "views-base-showTent";
	}
	
	@RequestMapping(value="/deleteTent/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable int id){
		tentService.delete(id);
		return "redirect:/showTent";
	}
}
