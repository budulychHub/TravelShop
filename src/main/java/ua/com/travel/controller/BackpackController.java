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

import ua.com.travel.editor.ProviderEditor;
import ua.com.travel.entity.Backpack;
import ua.com.travel.entity.Provider;
import ua.com.travel.service.BackpackService;
import ua.com.travel.service.ProviderService;

@Controller
public class BackpackController {

	@Autowired
	private BackpackService backpackService;

	@Autowired
	private ProviderService providerService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Provider.class, new ProviderEditor(providerService));
	}

	@RequestMapping(value = "/addBackpack", method = RequestMethod.GET)
	public String newBackpack(Model model) {
		model.addAttribute("backpacks", backpackService.findAll());
		model.addAttribute("backpack", new Backpack());
		model.addAttribute("providers", providerService.findAll());
		return "views-base-addBackpack";
	}

	@RequestMapping(value = "/addBackpack", method = RequestMethod.POST)
	public String addBackpack(@ModelAttribute Backpack backpack, Model model) {

		try {
			backpackService.save(backpack);
		} catch (Exception e) {
			model.addAttribute("exception", e.getMessage() + " !!!! ");
			return "views-base-addBackpack";
		}
		return "redirect:/addBackpack";
	}

	@RequestMapping(value = "/shopBackpack", method = RequestMethod.GET)
	public String shop(Model model) {

		model.addAttribute("backpacks", backpackService.findAll());
		return "views-shop-shopBackpack";
	}

	@RequestMapping(value = "/showBackpack", method = RequestMethod.GET)
	public String showBackpack(Model model) {
		model.addAttribute("backpacks", backpackService.findBackpackWithProvider());
		return "views-base-showBackpack";
	}

	@RequestMapping(value = "deleteBackpack/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		backpackService.delete(id);
		return "redirect:/showBackpack";
	}

}
